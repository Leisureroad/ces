package com.dapeng.ces.service.freemarker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WordAction {

	private String filePath; // 文件路径
	private String fileName; // 文件名称
	private String fileOnlyName; // 文件唯一名称

	public String createWord(Map<String, Object> dataMap, String userName) {
		/** 用于组装word页面需要的数据 */
//		Map<String, Object> dataMap = new HashMap<String, Object>();

		/** 组装数据 */
//		dataMap.put("userName", "张三");

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//		dataMap.put("currDate", sdf.format(new Date()));
//
//		dataMap.put("content", "这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容");

//		List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
//		for (int i = 1; i <= 10; i++) {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("title", "标题" + i);
//			map.put("content", "内容" + (i * 2));
//			map.put("author", "作者" + (i * 3));
//			newsList.add(map);
//		}
//		dataMap.put("newsList", newsList);

		/** 文件名称，唯一字符串 */
//		Random r = new Random();
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
//		StringBuffer sb = new StringBuffer();
//		sb.append(sdf1.format(new Date()));
//		sb.append("_");
//		sb.append(r.nextInt(100));

		// 文件路径
		filePath = "./";

		// 文件唯一名称
		fileOnlyName = "五维运动DNA检测报告_" + userName + ".doc";

		// 文件名称
//		fileName = "用freemarker导出的Word文档.doc";

		/** 生成word */
		WordUtil.createWord(dataMap, "五维运动DNA检测报告.ftl", filePath, fileOnlyName);

		return "createWordSuccess";
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileOnlyName() {
		return fileOnlyName;
	}

	public void setFileOnlyName(String fileOnlyName) {
		this.fileOnlyName = fileOnlyName;
	}
	
//	public static void main(String[] args) {
//		WordAction action = new WordAction();
//		action.createWord();
//	}

}