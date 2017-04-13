package com.dapeng.ces.service.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.dapeng.ces.dto.UserScoreNewResult;
import com.dapeng.ces.util.ExportExcel;

public class UserScoreDataExporter {

	public void export2Excel(List<UserScoreNewResult> userScoreResult, String userName) throws IOException {
		String[] headers = { "编号", "姓名", "uuid", "基因", "位点", "基因型", "爆发力", "爆发力得分", "耐力	", "耐力得分", "耐力运动敏感度", "耐力运动敏感度得分",
				"运动损伤的恢复能力", "恢复能力得分", "韧带、关节损伤风险", "韧带、关节损伤风险得分", "肥胖风险", "肥胖风险得分", "运动减脂敏感性", "运动减肥敏感性" };
		ExportExcel<UserScoreNewResult> ex = new ExportExcel<UserScoreNewResult>();
		OutputStream out = new FileOutputStream(userName+".xls");
		ex.exportExcel(headers, userScoreResult, out);
		out.close();
		System.out.println("excel导出成功！");
	}
}
