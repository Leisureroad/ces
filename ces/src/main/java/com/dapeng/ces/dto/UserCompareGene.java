package com.dapeng.ces.dto;

public class UserCompareGene {
    private String geneName;
    private String geneType;
    public String getGeneName() {
        return geneName;
    }
    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }
    public String getGeneType() {
        return geneType;
    }
    public void setGeneType(String geneType) {
        this.geneType = geneType;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserCompareGene [geneName=");
        builder.append(geneName);
        builder.append(", geneType=");
        builder.append(geneType);
        builder.append("]");
        return builder.toString();
    }
}
