package com.dapeng.ces.service.poi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.dapeng.ces.model.User;

public class UserDataParserTest {

	@Test
	public void testParseExcelData() {
		String path = "./data/原始数据_mock.xls";
		List<User> list = null;
		try {
			list = UserDataParser.parseExcelData(new File(path), 0);
			System.out.println(list);
		} catch (IOException e) {
		}
	}

}
