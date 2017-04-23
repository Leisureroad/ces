package com.dapeng.ces.service.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dapeng.ces.dto.NationalRankingExcel;
import com.dapeng.ces.dto.UserScoreDtoResult;
import com.dapeng.ces.dto.UserScorePerItemResult;
import com.dapeng.ces.service.persistence.PersistenceService;
import com.dapeng.ces.util.ExportExcel;

@Component
public class UserScoreDataExporter {
	@Value("${total-score.explosiveForceScore}")
	private Double explosiveForceScore_percentage;
	
	@Value("${total-score.staminaScore}")
	private Double staminaScore_percentage;
	
	@Value("${total-score.injuryRecoveryAbilityScore}")
	private Double injuryRecoveryAbilityScore_percentage;
	
	@Value("${total-score.injuryRiskScore}")
	private Double injuryRiskScore_percentage;
	
	@Value("${total-score.injuryRiskScore_female}")
	private Double injuryRiskScore_percentage_female;
	
	@Value("${total-score.obesityRiskScore}")
	private Double obesityRiskScore_percentage;
	
	@Value("${total-score.fatReducingSensitivityScore}")
	private Double fatReducingSensitivityScore_percentage;
//
//	@Autowired
//	private PersistenceService persistenceService;
	
	public void export2Excel(List<UserScoreDtoResult> userScoreResult, String userName, PersistenceService persistenceService, String userSex) throws IOException {
		String[] headers = { "编号", "姓名", "基因", "位点","基因型", "爆发力", "爆发力得分", "耐力	", "耐力得分", "耐力运动敏感度", "耐力运动敏感度得分",
				"运动损伤的恢复能力", "恢复能力得分", "韧带、关节损伤风险", "韧带、关节损伤风险得分", "肥胖风险", "肥胖风险得分", "运动减脂敏感性", "运动减肥敏感性得分"};
		ExportExcel<UserScoreDtoResult> ex = new ExportExcel<UserScoreDtoResult>();
		OutputStream out = new FileOutputStream(userName.replace("*","")+"_评分_原始数据.xls");
		ex.exportExcel(headers, userScoreResult, out);
		out.close();
		
//		getRankingData(userName, persistenceService);
		
		String[] headers2 = { "编号", "姓名", "爆发力得分(百分制)","爆发力排名",  "耐力得分(百分制)", "耐力排名", "恢复能力得分(百分制)","恢复能力排名", 
				 "韧带、关节损伤风险得分(百分制)","韧带、关节损伤风险排名",  "肥胖风险得分(百分制)","肥胖风险排名", "运动减肥敏感性得分(百分制)","运动减肥敏感性排名"};
		ExportExcel<UserScorePerItemResult> ex2 = new ExportExcel<UserScorePerItemResult>();
		List<UserScorePerItemResult> resultList = calculateCumulativeScore(userScoreResult, userName,persistenceService, userSex);
		OutputStream out2 = new FileOutputStream(userName.replace("*","")+"_评分.xls");
		ex2.exportExcel(headers2, resultList, out2);
		out2.close();
		System.out.println("excel导出成功！");
	}

