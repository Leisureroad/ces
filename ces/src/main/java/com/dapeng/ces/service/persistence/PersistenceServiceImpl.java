package com.dapeng.ces.service.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dapeng.ces.dto.GeneResult;
import com.dapeng.ces.dto.ScoreResult;
import com.dapeng.ces.dto.UserCompareGene;
import com.dapeng.ces.dto.UserCompareParam;
import com.dapeng.ces.dto.UserCompareResult;
import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.dto.UserScoreCompareResult;
import com.dapeng.ces.dto.UserScoreNewResult;
import com.dapeng.ces.dto.UserScorePlayerResult;
import com.dapeng.ces.mapper.GeneMapper;
import com.dapeng.ces.mapper.ScoreMapper;
import com.dapeng.ces.mapper.UserMapper;
import com.dapeng.ces.mapper.UserScoreMapper;
import com.dapeng.ces.model.Gene;
import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.User;
import com.dapeng.ces.model.UserScore;
import com.dapeng.ces.service.freemarker.WordAction;
import com.dapeng.ces.service.poi.ScoreDataParser;
import com.dapeng.ces.service.poi.UserDataParser;
import com.dapeng.ces.service.poi.UserScoreDataExporter;
import com.dapeng.ces.util.PrimaryKeyGenerator;

