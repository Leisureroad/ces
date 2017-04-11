package com.dapeng.ces.model;

public class UserScore {
    private String uuid;

    private String userId;

    private String geneUuid;

    private String scoreUuid;

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

    public String getGeneUuid() {
        return geneUuid;
    }

    public void setGeneUuid(String geneUuid) {
        this.geneUuid = geneUuid == null ? null : geneUuid.trim();
    }

    public String getScoreUuid() {
        return scoreUuid;
    }

    public void setScoreUuid(String scoreUuid) {
        this.scoreUuid = scoreUuid == null ? null : scoreUuid.trim();
    }
}