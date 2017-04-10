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

import com.dapeng.ces.model.Gene;
import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.User;
import com.dapeng.ces.model.UserScore;
import com.dapeng.ces.util.ExcelDataImporter;

public class ScoreDataParser {

	public static List<Score> parseExcelData(File file, int sheetNum) throws IOException {
		Workbook workbook = ExcelDataImporter.importDataFromExcel(file, sheetNum);
		Sheet sheet = workbook.getSheetAt(sheetNum);
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

		List<Score> scoreList = new ArrayList<Score>();
		int minRowIx = sheet.getFirstRowNum();
		int maxRowIx = sheet.getLastRowNum();

		for (int rowIx = minRowIx; rowIx <= maxRowIx; rowIx++) {
			if (rowIx == 0 || rowIx == 4 || rowIx == 23 || rowIx == 48 || rowIx == 64)
				continue;
			if (rowIx == 83)
				break;
			Score score = new Score();
			Row row = sheet.getRow(rowIx);
			int minColIx = row.getFirstCellNum();
			int maxColIx = row.getLastCellNum();
			if (rowIx >= 1 && rowIx <= 3) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setExplosiveForce(cellValue.getStringValue());
						continue;
					}
					if (colIx == 5) {
						score.setExplosiveForceScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
				}
			}
			if (rowIx >= 5 && rowIx <= 22) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setStamina(cellValue.getStringValue());
						continue;
					}
					if (colIx == 5) {
						score.setStaminaScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
					if (colIx == 6) {
						score.setMotionSensitivity(cellValue.getStringValue());
						continue;
					}
					if (colIx == 7) {
						score.setMotionSensitivityScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
				}
			}
			if (rowIx >= 24 && rowIx <= 47) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setInjuryRecoveryAbility(cellValue.getStringValue());
						continue;
					}
					if (colIx == 5) {
						score.setInjuryRecoveryAbilityScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
				}
			}
			if (rowIx >= 49 && rowIx <= 63) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setInjuryRisk(cellValue.getStringValue());
						continue;
					}
					if (colIx == 5) {
						score.setInjuryRiskScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
				}
			}
			if (rowIx >= 65 && rowIx <= 82) {
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					getBasicProps(score, colIx, cellValue);
					if (colIx == 4) {
						score.setFatReducingSensitivity(cellValue.getStringValue());
						continue;
					}
					if (colIx == 5) {
						score.setFatReducingSensitivityScore(Double.valueOf(cellValue.getNumberValue()));
						continue;
					}
					if (colIx == 6) {
						score.setFatReducingSensitivity(cellValue.getStringValue());
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

	private static void getBasicProps(Score score, int colIx, CellValue cellValue) {
		String score_id;
		if (colIx == 0) {
			score.setNumber(String.valueOf(cellValue.getNumberValue()));
			return;
		}
		if (colIx == 1) {
			score.setGeneCode(cellValue.getStringValue());
			return;
		}
		if (colIx == 2) {
			score.setGeneName(cellValue.getStringValue());
			return;
		}
		if (colIx == 3) {
			score.setGeneType(cellValue.getStringValue());
			score_id = score.getGeneName() + score.getGeneType();
			score.setId(score_id);
			return;
		}
	}

	public static UserScore calculateUserScore(String userKey, List<Score> scoreList) {
		UserScore result = new UserScore();
		result.setUserKey(userKey);
		List<Score> userScoreList = new ArrayList<Score>();
		for (Score score : scoreList) {
			if (getMatchedKey(userKey, score.getId())) {
				Score oneScore = new Score();
				oneScore = score;
				userScoreList.add(oneScore);
			}
		}
		result.setUserScoreList(userScoreList);
		return result;
	}

	private static boolean getMatchedKey(String userKey, String scoreId) {
		if (userKey.equals(scoreId))
			return true;
		String newUserKey = userKey.replace("C", "G").replace("T", "A");
		String newScoreId = scoreId.replace("C", "G").replace("T", "A");
		if (newUserKey.equals(newScoreId)) 
			return true;
		String roundTrip_1 = userKey.substring(userKey.length()-2, userKey.length()-1);
		String roundTrip_2 = userKey.substring(userKey.length()-1, userKey.length());
		String tempUserKey = userKey.substring(0, userKey.length()-2) + roundTrip_2 + roundTrip_1;	
		String newUserKey_roundTrip = tempUserKey.replace("C", "G").replace("T", "A");
		if (tempUserKey.equals(scoreId)) 
			return true;
		String newScoreId_roundTrip = scoreId.replace("C", "G").replace("T", "A");
		if (newUserKey_roundTrip.equals(newScoreId_roundTrip)) 
			return true;
		return false;
	}

	public static void searchUserKey(String userName, List<User> userList, List<Score> scoreList) {
		for (User user : userList) {
			if (user.getName().equals(userName)) {
				List<Gene> genList = user.getGeneList();
				for (Gene gene : genList) {
					String userKey = gene.getName() + gene.getValue();
					UserScore userScore = calculateUserScore(userKey, scoreList);
					System.out.println("username: " + userName + ", userKey: " + userKey + ", " + userScore);
				}
			}
		}
	}
}
