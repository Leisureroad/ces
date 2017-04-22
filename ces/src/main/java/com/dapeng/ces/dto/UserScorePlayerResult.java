package com.dapeng.ces.dto;

import java.util.List;

public class UserScorePlayerResult {
    private String uuid;

    private String userId;

    private String name;
    
    private String sex;

    private String position384;

    private String star;
    
    private List<UserScoreDtoResult> userScoreNewResultList;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

	public String getPosition384() {
        return position384;
    }

    public void setPosition384(String position384) {
        this.position384 = position384;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public List<UserScoreDtoResult> getUserScoreNewResultList() {
        return userScoreNewResultList;
    }

    public void setUserScoreNewResultList(List<UserScoreDtoResult> userScoreNewResultList) {
        this.userScoreNewResultList = userScoreNewResultList;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserScorePlayerResult [uuid=");
		builder.append(uuid);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", position384=");
		builder.append(position384);
		builder.append(", star=");
		builder.append(star);
		builder.append(", userScoreNewResultList=");
		builder.append(userScoreNewResultList);
		builder.append("]");
		return builder.toString();
	}
}
