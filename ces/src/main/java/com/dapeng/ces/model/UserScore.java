package com.dapeng.ces.model;

import java.util.List;

public class UserScore {
	private String userKey;
	private List<Score> userScoreList;
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public List<Score> getUserScoreList() {
		return userScoreList;
	}
	public void setUserScoreList(List<Score> userScoreList) {
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
