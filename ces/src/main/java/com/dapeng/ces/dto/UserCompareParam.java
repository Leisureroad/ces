package com.dapeng.ces.dto;

import java.util.List;

public class UserCompareParam {
    private String userId;
    private Integer count;
    private List<UserCompareGene> userCompareGeneList;
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    
    public List<UserCompareGene> getUserCompareGeneList() {
        return userCompareGeneList;
    }
    public void setUserCompareGeneList(List<UserCompareGene> userCompareGeneList) {
        this.userCompareGeneList = userCompareGeneList;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserCompareParam [userId=");
        builder.append(userId);
        builder.append(", count=");
        builder.append(count);
        builder.append(", userCompareGeneList=");
        builder.append(userCompareGeneList);
        builder.append("]");
        return builder.toString();
    }
}
