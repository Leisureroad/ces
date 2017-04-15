package com.dapeng.ces.service.poi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.dapeng.ces.dto.GeneResult;
import com.dapeng.ces.dto.ScoreResult;
import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.dto.UserScoreResult;
import com.dapeng.ces.util.ExcelDataImporter;

public class ScoreDataParser {

	public static List<ScoreResult> parseExcelData(File file, int sheetNum) throws IOException {
		Workbook workbook = ExcelDataImporter.importDataFromExcel(file, sheetNum);
		Sheet sheet = workbook.getSheetAt(sheetNum);
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

		List<ScoreResult> scoreList = new ArrayList<ScoreResult>();
		int minRowIx = sheet.getFirstRowNum();
		int maxRowIx = sheet.getLastRowNum();

		for (int rowIx = minRowIx; rowIx <= maxRowIx; rowIx++) {
			if (rowIx == 0 || rowIx == 10 || rowIx == 38 || rowIx == 60 || rowIx == 94 || rowIx == 110)
				continue;
			if (rowIx == 141)
				break;
			ScoreResult score = new ScoreResult();
			Row row = sheet.getRow(rowIx);
			int minColIx = row.getFirstCellNum();
			int maxColIx = row.getLastCellNum();
			if (rowIx >= 1 && rowIx <= 9) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setExplosiveForce(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						score.setExplosiveForceScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
				}
			}
			if (rowIx >= 11 && rowIx <= 37) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setStamina(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						score.setStaminaScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
//					if (colIx == 6) {
//						score.setMotionSensitivity(cellValue.getStringValue().trim());
//						continue;
//					}
//					if (colIx == 7) {
//						score.setMotionSensitivityScore(Double.valueOf(cellValue.getNumberValue()));
//						continue;
//					}
				}
			}
			if (rowIx >= 39 && rowIx <= 59) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setInjuryRecoveryAbility(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						score.setInjuryRecoveryAbilityScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
				}
			}
			if (rowIx >= 61 && rowIx <= 93) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setInjuryRisk(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						score.setInjuryRiskScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
				}
			}
			if (rowIx >= 95 && rowIx <= 109) {
				continue;
			}
			if (rowIx >= 111 && rowIx <= 140) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setObesityRisk(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						score.setObesityRiskScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
					if (colIx == 6) {
						score.setFatReducingSensitivity(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 7) {
						score.setFatReducingSensitivityScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
				}
			}
			scoreList.add(score);
		}
		return scoreList;
	}

	private static void getBasicProps(ScoreResult score, int colIx, CellValue cellValue) {
		String score_id;
		if (colIx == 0) {
			score.setNumber(String.valueOf(cellValue.getNumberValue()));
			return;
		}
		if (colIx == 1) {
			score.setGeneCode(cellValue.getStringValue().trim());
			return;
		}
		if (colIx == 2) {
			score.setGeneName(cellValue.getStringValue().trim());
			return;
		}
		if (colIx == 3) {
			score.setGeneType(cellValue.getStringValue().trim());
			score_id = score.getGeneName() + score.getGeneType();
			score.setId(score_id);
			return;
		}
	}

	public static UserScoreResult calculateUserScore(String userKey, List<ScoreResult> scoreList) {
		UserScoreResult result = new UserScoreResult();
		result.setUserKey(userKey);
		List<ScoreResult> userScoreList = new ArrayList<ScoreResult>();
		for (ScoreResult score : scoreList) {
			if (getMatchedKey(userKey, score.getId())) {
				ScoreResult oneScore = new ScoreResult();
				oneScore = score;
				userScoreList.add(oneScore);
			}
		}
		result.setUserScoreList(userScoreList);
		return result;
	}

	public static boolean getMatchedKey(String userKey, String scoreId) {
		if (userKey.equals(scoreId))
			return true;
//		String newUserKey = userKey.replace("C", "G").replace("T", "A");
//		String newScoreId = scoreId.replace("C", "G").replace("T", "A");
//		if (newUserKey.equals(newScoreId)) 
//			return true;
		String roundTrip_1 = userKey.substring(userKey.length()-2, userKey.length()-1);
		String roundTrip_2 = userKey.substring(userKey.length()-1, userKey.length());
		String tempUserKey = userKey.substring(0, userKey.length()-2) + roundTrip_2 + roundTrip_1;	
//		String newUserKey_roundTrip = tempUserKey.replace("C", "G").replace("T", "A");
		if (tempUserKey.equals(scoreId)) 
			return true;
//		String newScoreId_roundTrip = scoreId.replace("C", "G").replace("T", "A");
//		if (newUserKey_roundTrip.equals(newScoreId_roundTrip)) 
//			return true;
		return false;
	}

	public static void searchUserKey(String userName, List<UserResult> userList, List<ScoreResult> scoreList) {
		for (UserResult user : userList) {
			if (user.getName().equals(userName)) {
				List<GeneResult> genList = user.getGeneList();
				for (GeneResult gene : genList) {
					String userKey = gene.getName() + gene.getValue();
					UserScoreResult userScore = calculateUserScore(userKey, scoreList);
					System.out.println("username: " + userName + ", userKey: " + userKey + ", " + userScore);
				}
			}
		}
	}
}
