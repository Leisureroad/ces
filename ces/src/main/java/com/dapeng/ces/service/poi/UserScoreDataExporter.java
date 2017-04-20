package com.dapeng.ces.service.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dapeng.ces.dto.NationalRankingExcel;
import com.dapeng.ces.dto.UserScoreNewResult;
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
	
	@Value("${total-score.obesityRiskScore}")
	private Double obesityRiskScore_percentage;
	
	@Value("${total-score.fatReducingSensitivityScore}")
	private Double fatReducingSensitivityScore_percentage;
//
//	@Autowired
//	private PersistenceService persistenceService;
	
	public void export2Excel(List<UserScoreNewResult> userScoreResult, String userName, PersistenceService persistenceService) throws IOException {
		
		String[] headers = { "编号", "姓名", "uuid", "基因", "位点", "原始基因型","总体评分基因型", "爆发力", "爆发力得分", "耐力	", "耐力得分", "耐力运动敏感度", "耐力运动敏感度得分",
				"运动损伤的恢复能力", "恢复能力得分", "韧带、关节损伤风险", "韧带、关节损伤风险得分", "肥胖风险", "肥胖风险得分", "运动减脂敏感性", "运动减肥敏感性得分"};
		ExportExcel<UserScoreNewResult> ex = new ExportExcel<UserScoreNewResult>();
		OutputStream out = new FileOutputStream(userName.replace("*","")+"_评分_原始数据.xls");
		ex.exportExcel(headers, userScoreResult, out);
		out.close();
		
		getRankingData(userName, persistenceService);
		
		String[] headers2 = { "编号", "姓名", "爆发力得分", "爆发力得分(百分制)", "耐力得分", "耐力得分(百分制)", "恢复能力得分", "恢复能力得分(百分制)", 
				"韧带、关节损伤风险得分", "韧带、关节损伤风险得分(百分制)", "肥胖风险得分", "肥胖风险得分(百分制)", "运动减肥敏感性得分", "运动减肥敏感性得分(百分制)"};
		ExportExcel<UserScorePerItemResult> ex2 = new ExportExcel<UserScorePerItemResult>();
		List<UserScorePerItemResult> resultList = calculateCumulativeScore(userScoreResult, userName);
		OutputStream out2 = new FileOutputStream(userName.replace("*","")+"_评分.xls");
		ex2.exportExcel(headers2, resultList, out2);
		out2.close();
		System.out.println("excel导出成功！");
	}

	public void getRankingData(String userName, PersistenceService persistenceService) throws IOException {
		List<NationalRankingExcel> rankingDataList = RankingDataParser.parseExcelData();
		for (NationalRankingExcel nationalRanking : rankingDataList) {
			List<UserScoreNewResult> geneTypeList_1 = persistenceService.getUserGeneType(userName, nationalRanking.getGene_code1(), nationalRanking.getGene_name1());
			String geneType_1 = ((UserScoreNewResult)geneTypeList_1.get(0)).getGeneValue();
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
			List<UserScoreNewResult> geneTypeList_2 = persistenceService.getUserGeneType(userName, nationalRanking.getGene_code2(), nationalRanking.getGene_name2());
			String geneType_2 = ((UserScoreNewResult)geneTypeList_2.get(0)).getGeneValue();
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

	private List<UserScorePerItemResult> calculateCumulativeScore(List<UserScoreNewResult> userScoreResult, String userName) {
		List<UserScorePerItemResult> resultList = new ArrayList<UserScorePerItemResult>();
		Map<String, Double> resultMap = new HashMap<String, Double>();
		String userIdOutput = "";
		for (UserScoreNewResult userScoreNewResult : userScoreResult) {
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
		userScorePerItemResult2.setExplosiveForceScore(resultMap.get("explosiveForceScore"));
		userScorePerItemResult2.setStaminaScore(resultMap.get("staminaScore"));
		userScorePerItemResult2.setInjuryRecoveryAbilityScore(resultMap.get("injuryRecoveryAbilityScore"));
		userScorePerItemResult2.setInjuryRiskScore(resultMap.get("injuryRiskScore"));
		userScorePerItemResult2.setObesityRiskScore(resultMap.get("obesityRiskScore"));
		userScorePerItemResult2.setFatReducingSensitivityScore(resultMap.get("fatReducingSensitivityScore"));
		
		userScorePerItemResult2.setExplosiveForceScore_percentage(resultMap.get("explosiveForceScore") / explosiveForceScore_percentage * 100);
		userScorePerItemResult2.setStaminaScore_percentage(resultMap.get("staminaScore") / staminaScore_percentage * 100);
		userScorePerItemResult2.setInjuryRecoveryAbilityScore_percentage(resultMap.get("injuryRecoveryAbilityScore") / injuryRecoveryAbilityScore_percentage * 100);
		userScorePerItemResult2.setInjuryRiskScore_percentage(resultMap.get("injuryRiskScore") / injuryRiskScore_percentage * 100);
		userScorePerItemResult2.setObesityRiskScore_percentage(resultMap.get("obesityRiskScore") / obesityRiskScore_percentage * 100);
		userScorePerItemResult2.setFatReducingSensitivityScore_percentage(resultMap.get("fatReducingSensitivityScore") / fatReducingSensitivityScore_percentage * 100);
		resultList.add(userScorePerItemResult2);
		return resultList;
	}
}
