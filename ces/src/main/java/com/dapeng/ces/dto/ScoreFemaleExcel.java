package com.dapeng.ces.dto;

public class ScoreFemaleExcel {
	private String uuid;
	private String geneCode1;
	private String geneName1;
	private String geneType1;
	private String geneCode2;
	private String geneName2;
	private String geneType2;
	private String injuryRisk;
	private Double injuryRiskScore;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getGeneCode1() {
		return geneCode1;
	}
	public void setGeneCode1(String geneCode1) {
		this.geneCode1 = geneCode1;
	}
	public String getGeneName1() {
		return geneName1;
	}
	public void setGeneName1(String geneName1) {
		this.geneName1 = geneName1;
	}
	public String getGeneType1() {
		return geneType1;
	}
	public void setGeneType1(String geneType1) {
		this.geneType1 = geneType1;
	}
	public String getGeneCode2() {
		return geneCode2;
	}
	public void setGeneCode2(String geneCode2) {
		this.geneCode2 = geneCode2;
	}
	public String getGeneName2() {
		return geneName2;
	}
	public void setGeneName2(String geneName2) {
		this.geneName2 = geneName2;
	}
	public String getGeneType2() {
		return geneType2;
	}
	public void setGeneType2(String geneType2) {
		this.geneType2 = geneType2;
	}
	public String getInjuryRisk() {
		return injuryRisk;
	}
	public void setInjuryRisk(String injuryRisk) {
		this.injuryRisk = injuryRisk;
	}
	public Double getInjuryRiskScore() {
		return injuryRiskScore;
	}
	public void setInjuryRiskScore(Double injuryRiskScore) {
		this.injuryRiskScore = injuryRiskScore;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScoreFemale [uuid=");
		builder.append(uuid);
		builder.append(", geneCode1=");
		builder.append(geneCode1);
		builder.append(", geneName1=");
		builder.append(geneName1);
		builder.append(", geneType1=");
		builder.append(geneType1);
		builder.append(", geneCode2=");
		builder.append(geneCode2);
		builder.append(", geneName2=");
		builder.append(geneName2);
		builder.append(", geneType2=");
		builder.append(geneType2);
		builder.append(", injuryRisk=");
		builder.append(injuryRisk);
		builder.append(", injuryRiskScore=");
		builder.append(injuryRiskScore);
		builder.append("]");
		return builder.toString();
	}
}
