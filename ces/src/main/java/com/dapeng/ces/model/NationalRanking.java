package com.dapeng.ces.model;

public class NationalRanking {
    private String uuid;

    private String itemType;

    private String key1;

    private String geneCode1;

    private String geneName1;

    private String geneType1;

    private String key2;

    private String geneCode2;

    private String geneName2;

    private String geneType2;

    private String ranking;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1 == null ? null : key1.trim();
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

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2 == null ? null : key2.trim();
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

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking == null ? null : ranking.trim();
    }
}