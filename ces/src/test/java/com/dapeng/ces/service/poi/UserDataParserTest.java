package com.dapeng.ces.service.poi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.dapeng.ces.dto.UserResult;

public class UserDataParserTest {

	@Test
	public void testParseExcelData() {
//		String path = "./data/测试数据 (1).xls";
		List<UserResult> list = null;
		try {
//			list = UserDataParser.parseExcelData(new File(path), 0);
			list = UserDataParser.parseExcelData();
			System.out.println(list);
		} catch (IOException e) {
		}
	}

}
