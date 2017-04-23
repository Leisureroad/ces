package com.dapeng.ces.dto;

public class UserScoreFemaleResult {
    private String userId;
    
    private String name;
    
    private String geneCode1;

    private String geneName1;

    private String geneType1;

    private String geneCode2;

    private String geneName2;

    private String geneType2;

    private String injuryRisk;

    private Double injuryRiskScore;


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

    public String getGeneCode1() {
        return geneCode1;
    }

    public void setGeneCode1(String geneCode1) {
        this.geneCode1 = geneCode1 == null ? null : geneCode1.trim();
    }

    public String getGeneName1() {
        return geneName1;
    }

    public void setGeneName1(String geneName1) {
        this.geneName1 = geneName1 == null ? null : geneName1.trim();
    }

    public String getGeneType1() {
        return geneType1;
    }

    public void setGeneType1(String geneType1) {
        this.geneType1 = geneType1 == null ? null : geneType1.trim();
    }

    public String getGeneCode2() {
        return geneCode2;
    }

    public void setGeneCode2(String geneCode2) {
        this.geneCode2 = geneCode2 == null ? null : geneCode2.trim();
    }

    public String getGeneName2() {
        return geneName2;
    }

    public void setGeneName2(String geneName2) {
        this.geneName2 = geneName2 == null ? null : geneName2.trim();
    }

    public String getGeneType2() {
        return geneType2;
    }

    public void setGeneType2(String geneType2) {
        this.geneType2 = geneType2 == null ? null : geneType2.trim();
    }

    public String getInjuryRisk() {
        return injuryRisk;
    }

    public void setInjuryRisk(String injuryRisk) {
        this.injuryRisk = injuryRisk == null ? null : injuryRisk.trim();
    }

    public Double getInjuryRiskScore() {
        return injuryRiskScore;
    }

    public void setInjuryRiskScore(Double injuryRiskScore) {
        this.injuryRiskScore = injuryRiskScore;
    }
}