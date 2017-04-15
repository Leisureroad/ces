package com.dapeng.ces.model;

public class GeneFeature {
	private String uuid;
	private String gene_code;
	private String gene_name;
	private String gene_type;
	private String gene_feature;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getGene_code() {
		return gene_code;
	}
	public void setGene_code(String gene_code) {
		this.gene_code = gene_code;
	}
	public String getGene_name() {
		return gene_name;
	}
	public void setGene_name(String gene_name) {
		this.gene_name = gene_name;
	}
	public String getGene_type() {
		return gene_type;
	}
	public void setGene_type(String gene_type) {
		this.gene_type = gene_type;
	}
	public String getGene_feature() {
		return gene_feature;
	}
	public void setGene_feature(String gene_feature) {
		this.gene_feature = gene_feature;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeneFeature [uuid=");
		builder.append(uuid);
		builder.append(", gene_code=");
		builder.append(gene_code);
		builder.append(", gene_name=");
		builder.append(gene_name);
		builder.append(", gene_type=");
		builder.append(gene_type);
		builder.append(", gene_feature=");
		builder.append(gene_feature);
		builder.append("]");
		return builder.toString();
	}
}
