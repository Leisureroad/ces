package com.dapeng.ces.model;

public class UserScoreFemale {
    private String uuid;

    private String userId;

    private String geneUuid;

    private String scoreFemaleUuid;

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

    public String getScoreFemaleUuid() {
        return scoreFemaleUuid;
    }

    public void setScoreFemaleUuid(String scoreFemaleUuid) {
        this.scoreFemaleUuid = scoreFemaleUuid == null ? null : scoreFemaleUuid.trim();
    }
}