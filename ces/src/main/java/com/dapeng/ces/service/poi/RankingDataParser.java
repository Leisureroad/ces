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

import com.dapeng.ces.constant.ItemTypeConstant;
import com.dapeng.ces.model.NationalRanking;
import com.dapeng.ces.util.ExcelDataImporter;

public class RankingDataParser {
	
	public static List<NationalRanking> parseExcelData() throws IOException {
		Workbook workbook = ExcelDataImporter.importDataFromExcel(new File("./data/总体体质评估表+全国排名.xls"));
		Sheet sheet = workbook.getSheetAt(0);
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

		List<NationalRanking> rankingList = new ArrayList<NationalRanking>();
		int minRowIx = sheet.getFirstRowNum();
		int maxRowIx = sheet.getLastRowNum();

		for (int rowIx = minRowIx; rowIx < maxRowIx; rowIx++) {
			if (rowIx == 0 || rowIx == 7 || rowIx == 17 || rowIx == 24 || rowIx == 28)
				continue;
			NationalRanking ranking = new NationalRanking();
			Row row = sheet.getRow(rowIx);
			int minColIx = row.getFirstCellNum();
			int maxColIx = row.getLastCellNum();
			if (rowIx >= 1 && rowIx <= 6) {
				ranking.setItem_type(ItemTypeConstant.ITEM_TYPE_EXPLOSIVEFORCE);
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					if (colIx >= 9 ) {
						break;
					}
					if (colIx == 0) {
						ranking.setGene_code1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 1) {
						ranking.setGene_name1(cellValue.getStringValue().trim());
						ranking.setKey1(ranking.getGene_code1() + ranking.getGene_name1());
						continue;
					}
					if (colIx == 2) {
						ranking.setGene_type1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 3) {
						ranking.setGene_code2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 4) {
						ranking.setGene_name2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						ranking.setGene_type2(cellValue.getStringValue().trim());
						ranking.setKey2(ranking.getGene_code2() + ranking.getGene_name2());
						continue;
					}
					if (colIx == 6) {
						ranking.setRanking(Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
					if (colIx == 7) {
						ranking.setRanking(ranking.getRanking() + cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 8) {
						ranking.setRanking(ranking.getRanking() + Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
				}
			}
			if (rowIx >= 8 && rowIx <= 16) {
				ranking.setItem_type(ItemTypeConstant.ITEM_TYPE_STAMINA);
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					if (colIx >= 9 ) {
						break;
					}
					if (colIx == 0) {
						ranking.setGene_code1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 1) {
						ranking.setGene_name1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 2) {
						ranking.setGene_type1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 3) {
						ranking.setGene_code2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 4) {
						ranking.setGene_name2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						ranking.setGene_type2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 6) {
						ranking.setRanking(Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
					if (colIx == 7) {
						ranking.setRanking(ranking.getRanking() + cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 8) {
						ranking.setRanking(ranking.getRanking() + Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
				}
			}
			if (rowIx >= 18 && rowIx <= 23) {
				ranking.setItem_type(ItemTypeConstant.ITEM_TYPE_INJURYRECOVERABILITY);
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					if (colIx >= 9 ) {
						break;
					}
					if (colIx == 0) {
						ranking.setGene_code1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 1) {
						ranking.setGene_name1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 2) {
						ranking.setGene_type1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 3) {
						ranking.setGene_code2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 4) {
						ranking.setGene_name2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						ranking.setGene_type2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 6) {
						ranking.setRanking(Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
					if (colIx == 7) {
						ranking.setRanking(ranking.getRanking() + cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 8) {
						ranking.setRanking(ranking.getRanking() + Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
				}
			}
			if (rowIx >= 25 && rowIx <= 27) {
				ranking.setItem_type(ItemTypeConstant.ITEM_TYPE_INJURYRISK);
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					if (colIx >= 9 ) {
						break;
					}
					if (colIx == 0) {
						ranking.setGene_code1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 1) {
						ranking.setGene_name1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 2) {
						ranking.setGene_type1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 3) {
						ranking.setGene_code2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 4) {
						ranking.setGene_name2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						ranking.setGene_type2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 6) {
						ranking.setRanking(Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
					if (colIx == 7) {
						ranking.setRanking(ranking.getRanking() + cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 8) {
						ranking.setRanking(ranking.getRanking() + Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
				}
			}
			if (rowIx >= 29 && rowIx <= 32) {
				ranking.setItem_type(ItemTypeConstant.ITEM_TYPE_OBESITYRISK_FATREDUCINGSENSITIVITY);
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					if (colIx >= 9 ) {
						break;
					}
					if (colIx == 0) {
						ranking.setGene_code1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 1) {
						ranking.setGene_name1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 2) {
						ranking.setGene_type1(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 3) {
						ranking.setGene_code2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 4) {
						ranking.setGene_name2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 5) {
						ranking.setGene_type2(cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 6) {
						ranking.setRanking(Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
					if (colIx == 7) {
						ranking.setRanking(ranking.getRanking() + cellValue.getStringValue().trim());
						continue;
					}
					if (colIx == 8) {
						ranking.setRanking(ranking.getRanking() + Double.toString(cellValue.getNumberValue()) + "%");
						continue;
					}
				}
			}
			rankingList.add(ranking);
		}
		return rankingList;
	}
}
