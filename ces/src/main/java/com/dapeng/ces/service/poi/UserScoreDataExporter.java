package com.dapeng.ces.service.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dapeng.ces.dto.UserScoreNewResult;
import com.dapeng.ces.dto.UserScorePerItemResult;
import com.dapeng.ces.util.ExportExcel;

public class UserScoreDataExporter {

	public void export2Excel(List<UserScoreNewResult> userScoreResult, String userName) throws IOException {
		String[] headers = { "编号", "姓名", "uuid", "基因", "位点", "基因型", "爆发力", "爆发力得分", "耐力	", "耐力得分", "耐力运动敏感度", "耐力运动敏感度得分",
				"运动损伤的恢复能力", "恢复能力得分", "韧带、关节损伤风险", "韧带、关节损伤风险得分", "肥胖风险", "肥胖风险得分", "运动减脂敏感性", "运动减肥敏感性得分" };
		ExportExcel<UserScoreNewResult> ex = new ExportExcel<UserScoreNewResult>();
		OutputStream out = new FileOutputStream(userName.replace("*","")+"_评分_原始数据.xls");
		ex.exportExcel(headers, userScoreResult, out);
		out.close();
		String[] headers2 = { "编号", "姓名", "爆发力得分", "耐力得分", "恢复能力得分", "韧带、关节损伤风险得分", "肥胖风险得分",  "运动减肥敏感性得分"};
		ExportExcel<UserScorePerItemResult> ex2 = new ExportExcel<UserScorePerItemResult>();
		List<UserScorePerItemResult> resultList = new ArrayList<UserScorePerItemResult>();
		Map<String, Double> resultMap = new HashMap<String, Double>();
		String userIdOutput = "";
		for (UserScoreNewResult userScoreNewResult : userScoreResult) {
			String userId = userScoreNewResult.getUserId();
			userIdOutput = userId;
			Double explosiveForceScore = userScoreNewResult.getExplosiveForceScore();
			Double staminaScore = userScoreNewResult.getStaminaScore();
//			Double motionSensitivityScore = userScoreNewResult.getMotionSensitivityScore();
			Double injuryRecoveryAbilityScore = userScoreNewResult.getInjuryRecoveryAbilityScore();
			Double injuryRiskScore = userScoreNewResult.getInjuryRiskScore();
			Double obesityRiskScore = userScoreNewResult.getObesityRiskScore();
			Double fatReducingSensitivityScore = userScoreNewResult.getFatReducingSensitivityScore();
			if (resultMap.get("explosiveForceScore") == null && explosiveForceScore != null) {
				resultMap.put("explosiveForceScore", explosiveForceScore);
				continue;
			}
			if (resultMap.get("explosiveForceScore") != null && explosiveForceScore != null) {
				resultMap.put("explosiveForceScore", resultMap.get("explosiveForceScore") + explosiveForceScore);
				continue;
			}
			if (resultMap.get("staminaScore") == null && staminaScore != null) {
				resultMap.put("staminaScore", staminaScore);
				continue;
			}
			if (resultMap.get("staminaScore") != null && staminaScore != null) {
				resultMap.put("staminaScore", resultMap.get("staminaScore") + staminaScore);
				continue;
			}
//			if (resultMap.get("motionSensitivityScore") == null && motionSensitivityScore != null) {
//				resultMap.put("motionSensitivityScore", motionSensitivityScore);
//				continue;
//			}
//			if (resultMap.get("motionSensitivityScore") != null && motionSensitivityScore != null) {
//				resultMap.put("motionSensitivityScore", resultMap.get("motionSensitivityScore") + motionSensitivityScore);
//				continue;
//			}
			if (resultMap.get("injuryRecoveryAbilityScore") == null && injuryRecoveryAbilityScore != null) {
				resultMap.put("injuryRecoveryAbilityScore", injuryRecoveryAbilityScore);
				continue;
			}
			if (resultMap.get("injuryRecoveryAbilityScore") != null && injuryRecoveryAbilityScore != null) {
				resultMap.put("injuryRecoveryAbilityScore", resultMap.get("injuryRecoveryAbilityScore") + injuryRecoveryAbilityScore);
				continue;
			}
			if (resultMap.get("injuryRiskScore") == null && injuryRiskScore != null) {
				resultMap.put("injuryRiskScore", injuryRiskScore);
				continue;
			}
			if (resultMap.get("injuryRiskScore") != null && injuryRiskScore != null) {
				resultMap.put("injuryRiskScore", resultMap.get("injuryRiskScore") + injuryRiskScore);
				continue;
			}
			if (resultMap.get("obesityRiskScore") == null && obesityRiskScore != null) {
				resultMap.put("obesityRiskScore", obesityRiskScore);
				if (resultMap.get("fatReducingSensitivityScore") == null && fatReducingSensitivityScore != null) {
					resultMap.put("fatReducingSensitivityScore", fatReducingSensitivityScore);
					continue;
				}
				continue;
			}
			if (resultMap.get("obesityRiskScore") != null && obesityRiskScore != null) {
				resultMap.put("obesityRiskScore", resultMap.get("obesityRiskScore") + obesityRiskScore);
				if (resultMap.get("fatReducingSensitivityScore") != null && fatReducingSensitivityScore != null) {
					resultMap.put("fatReducingSensitivityScore", resultMap.get("fatReducingSensitivityScore") + fatReducingSensitivityScore);
					continue;
				}
				continue;
			}
		}
		UserScorePerItemResult userScorePerItemResult2 = new UserScorePerItemResult();
		userScorePerItemResult2.setUserId(userIdOutput);
		userScorePerItemResult2.setName(userName);
		userScorePerItemResult2.setExplosiveForceScore(resultMap.get("explosiveForceScore"));
		userScorePerItemResult2.setStaminaScore(resultMap.get("staminaScore"));
//		userScorePerItemResult2.setMotionSensitivityScore(resultMap.get("motionSensitivityScore"));
		userScorePerItemResult2.setInjuryRecoveryAbilityScore(resultMap.get("injuryRecoveryAbilityScore"));
		userScorePerItemResult2.setInjuryRiskScore(resultMap.get("injuryRiskScore"));
		userScorePerItemResult2.setObesityRiskScore(resultMap.get("obesityRiskScore"));
		userScorePerItemResult2.setFatReducingSensitivityScore(resultMap.get("fatReducingSensitivityScore"));
		resultList.add(userScorePerItemResult2);
		
		OutputStream out2 = new FileOutputStream(userName.replace("*","")+"_评分.xls");
		ex2.exportExcel(headers2, resultList, out2);
		out2.close();
		System.out.println("excel导出成功！");
	}
}
