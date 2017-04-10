package com.dapeng.ces.service.poi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.User;

public class ScoreDataParserTest {

	@Test
	public void testParseExcelData() {
		String scoreExcelFile = "./data/new.xls";
		String userDataExcelFile = "./data/原始数据_mock.xls";
		List<User> userList = null;
		List<Score> scoreList = null;
		try {
			userList = UserDataParser.parseExcelData(new File(userDataExcelFile), 0);
			scoreList = ScoreDataParser.parseExcelData(new File(scoreExcelFile), 0);
//			System.out.println(userList);
//			System.out.println(scoreList);
//			System.out.println(scoreList.size());
			ScoreDataParser.searchUserKey("王大鹏1", userList, scoreList);
//			ScoreDataParser.searchUserKey("王大鹏2", userList, scoreList);
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
		} catch (IOException e) {
		}
	}
}
