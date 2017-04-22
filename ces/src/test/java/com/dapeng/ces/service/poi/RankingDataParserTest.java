package com.dapeng.ces.service.poi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.dapeng.ces.dto.NationalRankingExcel;

public class RankingDataParserTest {

	@Test
	public void testParseExcelData() {
		List<NationalRankingExcel> rankingList = null;
		try {
			rankingList = RankingDataParser.parseExcelData();
			System.out.println(rankingList);
		} catch (IOException e) {
		}
	}
}
