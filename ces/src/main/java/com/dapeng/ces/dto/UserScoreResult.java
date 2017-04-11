package com.dapeng.ces.dto;

import java.util.List;

public class UserScoreResult {
	private String userKey;
	private List<ScoreResult> userScoreList;
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public List<ScoreResult> getUserScoreList() {
		return userScoreList;
	}
	public void setUserScoreList(List<ScoreResult> userScoreList) {
		this.userScoreList = userScoreList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserScore [userKey=");
		builder.append(userKey);
		builder.append(", userScoreList=");
		builder.append(userScoreList);
		builder.append("]");
		return builder.toString();
	}
}
