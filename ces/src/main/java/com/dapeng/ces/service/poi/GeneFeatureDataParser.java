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

import com.dapeng.ces.model.GeneFeature;
import com.dapeng.ces.util.ExcelDataImporter;

public class GeneFeatureDataParser {

	public static List<GeneFeature> parseExcelData(File file, int sheetNum) throws IOException {
		Workbook workbook = ExcelDataImporter.importDataFromExcel(file);

		Sheet sheet = workbook.getSheetAt(sheetNum);
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

		List<GeneFeature> geneFeatureList = new ArrayList<GeneFeature>();
		int minRowIx = sheet.getFirstRowNum();
		int maxRowIx = sheet.getLastRowNum();
		for (int rowIx = minRowIx; rowIx <= maxRowIx; rowIx++) {
			if (rowIx == 0)
				continue;
			if (rowIx >= 1) {
				GeneFeature geneFeature = new GeneFeature();
				
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
						geneFeature.setGene_code(cellValue.getStringValue());
						continue;
					}
					if (colIx == 1) {
						geneFeature.setGene_name(cellValue.getStringValue());
						continue;
					}
					if (colIx == 2) {
						geneFeature.setGene_type(cellValue.getStringValue());
						continue;
					}
					if (colIx == 3) {
						geneFeature.setGene_feature(cellValue.getStringValue());
					}
				}
				geneFeatureList.add(geneFeature);
			}
		}
		return geneFeatureList;
	}
	
	public static String getGeneFeature(String geneCode, String geneName, String geneType, List<GeneFeature> geneFeatureList) {
		String result = "";
		for (GeneFeature geneFeature : geneFeatureList) {
			if (geneCode.equals(geneFeature.getGene_code()) && geneName.equals(geneFeature.getGene_name()) && geneType.equals(geneFeature.getGene_type())) {
				result = geneFeature.getGene_feature();
				break;
			}
		}
		return result;
	}
}
