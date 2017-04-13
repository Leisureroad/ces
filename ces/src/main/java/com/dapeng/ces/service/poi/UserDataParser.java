package com.dapeng.ces.service.poi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.dapeng.ces.dto.GeneResult;
import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.util.ExcelDataImporter;

public class UserDataParser {

	public static Map<Integer, String> geneDictionary = new HashMap<Integer, String>();

	public static List<UserResult> parseExcelData(File file, int sheetNum) throws IOException {
		Workbook workbook = ExcelDataImporter.importDataFromExcel(file, sheetNum);

		Sheet sheet = workbook.getSheetAt(sheetNum);
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

		List<UserResult> userList = new ArrayList<UserResult>();
		int minRowIx = sheet.getFirstRowNum();
		int maxRowIx = sheet.getLastRowNum();
		for (int rowIx = minRowIx; rowIx <= maxRowIx; rowIx++) {
			if (rowIx == 0)
				continue;
			if (rowIx == 1) {
				Row row = sheet.getRow(rowIx);
				int minColIx = row.getFirstCellNum();
				int maxColIx = row.getLastCellNum();
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					if (colIx == 0) {
						continue;
					}
					if (colIx == 1) {
						continue;
					}
					if (colIx == 2) {
						continue;
					}
					if (colIx >= 3) {
						geneDictionary.put(Integer.valueOf(colIx), cellValue.getStringValue());
					}
				}
			}

			if (rowIx >= 2) {
				UserResult user = new UserResult();
				List<GeneResult> geneList = new ArrayList<GeneResult>();
				Row row = sheet.getRow(rowIx);
				int minColIx = row.getFirstCellNum();
				int maxColIx = row.getLastCellNum();
				for (int colIx = minColIx; colIx <= maxColIx; colIx++) {
					Cell cell = row.getCell(new Integer(colIx));
					CellValue cellValue = evaluator.evaluate(cell);
					if (cellValue == null) {
						continue;
					}
					if (colIx == 0) {
						user.setPosition_384(cellValue.getStringValue());
						continue;
					}
					if (colIx == 1) {
						user.setId(cellValue.getStringValue());
						continue;
					}
					if (colIx == 2) {
						user.setName(cellValue.getStringValue());
						continue;
					}
					if (colIx == 3) {
						user.setSex(cellValue.getStringValue());
						continue;
					}
					if (colIx >= 4) {
						GeneResult gene = new GeneResult();
						gene.setName(geneDictionary.get(Integer.valueOf(colIx)));
						String value = cellValue.getStringValue();
						if (value.length() == 1) {
							 value += value ; 
						}
						gene.setValue(value);
						geneList.add(gene);
					}
				}
				user.setGeneList(geneList);
				userList.add(user);
			}
		}
		return userList;
	}
}
