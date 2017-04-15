package com.dapeng.ces.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataImporter {
	private final static String XLS = "xls";
	private final static String XLSX = "xlsx";
	
	public static Workbook importDataFromExcel(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		String extensionName = FilenameUtils.getExtension(file.getName());
		Workbook workbook = null;
		if (extensionName.toLowerCase().equals(XLS)) {
			workbook = new HSSFWorkbook(is);
		} else if (extensionName.toLowerCase().equals(XLSX)) {
			workbook = new XSSFWorkbook(is);
		}
		return workbook;
	}
}
