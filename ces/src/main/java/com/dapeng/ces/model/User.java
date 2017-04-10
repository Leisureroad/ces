package com.dapeng.ces.model;

import java.util.List;

public class User {
	private String id;
	private String name;
	private String position_384;
	private List<Gene> geneList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition_384() {
		return position_384;
	}
	public void setPosition_384(String position_384) {
		this.position_384 = position_384;
	}
	public List<Gene> getGeneList() {
		return geneList;
	}
	public void setGeneList(List<Gene> geneList) {
		this.geneList = geneList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", position_384=");
		builder.append(position_384);
		builder.append(", geneList=");
		builder.append(geneList);
		builder.append("]");
		return builder.toString();
	}
	
}