   public Map<String, String> getRankingDataMap(String userName, PersistenceService persistenceService) throws IOException {
        Map<String, String> resultMap = new HashMap<>();
        List<NationalRankingExcel> rankingDataList = RankingDataParser.parseExcelData();
        for (NationalRankingExcel nationalRanking : rankingDataList) {
            List<UserScoreDtoResult> geneTypeList_1 = persistenceService.getUserOriginalType(userName,
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
            List<UserScoreDtoResult> geneTypeList_2 = persistenceService.getUserOriginalType(userName,
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

	
	public void getRankingData(String userName, PersistenceService persistenceService) throws IOException {
		List<NationalRankingExcel> rankingDataList = RankingDataParser.parseExcelData();
		for (NationalRankingExcel nationalRanking : rankingDataList) {
			List<UserScoreDtoResult> geneTypeList_1 = persistenceService.getUserScoreType(userName, nationalRanking.getGene_code1(), nationalRanking.getGene_name1());
			String geneType_1 = ((UserScoreDtoResult)geneTypeList_1.get(0)).getGeneType();
			boolean isMatched_1 = false;
			if (nationalRanking.getGene_type1().indexOf('+') != -1)
			{
				String[] geneTypes_1 = nationalRanking.getGene_type1().split("\\+");
				for (String geneType_benchmark : geneTypes_1) {
					if (geneType_1.equals(geneType_benchmark)) {
						isMatched_1 = true;
						break;
					}
				}
			}
			else {
				if (geneType_1.equals(nationalRanking.getGene_type1())) isMatched_1 = true;
			}
			if (!isMatched_1) continue;
			List<UserScoreDtoResult> geneTypeList_2 = persistenceService.getUserScoreType(userName, nationalRanking.getGene_code2(), nationalRanking.getGene_name2());
			String geneType_2 = ((UserScoreDtoResult)geneTypeList_2.get(0)).getGeneType();
			boolean isMatched_2 = false;
			if (nationalRanking.getGene_type2().indexOf('+') != -1) {
				String[] geneTypes_2 = nationalRanking.getGene_type2().split("\\+");
				for (String geneType_benchmark : geneTypes_2) {
					if (geneType_2.equals(geneType_benchmark)) {
						isMatched_2 = true;
						break;
					}
				}	
			}
			else {
				if (geneType_2.equals(nationalRanking.getGene_type2())) isMatched_2 = true;
			}
			if (isMatched_1 && isMatched_2) 
				System.out.println("geneCode1: " + nationalRanking.getGene_code1() + ", geneName1: " + nationalRanking.getGene_name1() +", geneType1: "+ geneType_1 
						+ ", geneCode2: " + nationalRanking.getGene_code2() + ", geneName2: " + nationalRanking.getGene_name2() +", geneType2: "+ geneType_2 + " "
						+ nationalRanking.getRanking());
		}
	}

	public List<UserScorePerItemResult> calculateCumulativeScore(List<UserScoreDtoResult> userScoreResult, String userName, PersistenceService persistenceService, String userSex) throws IOException {
		List<UserScorePerItemResult> resultList = new ArrayList<UserScorePerItemResult>();
		Map<String, Double> resultMap = new HashMap<String, Double>();
		String userIdOutput = "";
		for (UserScoreDtoResult userScoreNewResult : userScoreResult) {
			String userId = userScoreNewResult.getUserId();
			userIdOutput = userId;
//			对各个属性进行累加
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
			//韧带损伤-女
			if (resultMap.get("injuryRiskScore") == null && injuryRiskScore != null) {
				resultMap.put("injuryRiskScore", injuryRiskScore);
			}
			else if (resultMap.get("injuryRiskScore") != null && injuryRiskScore != null) {
				resultMap.put("injuryRiskScore", resultMap.get("injuryRiskScore") + injuryRiskScore);
			}
			if (resultMap.get("obesityRiskScore") == null && obesityRiskScore != null) {
				resultMap.put("obesityRiskScore", obesityRiskScore);
				
			}
			else if (resultMap.get("obesityRiskScore") != null && obesityRiskScore != null) {
				resultMap.put("obesityRiskScore", resultMap.get("obesityRiskScore") + obesityRiskScore);
				
			}
			if (resultMap.get("fatReducingSensitivityScore") == null && fatReducingSensitivityScore != null) {
				resultMap.put("fatReducingSensitivityScore", fatReducingSensitivityScore);
			}
			else if (resultMap.get("fatReducingSensitivityScore") != null && fatReducingSensitivityScore != null) {
				resultMap.put("fatReducingSensitivityScore", resultMap.get("fatReducingSensitivityScore") + fatReducingSensitivityScore);
			}
		}
		UserScorePerItemResult userScorePerItemResult2 = new UserScorePerItemResult();
		userScorePerItemResult2.setUserId(userIdOutput);
		userScorePerItemResult2.setName(userName);
//		累加分，非百分制		
//		userScorePerItemResult2.setExplosiveForceScore(resultMap.get("explosiveForceScore"));
//		userScorePerItemResult2.setStaminaScore(resultMap.get("staminaScore"));
//		userScorePerItemResult2.setInjuryRecoveryAbilityScore(resultMap.get("injuryRecoveryAbilityScore"));
//		userScorePerItemResult2.setInjuryRiskScore(resultMap.get("injuryRiskScore"));
//		userScorePerItemResult2.setObesityRiskScore(resultMap.get("obesityRiskScore"));
//		userScorePerItemResult2.setFatReducingSensitivityScore(resultMap.get("fatReducingSensitivityScore"));
		
//		累加分，百分制
		DecimalFormat df = new DecimalFormat("#.00");
		userScorePerItemResult2.setExplosiveForceScore_percentage(Double.valueOf(df.format(resultMap.get("explosiveForceScore") / explosiveForceScore_percentage * 100)));
		userScorePerItemResult2.setStaminaScore_percentage(Double.valueOf(df.format(resultMap.get("staminaScore") / staminaScore_percentage * 100)));
		userScorePerItemResult2.setInjuryRecoveryAbilityScore_percentage(Double.valueOf(df.format(resultMap.get("injuryRecoveryAbilityScore") / injuryRecoveryAbilityScore_percentage * 100)));
		if (!"女".equals(userSex)) {
			userScorePerItemResult2.setInjuryRiskScore_percentage(Double.valueOf(df.format(resultMap.get("injuryRiskScore") / injuryRiskScore_percentage * 100)));
		}
		else {
			userScorePerItemResult2.setInjuryRiskScore_percentage(Double.valueOf(df.format(resultMap.get("injuryRiskScore") / injuryRiskScore_percentage_female * 100)));
		}
		userScorePerItemResult2.setObesityRiskScore_percentage(Double.valueOf(df.format(resultMap.get("obesityRiskScore") / obesityRiskScore_percentage * 100)));
		userScorePerItemResult2.setFatReducingSensitivityScore_percentage(Double.valueOf(df.format(resultMap.get("fatReducingSensitivityScore") / fatReducingSensitivityScore_percentage * 100)));

		Map<String, String> map = getRankingDataMap(userName, persistenceService);
		userScorePerItemResult2.setExplosiveForceScore_ranking(map.get("explosiveForceScore_ranking"));
		userScorePerItemResult2.setStaminaScore_ranking(map.get("staminaScore_ranking"));
		userScorePerItemResult2.setInjuryRecoveryAbilityScore_ranking(map.get("injuryRecoveryAbilityScore_ranking"));
		userScorePerItemResult2.setInjuryRiskScore_ranking(map.get("injuryRiskScore_ranking"));
		userScorePerItemResult2.setObesityRiskScore_ranking(map.get("fatReducingSensitivityScore_ranking"));
		userScorePerItemResult2.setFatReducingSensitivityScore_ranking(map.get("fatReducingSensitivityScore_ranking"));
		resultList.add(userScorePerItemResult2);
		return resultList;
	}
}
