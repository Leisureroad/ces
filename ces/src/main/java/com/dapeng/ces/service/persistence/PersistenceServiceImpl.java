package com.dapeng.ces.service.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.dapeng.ces.dto.GeneResult;
import com.dapeng.ces.dto.NationalRankingExcel;
import com.dapeng.ces.dto.ScoreFemaleExcel;
import com.dapeng.ces.dto.ScoreResult;
import com.dapeng.ces.dto.UserCompareGene;
import com.dapeng.ces.dto.UserCompareParam;
import com.dapeng.ces.dto.UserCompareResult;
import com.dapeng.ces.dto.UserOriginalResult;
import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.dto.UserScoreCompareResult;
import com.dapeng.ces.dto.UserScoreDtoResult;
import com.dapeng.ces.dto.UserScoreFemaleResult;
import com.dapeng.ces.dto.UserScorePerItemResult;
import com.dapeng.ces.dto.UserScorePlayerResult;
import com.dapeng.ces.mapper.GeneMapper;
import com.dapeng.ces.mapper.NationalRankingMapper;
import com.dapeng.ces.mapper.ScoreFemaleMapper;
import com.dapeng.ces.mapper.ScoreGroupMapper;
import com.dapeng.ces.mapper.ScoreMapper;
import com.dapeng.ces.mapper.UserMapper;
import com.dapeng.ces.mapper.UserScoreFemaleMapper;
import com.dapeng.ces.mapper.UserScoreGroupMapper;
import com.dapeng.ces.mapper.UserScoreMapper;
import com.dapeng.ces.model.Gene;
import com.dapeng.ces.model.GeneFeature;
import com.dapeng.ces.model.NationalRanking;
import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.ScoreFemale;
import com.dapeng.ces.model.ScoreGroup;
import com.dapeng.ces.model.User;
import com.dapeng.ces.model.UserScore;
import com.dapeng.ces.model.UserScoreFemale;
import com.dapeng.ces.model.UserScoreGroup;
import com.dapeng.ces.service.freemarker.WordAction;
import com.dapeng.ces.service.poi.GeneFeatureDataParser;
import com.dapeng.ces.service.poi.RankingDataParser;
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
    @Autowired
    private UserScoreDataExporter exporter;
    @Autowired
    private NationalRankingMapper nationalRankingMapper;
    @Autowired
    private ScoreFemaleMapper scoreFemaleMapper;
    @Autowired
    private UserScoreFemaleMapper userScoreFemaleMapper;
    @Autowired
    private ScoreGroupMapper scoreGroupMapper;
    @Autowired
    private UserScoreGroupMapper userScoreGroupMapper;
    
    @Value("${total-score.explosiveForceScore}")
    private Double explosiveForceScore_percentage;
    
    @Value("${total-score.staminaScore}")
    private Double staminaScore_percentage;
    
    @Value("${total-score.injuryRecoveryAbilityScore}")
    private Double injuryRecoveryAbilityScore_percentage;
    
    @Value("${total-score.injuryRiskScore}")
    private Double injuryRiskScore_percentage;
    
    @Value("${total-score.injuryRiskScore_female}")
	private Double injuryRiskScore_female_percentage;
    
    @Value("${total-score.obesityRiskScore}")
    private Double obesityRiskScore_percentage;
    
    @Value("${total-score.fatReducingSensitivityScore}")
    private Double fatReducingSensitivityScore_percentage;

    @Transactional(propagation = Propagation.REQUIRES_NEW, // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
            isolation = Isolation.READ_COMMITTED) // 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
    @Override
    public List<UserResult> saveUserGene() {
//        String path = "./data/测试数据 (1).xls";
        List<UserResult> list = null;
        try {
//            list = UserDataParser.parseExcelData(new File(path), 0);
        	list = UserDataParser.parseExcelData();
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
                    gene.setCode(geneResult.getCode());
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
        List<ScoreResult> scoreList = null;
        List<Score> list = null;
        try {
//            scoreList = ScoreDataParser.parseExcelData(new File("./data/总体体质评估表+原始数据2 (1).xls"), 0);
        	scoreList = ScoreDataParser.parseExcelData();
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
        userScoreFemaleMapper.delete();
        userScoreGroupMapper.delete();
        List<UserScore> list = new ArrayList<>();
        List<User> allUser = userMapper.selectAllUser();
        for (User user : allUser) {
            String userId = user.getUserId();
            String sex = user.getSex();
            List<Gene> geneList = geneMapper.selectByUserId(userId);
            for (Gene gene : geneList) {
                String geneUuid = gene.getUuid();
                String name = gene.getName();
                String value = gene.getValue();
                String code = gene.getCode();
                if("APOE".equals(code) && "rs429358".equals(name)) {
                	List<ScoreGroup> scoreGroupList = scoreGroupMapper.selectAllScoreGroup();
                	if(scoreGroupList == null){
                        continue;
                    }
                	 List<UserScoreDtoResult> geneType_APOEList = this.getUserOriginalType(user.getName(), "APOE", "rs7412");
                     String geneType_APOE = ((UserScoreDtoResult)geneType_APOEList.get(0)).getGeneType();
                     for (ScoreGroup scoreGroup : scoreGroupList) {
                         String scoreGroupUuid = scoreGroup.getUuid();
                         if(value.equals(scoreGroup.getGeneType1()) && geneType_APOE.equals(scoreGroup.getGeneType2())){
                             UserScoreGroup usg = new UserScoreGroup();
                             usg.setUuid(PrimaryKeyGenerator.getUuid32());
                             usg.setUserId(userId);
                             usg.setGeneUuid(geneUuid);
                             usg.setScoreGroupUuid(scoreGroupUuid);
                             userScoreGroupMapper.insertSelective(usg);
                         }
                     }
                }
                if("COL12A1".equals(code) && "女".equals(sex)){
                    List<ScoreFemale> scoreFemaleList = scoreFemaleMapper.selectAllScoreFemale();
                    if(scoreFemaleList == null){
                        continue;
                    }
                    List<UserScoreDtoResult> geneType_5AList = this.getUserOriginalType(user.getName(), "COL5A1", "rs12722");
                    String geneType_5A = ((UserScoreDtoResult)geneType_5AList.get(0)).getGeneType();
                    for (ScoreFemale scoreFemale : scoreFemaleList) {
                        String scoreFemaleUuid = scoreFemale.getUuid();
                        if(geneType_5A.equals(scoreFemale.getGeneType1()) && value.equals(scoreFemale.getGeneType2())){
                            UserScoreFemale usf = new UserScoreFemale();
                            usf.setUuid(PrimaryKeyGenerator.getUuid32());
                            usf.setUserId(userId);
                            usf.setGeneUuid(geneUuid);
                            usf.setScoreFemaleUuid(scoreFemaleUuid);
                            userScoreFemaleMapper.insertSelective(usf);
                        }
                    }
                }else if("COL12A1".equals(code) && "男".equals(sex)){
                    continue;
                }else{
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
        }
        return list;
    }

    @Override
    public List<UserCompareResult> userCompare(String userName, List<String> list) {
        List<UserCompareResult> returnList = new ArrayList<>();
        // 获取用户的位点基因信息
        List<UserScoreDtoResult> userInfoList = userMapper.selectUserScoreInfo(userName);
        // 获取所有运动员的信息
        List<UserScorePlayerResult> userPlayerList = userMapper.selectUserPlayer("1");
        // 对比用户和运动员信息，获取匹配的位点信息
        Map<String, UserCompareParam> map = new HashMap<>();
        for (UserScoreDtoResult userScoreNewResult : userInfoList) {
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
                List<UserScoreDtoResult> usrNew = userScorePlayerResult.getUserScoreNewResultList();
                for (UserScoreDtoResult userScoreNewResult : usrNew) {
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
        List<UserScoreDtoResult> scoreList = userScorePlayerResult.getUserScoreNewResultList();
        for (UserScoreDtoResult userScoreNewResult2 : scoreList) {
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
    public List<UserScoreDtoResult> getUserScore(String userName) {
    	List<UserScoreDtoResult> userScoreList = userMapper.selectUserScoreInfo(userName);
    	List<UserOriginalResult> userOriginalList = userMapper.selectUserOriginal(userName);
    	try {
    		User user = userMapper.selectByName(userName);
    		addFemaleDataToExcel(userName, userScoreList, user);
			addScoreGroupDataToExcel(userName, userScoreList, user);			
    		exporter.export2Excel(userScoreList, userName, this, user.getSex());
			List<UserScorePerItemResult> userScorePerItemResult = exporter.calculateCumulativeScore(userScoreList, userName, this, user.getSex());
			
			Map<String, Object> dataMap = addDataToWord(userName, userOriginalList, user);
			WordAction action = new WordAction();
			addScoreTableToWord(userScorePerItemResult, dataMap);
			action.createWord(dataMap, userName.replace("*", ""));
		} catch (IOException e) {
			e.printStackTrace();
		}
        return userScoreList;
    }

	private void addScoreTableToWord(List<UserScorePerItemResult> userScorePerItemResult, Map<String, Object> dataMap) {
		dataMap.put("explosiveForceScore", userScorePerItemResult.get(0).getExplosiveForceScore_percentage());
		dataMap.put("explosiveForceScore_ranking", userScorePerItemResult.get(0).getExplosiveForceScore_ranking());
		
		dataMap.put("staminaScore", userScorePerItemResult.get(0).getStaminaScore_percentage());
		dataMap.put("staminaScore_ranking", userScorePerItemResult.get(0).getStaminaScore_ranking());
		
		dataMap.put("injuryRecoveryAbilityScore", userScorePerItemResult.get(0).getInjuryRecoveryAbilityScore_percentage());
		dataMap.put("injuryRecoveryAbilityScore_ranking", userScorePerItemResult.get(0).getInjuryRecoveryAbilityScore_ranking());
		
		dataMap.put("injuryRiskScore", userScorePerItemResult.get(0).getInjuryRiskScore_percentage());
		dataMap.put("injuryRiskScore_ranking", userScorePerItemResult.get(0).getInjuryRiskScore_ranking());
		
		dataMap.put("obesityRiskScore", userScorePerItemResult.get(0).getObesityRiskScore_percentage());
		dataMap.put("obesityRiskScore_fatReducingSensitivityScore_ranking", userScorePerItemResult.get(0).getObesityRiskScore_ranking());
		
		dataMap.put("fatReducingSensitivityScore", userScorePerItemResult.get(0).getFatReducingSensitivityScore_percentage());
	}

	private Map<String, Object> addDataToWord(String userName, List<UserOriginalResult> userOriginalList, User user)
			throws IOException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
//			String geneFeatureExcelFile = "./data/features.xls";
		List<GeneFeature> geneFeatureList = null;
		geneFeatureList = GeneFeatureDataParser.parseExcelData();
		for (UserOriginalResult userOriginal : userOriginalList) {
			String geneCode = userOriginal.getGeneCode();
			String geneName = userOriginal.getGeneName();
			List<UserScoreDtoResult> geneTypeList = getUserOriginalType(userName, geneCode, geneName);
			String geneType = ((UserScoreDtoResult)geneTypeList.get(0)).getGeneType();
//				System.out.println(geneTypeList.size()+"------"+userName+"-------"+geneCode+"-------"+geneName+"---------"+geneType);
			if ("女".equals(user.getSex()) && "COL12A1".equals(geneCode) && "rs970547".equals(geneName)) {
				String geneType1 = ((UserScoreDtoResult)getUserOriginalType(userName, "COL5A1", "rs12722").get(0)).getGeneType();
				List<ScoreFemale> scoreFemaleList = scoreFemaleMapper.selectAllScoreFemale();
				for (ScoreFemale scoreFemale : scoreFemaleList) {
					if (scoreFemale.getGeneType1().equals(geneType1) && scoreFemale.getGeneType2().equals(geneType)) {
						dataMap.put("COL12A1_rs970547", geneType);
						String geneFeature = GeneFeatureDataParser.getGeneFeature("COL5A1_COL12A1", "rs12722_rs970547", geneType1+"_"+geneType, geneFeatureList);
						dataMap.put("COL12A1_rs970547_feature", geneFeature);
					}
				}
			}
			else {
				if ("COL12A1".equals(geneCode) && "rs970547".equals(geneName)) {
					dataMap.put("COL12A1_rs970547", "此项数据仅对女性有效！");
					dataMap.put("COL12A1_rs970547_feature", "此项数据仅对女性有效！");
					continue;
				}
				if (geneType != null) {
					dataMap.put(geneCode + "_" + geneName, geneType);
					String geneFeature = GeneFeatureDataParser.getGeneFeature(geneCode, geneName, geneType, geneFeatureList);
					dataMap.put(geneCode + "_" + geneName + "_feature", geneFeature);
				}
				else {
					dataMap.put(geneCode + "_" + geneName, "未测试");
					dataMap.put(geneCode + "_" + geneName + "_feature", "未测试");
				}
			}
			
		}
//			dataMap.put("ADH1B_rs1229984", "Bug需更改");
//			dataMap.put("ADH1B_rs1229984_feature", "Bug需更改");
//			dataMap.put("ALDH2_rs671", "Bug需更改");
//			dataMap.put("ALDH2_rs671_feature", "Bug需更改");
		if (!dataMap.containsKey("COL12A1_rs970547")) {
			dataMap.put("COL12A1_rs970547", "此项数据仅对女性有效！");
			dataMap.put("COL12A1_rs970547_feature", "此项数据仅对女性有效！");
		}
		return dataMap;
	}

	private void addScoreGroupDataToExcel(String userName, List<UserScoreDtoResult> userScoreList, User user) {
		String geneType1 = ((UserScoreDtoResult)getUserOriginalType(userName, "APOE", "rs429358").get(0)).getGeneType();
		String geneType2 = ((UserScoreDtoResult)getUserOriginalType(userName, "APOE", "rs7412").get(0)).getGeneType();
		List<ScoreGroup> scoreGroupList = scoreGroupMapper.selectAllScoreGroup();
		
		for (ScoreGroup scoreGroup : scoreGroupList) {
			if (geneType1.equals(scoreGroup.getGeneType1()) && geneType2.equals(scoreGroup.getGeneType2())) {
				UserScoreDtoResult usdr = new UserScoreDtoResult();
				usdr.setUserId(user.getUserId());
				usdr.setName(user.getName());
				usdr.setGeneCode("APOE_APOE");
				usdr.setGeneName("rs429358_rs7412");
				usdr.setGeneType(geneType1+"_"+geneType2);
				usdr.setFatReducingSensitivity(scoreGroup.getFatReducingSensitivity());
				usdr.setFatReducingSensitivityScore(scoreGroup.getFatReducingSensitivityScore());
				userScoreList.add(usdr);
			}
		}
	}

	private void addFemaleDataToExcel(String userName, List<UserScoreDtoResult> userScoreList, User user) {
		String sex = user.getSex();
		if("女".equals(sex)){
		    UserScoreFemaleResult userScoreFemaleResult = userMapper.selectUserScoreFemale(userName);
		    UserScoreDtoResult usdr = new UserScoreDtoResult();
		    usdr.setUserId(userScoreFemaleResult.getUserId());
		    usdr.setName(userScoreFemaleResult.getName());
		    usdr.setGeneCode(userScoreFemaleResult.getGeneCode1()+"_"+userScoreFemaleResult.getGeneCode2());
		    usdr.setGeneName(userScoreFemaleResult.getGeneName1()+"_"+userScoreFemaleResult.getGeneName2());
		    usdr.setGeneType(userScoreFemaleResult.getGeneType1()+"_"+userScoreFemaleResult.getGeneType2());
		    usdr.setInjuryRisk(userScoreFemaleResult.getInjuryRisk());
		    usdr.setInjuryRiskScore(userScoreFemaleResult.getInjuryRiskScore());
		    userScoreList.add(usdr);
		}
	}

    @Transactional(propagation = Propagation.REQUIRES_NEW, // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
            isolation = Isolation.READ_COMMITTED) // 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
    @Override
    public List<NationalRanking> saveNationalRanking() {
        nationalRankingMapper.delete();
        List<NationalRanking> list = new ArrayList<>();
        try {
            List<NationalRankingExcel> rankingDataList = RankingDataParser.parseExcelData();
            for (NationalRankingExcel nationalRankingExcel : rankingDataList) {
                NationalRanking nr = new NationalRanking();
                nr.setUuid(PrimaryKeyGenerator.getUuid32());
                nr.setItemType(nationalRankingExcel.getItem_type());
                nr.setKey1(nationalRankingExcel.getKey1());
                nr.setGeneCode1(nationalRankingExcel.getGene_code1());
                nr.setGeneType1(nationalRankingExcel.getGene_type1());
                nr.setGeneName1(nationalRankingExcel.getGene_name1());
                nr.setKey2(nationalRankingExcel.getKey2());
                nr.setGeneCode2(nationalRankingExcel.getGene_code2());
                nr.setGeneType2(nationalRankingExcel.getGene_type2());
                nr.setGeneName2(nationalRankingExcel.getGene_name2());
                nr.setRanking(nationalRankingExcel.getRanking());
                list.add(nr);
                nationalRankingMapper.insertSelective(nr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Map<String, List<String>> subitemCompare(String userName) {
        Map<String, List<String>> resultMap = new HashMap<>();
        //根据姓名查询用户信息
        User user = userMapper.selectByName(userName);
        if(user == null){
            return null;
        }
        //获取用户性别
        String sex = user.getSex();
        //根据用户查询出此用户的分值等信息
        UserScorePerItemResult userScorePerItemResult = new UserScorePerItemResult();
        List<UserScoreDtoResult> userScoreList = userMapper.selectUserScoreInfo(userName);
        if("女".equals(sex)){
            UserScoreFemaleResult userScoreFemaleResult = userMapper.selectUserScoreFemale(userName);
            UserScoreDtoResult usdr = new UserScoreDtoResult();
            usdr.setUserId(userScoreFemaleResult.getUserId());
            usdr.setName(userScoreFemaleResult.getName());
            usdr.setGeneCode(userScoreFemaleResult.getGeneCode1()+"_"+userScoreFemaleResult.getGeneCode2());
            usdr.setGeneName(userScoreFemaleResult.getGeneName1()+"_"+userScoreFemaleResult.getGeneName2());
            usdr.setGeneType(userScoreFemaleResult.getGeneType1()+"_"+userScoreFemaleResult.getGeneType2());
            usdr.setInjuryRisk(userScoreFemaleResult.getInjuryRisk());
            usdr.setInjuryRiskScore(userScoreFemaleResult.getInjuryRiskScore());
            userScoreList.add(usdr);
        }
        try {
            userScorePerItemResult = this.calculateCumulativeScore(userScoreList, userName, sex);
        } catch (IOException e) {
        }
        if(userScorePerItemResult == null){
            return null;
        }
        //用户信息
        Double explosiveForceScore = userScorePerItemResult.getExplosiveForceScore_percentage();//爆发力
        Double staminaScore = userScorePerItemResult.getStaminaScore_percentage();//耐力
        Double injuryRecoveryAbilityScore = userScorePerItemResult.getInjuryRecoveryAbilityScore_percentage();//恢复能力
        Double injuryRiskScore = userScorePerItemResult.getInjuryRiskScore_percentage();//韧带关节损伤风险
        Double obesityRiskScore = userScorePerItemResult.getObesityRiskScore_percentage();//肥胖风险
        Double fatReducingSensitivityScore = userScorePerItemResult.getFatReducingSensitivityScore_percentage();//敏感
        
        //定义集合存放运动员分数
        List<UserScorePerItemResult> playerList = new ArrayList<>();
        Map<String, String> param = new HashMap<>();
        param.put("sex", sex);
        param.put("star", "1");
        List<User> users = userMapper.selectUserBySex(param);
        for (User user2 : users) {
            try {
                UserScorePerItemResult playerScorePerItemResult = this.calculateCumulativeScore(userScoreList, user2.getName(), user2.getSex());
                playerList.add(playerScorePerItemResult);
            } catch (IOException e) {
            }
        }
        System.out.println(JSONObject.toJSON(playerList));
        for (UserScorePerItemResult uspir : playerList) {
            List<String> list1 = resultMap.get("爆发力+耐力");
            if(list1 == null){
                list1 = new ArrayList<>();
            }
            List<String> list2 = resultMap.get("恢复能力");
            if(list2 == null){
                list2 = new ArrayList<>();
            }
            List<String> list3 = resultMap.get("运动损伤风险");
            if(list3 == null){
                list3 = new ArrayList<>();
            }
            List<String> list4 = resultMap.get("肥胖风险");
            if(list4 == null){
                list4 = new ArrayList<>();
            }
            if(explosiveForceScore.compareTo(uspir.getExplosiveForceScore_percentage())==0 && staminaScore.compareTo(uspir.getStaminaScore_percentage())==0){
                list1.add(uspir.getName());
                resultMap.put("爆发力+耐力", list1);
            }
            if(injuryRecoveryAbilityScore.compareTo(uspir.getInjuryRecoveryAbilityScore_percentage())==0){
                list2.add(uspir.getName());
                resultMap.put("恢复能力", list2);
            }
            if(injuryRiskScore.compareTo(uspir.getInjuryRiskScore_percentage())==0){
                list3.add(uspir.getName());
                resultMap.put("运动损伤风险", list3);
            }
            if(obesityRiskScore.compareTo(uspir.getObesityRiskScore_percentage())==0){
                list4.add(uspir.getName());
                resultMap.put("肥胖风险", list4);
            }
        }
        return resultMap;
    }
    
    private UserScorePerItemResult calculateCumulativeScore(List<UserScoreDtoResult> userScoreResult, String userName, String userSex) throws IOException {
//        List<UserScorePerItemResult> resultList = new ArrayList<UserScorePerItemResult>();
        Map<String, Double> resultMap = new HashMap<String, Double>();
        String userIdOutput = "";
        for (UserScoreDtoResult userScoreNewResult : userScoreResult) {
            String userId = userScoreNewResult.getUserId();
            userIdOutput = userId;
            Double explosiveForceScore = userScoreNewResult.getExplosiveForceScore();
            Double staminaScore = userScoreNewResult.getStaminaScore();
            Double injuryRecoveryAbilityScore = userScoreNewResult.getInjuryRecoveryAbilityScore();
            Double injuryRiskScore = userScoreNewResult.getInjuryRiskScore();
            Double obesityRiskScore = userScoreNewResult.getObesityRiskScore();
            Double fatReducingSensitivityScore = userScoreNewResult.getFatReducingSensitivityScore();
            if (resultMap.get("explosiveForceScore") == null && explosiveForceScore != null) {
                resultMap.put("explosiveForceScore", explosiveForceScore);
            }
            else if (resultMap.get("explosiveForceScore") != null && explosiveForceScore != null) {
                resultMap.put("explosiveForceScore", resultMap.get("explosiveForceScore") + explosiveForceScore);
            }
            if (resultMap.get("staminaScore") == null && staminaScore != null) {
                resultMap.put("staminaScore", staminaScore);
            }
            else if (resultMap.get("staminaScore") != null && staminaScore != null) {
                resultMap.put("staminaScore", resultMap.get("staminaScore") + staminaScore);
            }
            if (resultMap.get("injuryRecoveryAbilityScore") == null && injuryRecoveryAbilityScore != null) {
                resultMap.put("injuryRecoveryAbilityScore", injuryRecoveryAbilityScore);
            }
            else if (resultMap.get("injuryRecoveryAbilityScore") != null && injuryRecoveryAbilityScore != null) {
                resultMap.put("injuryRecoveryAbilityScore", resultMap.get("injuryRecoveryAbilityScore") + injuryRecoveryAbilityScore);
            }
            if (resultMap.get("injuryRiskScore") == null && injuryRiskScore != null) {
                resultMap.put("injuryRiskScore", injuryRiskScore);
            }
            else if (resultMap.get("injuryRiskScore") != null && injuryRiskScore != null) {
                resultMap.put("injuryRiskScore", resultMap.get("injuryRiskScore") + injuryRiskScore);
            }
            if (resultMap.get("obesityRiskScore") == null && obesityRiskScore != null) {
                resultMap.put("obesityRiskScore", obesityRiskScore);
                if (resultMap.get("fatReducingSensitivityScore") == null && fatReducingSensitivityScore != null) {
                    resultMap.put("fatReducingSensitivityScore", fatReducingSensitivityScore);
                }
            }
            else if (resultMap.get("obesityRiskScore") != null && obesityRiskScore != null) {
                resultMap.put("obesityRiskScore", resultMap.get("obesityRiskScore") + obesityRiskScore);
                if (resultMap.get("fatReducingSensitivityScore") != null && fatReducingSensitivityScore != null) {
                    resultMap.put("fatReducingSensitivityScore", resultMap.get("fatReducingSensitivityScore") + fatReducingSensitivityScore);
                }
            }
        }
        UserScorePerItemResult userScorePerItemResult2 = new UserScorePerItemResult();
        userScorePerItemResult2.setUserId(userIdOutput);
        userScorePerItemResult2.setName(userName);
//      userScorePerItemResult2.setExplosiveForceScore(resultMap.get("explosiveForceScore"));
//      userScorePerItemResult2.setStaminaScore(resultMap.get("staminaScore"));
//      userScorePerItemResult2.setInjuryRecoveryAbilityScore(resultMap.get("injuryRecoveryAbilityScore"));
//      userScorePerItemResult2.setInjuryRiskScore(resultMap.get("injuryRiskScore"));
//      userScorePerItemResult2.setObesityRiskScore(resultMap.get("obesityRiskScore"));
//      userScorePerItemResult2.setFatReducingSensitivityScore(resultMap.get("fatReducingSensitivityScore"));
        
        userScorePerItemResult2.setExplosiveForceScore_percentage(resultMap.get("explosiveForceScore") / explosiveForceScore_percentage * 100);
        userScorePerItemResult2.setStaminaScore_percentage(resultMap.get("staminaScore") / staminaScore_percentage * 100);
        userScorePerItemResult2.setInjuryRecoveryAbilityScore_percentage(resultMap.get("injuryRecoveryAbilityScore") / injuryRecoveryAbilityScore_percentage * 100);
        if (!"女".equals(userSex)) {
        	userScorePerItemResult2.setInjuryRiskScore_percentage(resultMap.get("injuryRiskScore") / injuryRiskScore_percentage * 100);
        }
        else {
        	userScorePerItemResult2.setInjuryRiskScore_percentage(resultMap.get("injuryRiskScore") / injuryRiskScore_female_percentage * 100);
        }
        userScorePerItemResult2.setObesityRiskScore_percentage(resultMap.get("obesityRiskScore") / obesityRiskScore_percentage * 100);
        userScorePerItemResult2.setFatReducingSensitivityScore_percentage(resultMap.get("fatReducingSensitivityScore") / fatReducingSensitivityScore_percentage * 100);
        Map<String, String> map = this.getRankingDataMap(userName);
        userScorePerItemResult2.setExplosiveForceScore_ranking(map.get("explosiveForceScore_ranking"));
        userScorePerItemResult2.setStaminaScore_ranking(map.get("staminaScore_ranking"));
        userScorePerItemResult2.setInjuryRecoveryAbilityScore_ranking(map.get("injuryRecoveryAbilityScore_ranking"));
        userScorePerItemResult2.setInjuryRiskScore_ranking(map.get("injuryRiskScore_ranking"));
        userScorePerItemResult2.setObesityRiskScore_ranking(map.get("fatReducingSensitivityScore_ranking"));
        userScorePerItemResult2.setFatReducingSensitivityScore_ranking(map.get("fatReducingSensitivityScore_ranking"));
//        resultList.add(userScorePerItemResult2);
        return userScorePerItemResult2;
    }
    
    public Map<String, String> getRankingDataMap(String userName) throws IOException {
        Map<String, String> resultMap = new HashMap<>();
        List<NationalRankingExcel> rankingDataList = RankingDataParser.parseExcelData();
        for (NationalRankingExcel nationalRanking : rankingDataList) {
            List<UserScoreDtoResult> geneTypeList_1 = this.getUserOriginalType(userName,
                    nationalRanking.getGene_code1(), nationalRanking.getGene_name1());
            if(geneTypeList_1 == null || geneTypeList_1.size() == 0){
                continue;
            }
            String geneType_1 = ((UserScoreDtoResult) geneTypeList_1.get(0)).getGeneType();
            boolean isMatched_1 = false;
            if (nationalRanking.getGene_type1().indexOf('+') != -1) {
                String[] geneTypes_1 = nationalRanking.getGene_type1().split("\\+");
                for (String geneType_benchmark : geneTypes_1) {
                    if (geneType_1.equals(geneType_benchmark)) {
                        isMatched_1 = true;
                        break;
                    }
                }
            } else {
                if (geneType_1.equals(nationalRanking.getGene_type1()))
                    isMatched_1 = true;
            }
            if (!isMatched_1)
                continue;
            List<UserScoreDtoResult> geneTypeList_2 = this.getUserOriginalType(userName,
                    nationalRanking.getGene_code2(), nationalRanking.getGene_name2());
            if(geneTypeList_2 == null || geneTypeList_2.size() == 0){
                continue;
            }
            String geneType_2 = ((UserScoreDtoResult) geneTypeList_2.get(0)).getGeneType();
            
            boolean isMatched_2 = false;
            if (nationalRanking.getGene_type2().indexOf('+') != -1) {
                String[] geneTypes_2 = nationalRanking.getGene_type2().split("\\+");
                for (String geneType_benchmark : geneTypes_2) {
                    if (geneType_2.equals(geneType_benchmark)) {
                        isMatched_2 = true;
                        break;
                    }
                }
            } else {
                if (geneType_2.equals(nationalRanking.getGene_type2()))
                    isMatched_2 = true;
            }
            if (isMatched_1 && isMatched_2){
                String item_type = nationalRanking.getItem_type();
                String ranking = nationalRanking.getRanking();
                if("P".equals(item_type)){
                    resultMap.put("explosiveForceScore_ranking", ranking);
                }else if("E".equals(item_type)){
                    resultMap.put("staminaScore_ranking", ranking);
                }else if("C".equals(item_type)){
                    resultMap.put("injuryRecoveryAbilityScore_ranking", ranking);
                }else if("I".equals(item_type)){
                    resultMap.put("injuryRiskScore_ranking", ranking);
                }else if("F".equals(item_type)){
                    resultMap.put("fatReducingSensitivityScore_ranking", ranking);
                }else{
                    
                }
            }
        }
        return resultMap;
    }

    @Override
    public List<UserScoreDtoResult> getUserScoreType(String userName, String geneCode, String geneName) {
        List<UserScoreDtoResult> geneType = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("userName", userName);
        map.put("geneCode", geneCode);
        map.put("geneName", geneName);
        try {
            geneType = userMapper.getUserScoreType(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geneType;

    }

    @Override
    public List<UserScoreDtoResult> getUserOriginalType(String userName, String geneCode, String geneName) {
        List<UserScoreDtoResult> geneType = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("userName", userName);
        map.put("geneCode", geneCode);
        map.put("geneName", geneName);
        try {
            geneType = userMapper.getUserOriginalType(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geneType;

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
            isolation = Isolation.READ_COMMITTED) // 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
    @Override
    public List<ScoreFemale> saveScoreFemale() {
        scoreFemaleMapper.delete();
        List<ScoreFemale> sfList = new ArrayList<>();
        try {
            List<ScoreFemaleExcel> scoreFemaleList = ScoreDataParser.parseInjuryRiskData_Female();
            for (ScoreFemaleExcel scoreFemaleExcel : scoreFemaleList) {
                ScoreFemale sf = new ScoreFemale();
                sf.setUuid(PrimaryKeyGenerator.getUuid32());
                sf.setGeneCode1(scoreFemaleExcel.getGeneCode1());
                sf.setGeneCode2(scoreFemaleExcel.getGeneCode2());
                sf.setGeneName1(scoreFemaleExcel.getGeneName1());
                sf.setGeneName2(scoreFemaleExcel.getGeneName2());
                sf.setGeneType1(scoreFemaleExcel.getGeneType1());
                sf.setGeneType2(scoreFemaleExcel.getGeneType2());
                sf.setInjuryRisk(scoreFemaleExcel.getInjuryRisk());
                sf.setInjuryRiskScore(scoreFemaleExcel.getInjuryRiskScore());
                sfList.add(sf);
                scoreFemaleMapper.insertSelective(sf);
            }
        } catch (IOException e) {
        }
        return sfList;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW, // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
            isolation = Isolation.READ_COMMITTED) // 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
    @Override
    public List<ScoreGroup> saveScoreGroup() {
        scoreGroupMapper.delete();
        List<ScoreGroup> sfList = new ArrayList<ScoreGroup>();
        try {
            List<ScoreGroup> scoreGroupList = ScoreDataParser.parseObesityRiskAndFatReducingSensitivityData_group();
            for (ScoreGroup scoreGroup : scoreGroupList) {
            	ScoreGroup sg = new ScoreGroup();
                sg.setUuid(PrimaryKeyGenerator.getUuid32());
                sg.setGeneCode1(scoreGroup.getGeneCode1());
                sg.setGeneCode2(scoreGroup.getGeneCode2());
                sg.setGeneName1(scoreGroup.getGeneName1());
                sg.setGeneName2(scoreGroup.getGeneName2());
                sg.setGeneType1(scoreGroup.getGeneType1());
                sg.setGeneType2(scoreGroup.getGeneType2());
                sg.setFatReducingSensitivity(scoreGroup.getFatReducingSensitivity());
                sg.setFatReducingSensitivityScore(scoreGroup.getFatReducingSensitivityScore());
                sfList.add(sg);
                scoreGroupMapper.insertSelective(sg);
            }
        } catch (IOException e) {
        }
        return sfList;
    }
}
