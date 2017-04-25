package com.dapeng.ces.dto;

import java.util.List;

public class UserOriginalPlayerResult {
    private String userId;
    
    private String name;
    
    private List<GenePlayerResult> genePlayerList;

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

    public List<GenePlayerResult> getGenePlayerList() {
        return genePlayerList;
    }

    public void setGenePlayerList(List<GenePlayerResult> genePlayerList) {
        this.genePlayerList = genePlayerList;
    }
}
