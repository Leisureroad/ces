package com.dapeng.ces.model;

public class User {
    private String uuid;

    private String userId;

    private String name;

    private String position384;

    private String star;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition384() {
        return position384;
    }

    public void setPosition384(String position384) {
        this.position384 = position384 == null ? null : position384.trim();
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }
}