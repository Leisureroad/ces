package com.dapeng.ces.model;

public class NationalRanking {
	private String uuid;
	private String item_type;
	private String gene_code1;
	private String gene_name1;
	private String gene_type1;
	private String gene_code2;
	private String gene_name2;
	private String gene_type2;
	private String ranking;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getGene_code1() {
		return gene_code1;
	}
	public void setGene_code1(String gene_code1) {
		this.gene_code1 = gene_code1;
	}
	public String getGene_name1() {
		return gene_name1;
	}
	public void setGene_name1(String gene_name1) {
		this.gene_name1 = gene_name1;
	}
	public String getGene_type1() {
		return gene_type1;
	}
	public void setGene_type1(String gene_type1) {
		this.gene_type1 = gene_type1;
	}
	public String getGene_code2() {
		return gene_code2;
	}
	public void setGene_code2(String gene_code2) {
		this.gene_code2 = gene_code2;
	}
	public String getGene_name2() {
		return gene_name2;
	}
	public void setGene_name2(String gene_name2) {
		this.gene_name2 = gene_name2;
	}
	public String getGene_type2() {
		return gene_type2;
	}
	public void setGene_type2(String gene_type2) {
		this.gene_type2 = gene_type2;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ranking [uuid=");
		builder.append(uuid);
		builder.append(", item_type=");
		builder.append(item_type);
		builder.append(", gene_code1=");
		builder.append(gene_code1);
		builder.append(", gene_name1=");
		builder.append(gene_name1);
		builder.append(", gene_type1=");
		builder.append(gene_type1);
		builder.append(", gene_code2=");
		builder.append(gene_code2);
		builder.append(", gene_name2=");
		builder.append(gene_name2);
		builder.append(", gene_type2=");
		builder.append(gene_type2);
		builder.append(", ranking=");
		builder.append(ranking);
		builder.append("]");
		return builder.toString();
	}
}