@Service
public class PersistenceServiceImpl implements PersistenceService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GeneMapper geneMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private UserScoreMapper userScoreMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW, // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
            isolation = Isolation.READ_COMMITTED) // 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
    @Override
    public List<UserResult> saveUserGene() {
        String path = "./data/测试数据 (1).xls";
        List<UserResult> list = null;
        try {
            list = UserDataParser.parseExcelData(new File(path), 0);
            // 删除user表、gene表
            userMapper.delete();
            geneMapper.delete();
            // 循环插入user表、gene表数据
            for (UserResult userResult : list) {
                User user = new User();
                user.setUuid(PrimaryKeyGenerator.getUuid32());
                user.setUserId(userResult.getId());
                user.setName(userResult.getName());
                user.setSex(userResult.getSex());
                user.setPosition384(userResult.getPosition_384());
                user.setStar(userResult.getName().indexOf("*") > 0 ? "1" : "2");
                userMapper.insertSelective(user);
                List<GeneResult> geneList = userResult.getGeneList();
                for (GeneResult geneResult : geneList) {
                    Gene gene = new Gene();
                    gene.setUuid(PrimaryKeyGenerator.getUuid32());
                    gene.setUserId(user.getUserId());
                    gene.setName(geneResult.getName());
                    gene.setValue(geneResult.getValue());
                    geneMapper.insertSelective(gene);
                }
            }
        } catch (IOException e) {
        }
        return list;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
            isolation = Isolation.READ_COMMITTED) // 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
    @Override
    public List<Score> saveScore() {
        String scoreExcelFile = "./data/总体体质评估表+原始数据2 (1).xls";
        List<ScoreResult> scoreList = null;
        List<Score> list = null;
        try {
            scoreList = ScoreDataParser.parseExcelData(new File(scoreExcelFile), 0);
            scoreMapper.delete();
            // 数据转换
            list = this.dataConvert(scoreList);
            for (Score score : list) {
                score.setUuid(PrimaryKeyGenerator.getUuid32());
                scoreMapper.insertSelective(score);
            }
        } catch (IOException e) {
        }
        return list;
    }

    private List<Score> dataConvert(List<ScoreResult> scoreList) {
        List<Score> newList = new ArrayList<Score>();
        Map<String, Score> dataMap = new HashMap<String, Score>();
        for (ScoreResult scoreResult : scoreList) {
            String id = scoreResult.getId();
            String explosiveForce = scoreResult.getExplosiveForce();
            Double explosiveForceScore = scoreResult.getExplosiveForceScore();
            String stamina = scoreResult.getStamina();
            Double staminaScore = scoreResult.getStaminaScore();
            String motionSensitivity = scoreResult.getMotionSensitivity();
            Double motionSensitivityScore = scoreResult.getMotionSensitivityScore();
            String injuryRecoveryAbility = scoreResult.getInjuryRecoveryAbility();
            Double injuryRecoveryAbilityScore = scoreResult.getInjuryRecoveryAbilityScore();
            String injuryRisk = scoreResult.getInjuryRisk();
            Double injuryRiskScore = scoreResult.getInjuryRiskScore();
            String obesityRisk = scoreResult.getObesityRisk();
            Double obesityRiskScore = scoreResult.getObesityRiskScore();
            String fatReducingSensitivity = scoreResult.getFatReducingSensitivity();
            Double fatReducingSensitivityScore = scoreResult.getFatReducingSensitivityScore();
            Score score = (Score) dataMap.get(id);
            if (score == null) {
                score = new Score();
            }
            score.setScoreId(id);
            score.setNumber(scoreResult.getNumber());
            score.setGeneCode(scoreResult.getGeneCode());
            score.setGeneName(scoreResult.getGeneName());
            score.setGeneType(scoreResult.getGeneType());
            if (explosiveForce != null) {
                score.setExplosiveForce(explosiveForce);
            }
            if (explosiveForceScore != null) {
                score.setExplosiveForceScore(explosiveForceScore);
            }
            if (stamina != null) {
                score.setStamina(stamina);
            }
            if (staminaScore != null) {
                score.setStaminaScore(staminaScore);
            }
            if (motionSensitivity != null) {
                score.setMotionSensitivity(motionSensitivity);
            }
            if (motionSensitivityScore != null) {
                score.setMotionSensitivityScore(motionSensitivityScore);
            }
            if (injuryRecoveryAbility != null) {
                score.setInjuryRecoveryAbility(injuryRecoveryAbility);
            }
            if (injuryRecoveryAbilityScore != null) {
                score.setInjuryRecoveryAbilityScore(injuryRecoveryAbilityScore);
            }
            if (injuryRisk != null) {
                score.setInjuryRisk(injuryRisk);
            }
            if (injuryRiskScore != null) {
                score.setInjuryRiskScore(injuryRiskScore);
            }
            if (obesityRisk != null) {
                score.setObesityRisk(obesityRisk);
            }
            if (obesityRiskScore != null) {
                score.setObesityRiskScore(obesityRiskScore);
            }
            if (fatReducingSensitivity != null) {
                score.setFatReducingSensitivity(fatReducingSensitivity);
            }
            if (fatReducingSensitivityScore != null) {
                score.setFatReducingSensitivityScore(fatReducingSensitivityScore);
            }
            dataMap.put(id, score);
        }
        // 遍历map，放入新的集合中
        for (Score score : dataMap.values()) {
            newList.add(score);
        }
        return newList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
            isolation = Isolation.READ_COMMITTED) // 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
    @Override
    public List<UserScore> saveUserScore() {
        userScoreMapper.delete();
        List<UserScore> list = new ArrayList<>();
        List<User> allUser = userMapper.selectAllUser();
        for (User user : allUser) {
            String userId = user.getUserId();
            List<Gene> geneList = geneMapper.selectByUserId(userId);
            for (Gene gene : geneList) {
                String geneUuid = gene.getUuid();
                String name = gene.getName();
                String value = gene.getValue();
                List<Score> scoreList = scoreMapper.selectAllScore();
                if(scoreList == null){
                    continue;
                }
                for (Score score : scoreList) {
                    String scoreId = score.getScoreId();
                    boolean result = ScoreDataParser.getMatchedKey(name + value, scoreId);
                    if(!result){
                        continue;
                    }
                    String scoreUuid = score.getUuid();
                    UserScore userScore = new UserScore();
                    userScore.setUuid(PrimaryKeyGenerator.getUuid32());
                    userScore.setUserId(userId);
                    userScore.setGeneUuid(geneUuid);
                    userScore.setScoreUuid(scoreUuid);
                    list.add(userScore);
                    userScoreMapper.insertSelective(userScore);
                }
            }
        }
        return list;
    }

    @Override
    public List<UserCompareResult> userCompare(String userName, List<String> list) {
        List<UserCompareResult> returnList = new ArrayList<>();
        // 获取用户的位点基因信息
        List<UserScoreNewResult> userInfoList = userMapper.selectUserInfo(userName);
        // 获取所有运动员的信息
        List<UserScorePlayerResult> userPlayerList = userMapper.selectUserPlayer("1");
        // 对比用户和运动员信息，获取匹配的位点信息
        Map<String, UserCompareParam> map = new HashMap<>();
        for (UserScoreNewResult userScoreNewResult : userInfoList) {
            String geneName = userScoreNewResult.getGeneName();// 用户的geneName
            String geneType = userScoreNewResult.getGeneType();
            for (UserScorePlayerResult userScorePlayerResult : userPlayerList) {
                String userIdPlayer = userScorePlayerResult.getUserId();
                UserCompareParam matchUser = map.get(userIdPlayer);
                if (matchUser == null) {
                    matchUser = new UserCompareParam();
                    matchUser.setUserId(userIdPlayer);
                    matchUser.setCount(0);
                    matchUser.setUserCompareGeneList(new ArrayList<UserCompareGene>());
                }
                String geneTypePlayer = this.getGeneType(geneName, userScorePlayerResult);
                if (isIncludeGeneName(list, geneName) && geneType.equals(geneTypePlayer)) {
                    int count = matchUser.getCount().intValue() + 1;
                    matchUser.setCount(count);
                    UserCompareGene ucg = new UserCompareGene();
                    ucg.setGeneName(geneName);
                    ucg.setGeneType(geneTypePlayer);
                    matchUser.getUserCompareGeneList().add(ucg);
                    map.put(userIdPlayer, matchUser);
                }
            }
        }
        System.out.println(map.size());
        // 遍历map，获取最大的value值
        Iterator<Entry<String, UserCompareParam>> it = map.entrySet().iterator();
        int maxValue = 0;
        String maxKey = null;
        for(int i=0;i<map.size();i++){
            Entry<String, UserCompareParam> entry = (Map.Entry<String, UserCompareParam>)it.next();
            UserCompareParam userCom = entry.getValue();
            int value = userCom.getCount();
            if(value > maxValue){
                maxValue = value;
                maxKey = entry.getKey().toString();
            }
        }
        System.out.println("maxValue"+maxValue);
        //获取重复的最大值
        List<UserCompareParam> userIdList = new ArrayList<>();
        for (Map.Entry<String, UserCompareParam> entry : map.entrySet()) {
            UserCompareParam userCom = entry.getValue();
            if(maxValue == userCom.getCount()){
                userIdList.add(userCom);
            }
        }
        for (UserCompareParam userCompareParam : userIdList) {
            for (UserScorePlayerResult userScorePlayerResult : userPlayerList) {
                if(!userCompareParam.getUserId().equals(userScorePlayerResult.getUserId())){
                    continue;
                }
                UserCompareResult ucr = new UserCompareResult();
                ucr.setUserId(userScorePlayerResult.getUserId());
                ucr.setName(userScorePlayerResult.getName());
                ucr.setSex(userScorePlayerResult.getSex());
                ucr.setRsTotal(list.size());
                ucr.setRsMax(maxValue);
                List<UserCompareGene> userCompareGeneList = userCompareParam.getUserCompareGeneList();//获取匹配的位点
                List<UserScoreCompareResult> userScoreCompareList = new ArrayList<>();//返回的list集合
                List<UserScoreNewResult> usrNew = userScorePlayerResult.getUserScoreNewResultList();
                for (UserScoreNewResult userScoreNewResult : usrNew) {
                    for (UserCompareGene userCompareGene : userCompareGeneList) {
                        String geneName = userCompareGene.getGeneName();
                        String geneType = userCompareGene.getGeneType();
                        if(geneName.equals(userScoreNewResult.getGeneName()) && geneType.equals(userScoreNewResult.getGeneType())){
                            UserScoreCompareResult uscr = new UserScoreCompareResult();
                            uscr.setGeneCode(userScoreNewResult.getGeneCode());
                            uscr.setGeneName(userScoreNewResult.getGeneName());
                            uscr.setGeneType(userScoreNewResult.getGeneType());
                            userScoreCompareList.add(uscr);
                        }
                    }
                }
                ucr.setUserScoreCompareList(userScoreCompareList);
                returnList.add(ucr);
            }
        }
        return returnList;
    }
    
    /**
     * 
     * 方法描述: 获取geneType<br>
     * 方法备注: <br>
     * @param geneName
     * @param userScorePlayerResult
     * @return
     * 创建人：陈亚东<br>
     * 创建时间：2017年4月8日 下午10:34:23<br>
     * 修改人：<br>
     * 修改时间：<br>
     */
    private String getGeneType(String geneName, UserScorePlayerResult userScorePlayerResult) {
        String geneType = "";
        List<UserScoreNewResult> scoreList = userScorePlayerResult.getUserScoreNewResultList();
        for (UserScoreNewResult userScoreNewResult2 : scoreList) {
            String geneNamePlayer = userScoreNewResult2.getGeneName();
            if (geneName.equals(geneNamePlayer)) {
                geneType = userScoreNewResult2.getGeneType();
            }
        }
        return geneType;
    }
    
    private boolean isIncludeGeneName(List<String> list,String geneName){
        boolean result = false;
        if(list.contains(geneName)){
            result = true;
        }
        return result;
    }

    @Override
    public List<UserScoreNewResult> getUserScore(String userName) {
    	List<UserScoreNewResult> result = userMapper.selectUserInfo(userName);
    	
    	UserScoreDataExporter exporter = new UserScoreDataExporter();
    	try {
			exporter.export2Excel(result, userName);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			for (UserScoreNewResult userScoreNewResult : result) {
				String geneCode = userScoreNewResult.getGeneCode();
				String geneName = userScoreNewResult.getGeneName();
				List<UserScoreNewResult> geneTypeList = getUserGeneType(userName, geneCode, geneName);
				String geneType = ((UserScoreNewResult)geneTypeList.get(0)).getGeneType();
				System.out.println(geneTypeList.size()+"------"+userName+"-------"+geneCode+"-------"+geneName+"---------"+geneType);
				if (geneType != null) {
					dataMap.put(geneCode + "_" + geneName, geneType);
				}
				else {
					dataMap.put(geneCode + "_" + geneName, "未测试");
				}
//				System.out.println("userName: " + userName + ", geneCode: " + geneCode + ", geneName: " + geneName + getUserGeneType(userName, geneCode, geneName));
			}
			WordAction action = new WordAction();
			action.createWord(dataMap, userName);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return result;
    }

    @Override
    public List<UserScoreNewResult> getUserGeneType(String userName, String geneCode, String geneName) {
        List<UserScoreNewResult> geneType = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("userName", userName);
        map.put("geneCode", geneCode);
        map.put("geneName", geneName);
        try {
            geneType = userMapper.getUserGeneType(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geneType;
    }
}
