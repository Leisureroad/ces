package com.dapeng.ces.dto;

import java.util.List;

public class UserCompareResult {
    private String userId;

    private String name;
    
    private String sex;
    //总位点数
    private Integer rsTotal;
    //匹配上的最大位点数
    private Integer rsMax;

    private List<UserScoreCompareResult> userScoreCompareList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

    public Integer getRsTotal() {
        return rsTotal;
    }

    public void setRsTotal(Integer rsTotal) {
        this.rsTotal = rsTotal;
    }

    public Integer getRsMax() {
        return rsMax;
    }

    public void setRsMax(Integer rsMax) {
        this.rsMax = rsMax;
    }

    public List<UserScoreCompareResult> getUserScoreCompareList() {
        return userScoreCompareList;
    }

    public void setUserScoreCompareList(List<UserScoreCompareResult> userScoreCompareList) {
        this.userScoreCompareList = userScoreCompareList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserCompareResult [userId=");
        builder.append(userId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", sex=");
        builder.append(sex);
        builder.append(", rsTotal=");
        builder.append(rsTotal);
        builder.append(", rsMax=");
        builder.append(rsMax);
        builder.append(", userScoreCompareList=");
        builder.append(userScoreCompareList);
        builder.append("]");
        return builder.toString();
    }
}
