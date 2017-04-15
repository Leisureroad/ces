package com.dapeng.ces.service.poi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.dapeng.ces.model.GeneFeature;

public class GeneFeatureDataParserTest {

	@Test
	public void testParseExcelData() {
		String geneFeatureExcelFile = "./data/features.xls";
		List<GeneFeature> geneFeatureList = null;
		try {
			geneFeatureList = GeneFeatureDataParser.parseExcelData(new File(geneFeatureExcelFile), 0);
			System.out.println(geneFeatureList);
			String geneFeature =GeneFeatureDataParser.getGeneFeature("ACTN3", "rs1815739", "CC", geneFeatureList);
			System.out.println(geneFeature);
		} catch (IOException e) {
		}
	}

}
