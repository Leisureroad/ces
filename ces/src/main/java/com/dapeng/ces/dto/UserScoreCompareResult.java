package com.dapeng.ces.dto;

public class UserScoreCompareResult {
	private String geneCode;
	
    private String geneName;

    private String geneType;

    public String getGeneCode() {
        return geneCode;
    }

    public void setGeneCode(String geneCode) {
        this.geneCode = geneCode;
    }

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
        builder.append("UserScoreCompareResult [geneCode=");
        builder.append(geneCode);
        builder.append(", geneName=");
        builder.append(geneName);
        builder.append(", geneType=");
        builder.append(geneType);
        builder.append("]");
        return builder.toString();
    }
}
