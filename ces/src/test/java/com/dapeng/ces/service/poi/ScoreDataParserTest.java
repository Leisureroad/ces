package com.dapeng.ces.service.poi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.dapeng.ces.dto.ScoreResult;
import com.dapeng.ces.dto.UserResult;

public class ScoreDataParserTest {

	@Test
	public void testParseExcelData() {
		String userDataExcelFile = "./data/测试数据 (1).xls";
		List<UserResult> userList = null;
		List<ScoreResult> scoreList = null;
		try {
//			userList = UserDataParser.parseExcelData(new File(userDataExcelFile), 0);
			userList = UserDataParser.parseExcelData();
//			scoreList = ScoreDataParser.parseExcelData(new File("./data/总体体质评估表+原始数据2 (1).xls"), 0);
			scoreList = ScoreDataParser.parseExcelData();
//			System.out.println(userList);
			System.out.println(scoreList);
//			System.out.println(scoreList.size());
//			ScoreDataParser.searchUserKey("刘孟", userList, scoreList);
			ScoreDataParser.searchUserKey("曾会丰", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏3", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏4", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏5", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏6", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏7", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏8", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏9", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏10", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏11", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏12", userList, scoreList);
			System.out.println(ScoreDataParser.parseInjuryRiskData_Female());
		} catch (IOException e) {
		}
	}
}
