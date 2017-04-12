package com.dapeng.ces.service.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dapeng.ces.dto.UserScoreNewResult;
import com.dapeng.ces.util.ExportExcel;

public class UserScoreDataExporter {
	public static void export2Excel(String userName) throws IOException {
		String[] headers = { "编号", "基因", "位点", "基因型", "爆发力", "爆发力得分", "运动损伤的恢复能力", "恢复能力得分", "韧带、关节损伤风险", "韧带、关节损伤风险得分",
				"肥胖风险", "肥胖风险得分", "运动减脂敏感性", "运动减肥敏感性" };
		ExportExcel<UserScoreNewResult> ex = new ExportExcel<UserScoreNewResult>();
		List<UserScoreNewResult> dataset = new ArrayList<UserScoreNewResult>();
//		dataset.add(new UserScoreNewResult(10000001, "张三", 20, true, new Date()));
//		dataset.add(new UserScoreNewResult(20000002, "李四", 24, false, new Date()));
//		dataset.add(new UserScoreNewResult(30000003, "王五", 22, true, new Date()));
		OutputStream out = new FileOutputStream("a.xls");
		ex.exportExcel(headers, dataset, out);
		out.close();
		JOptionPane.showMessageDialog(null, "导出成功!");
		System.out.println("excel导出成功！");
	}
	
	public static void main(String[] args) throws IOException {
		UserScoreDataExporter.export2Excel("");
	}
}
