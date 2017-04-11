package com.dapeng.ces.dto;

public class ScoreResult {
	private String id;
	private String number;
	private String geneCode;
	private String geneName;
	private String geneType;
	private String explosiveForce;
	private Double explosiveForceScore;
	private String stamina;
	private Double staminaScore;
	private String motionSensitivity;
	private Double motionSensitivityScore;
	private String injuryRecoveryAbility;
	private Double injuryRecoveryAbilityScore;
	private String injuryRisk;
	private Double injuryRiskScore;
	private String obesityRisk;
	private Double obesityRiskScore;
	private String fatReducingSensitivity;
	private Double fatReducingSensitivityScore;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
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
	public String getExplosiveForce() {
		return explosiveForce;
	}
	public void setExplosiveForce(String explosiveForce) {
		this.explosiveForce = explosiveForce;
	}
	public Double getExplosiveForceScore() {
		return explosiveForceScore;
	}
	public void setExplosiveForceScore(Double explosiveForceScore) {
		this.explosiveForceScore = explosiveForceScore;
	}
	public String getStamina() {
		return stamina;
	}
	public void setStamina(String stamina) {
		this.stamina = stamina;
	}
	public Double getStaminaScore() {
		return staminaScore;
	}
	public void setStaminaScore(Double staminaScore) {
		this.staminaScore = staminaScore;
	}
	public String getMotionSensitivity() {
		return motionSensitivity;
	}
	public void setMotionSensitivity(String motionSensitivity) {
		this.motionSensitivity = motionSensitivity;
	}
	public Double getMotionSensitivityScore() {
		return motionSensitivityScore;
	}
	public void setMotionSensitivityScore(Double motionSensitivityScore) {
		this.motionSensitivityScore = motionSensitivityScore;
	}
	public String getInjuryRecoveryAbility() {
		return injuryRecoveryAbility;
	}
	public void setInjuryRecoveryAbility(String injuryRecoveryAbility) {
		this.injuryRecoveryAbility = injuryRecoveryAbility;
	}
	public Double getInjuryRecoveryAbilityScore() {
		return injuryRecoveryAbilityScore;
	}
	public void setInjuryRecoveryAbilityScore(Double injuryRecoveryAbilityScore) {
		this.injuryRecoveryAbilityScore = injuryRecoveryAbilityScore;
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
	public String getObesityRisk() {
		return obesityRisk;
	}
	public void setObesityRisk(String obesityRisk) {
		this.obesityRisk = obesityRisk;
	}
	public Double getObesityRiskScore() {
		return obesityRiskScore;
	}
	public void setObesityRiskScore(Double obesityRiskScore) {
		this.obesityRiskScore = obesityRiskScore;
	}
	public String getFatReducingSensitivity() {
		return fatReducingSensitivity;
	}
	public void setFatReducingSensitivity(String fatReducingSensitivity) {
		this.fatReducingSensitivity = fatReducingSensitivity;
	}
	public Double getFatReducingSensitivityScore() {
		return fatReducingSensitivityScore;
	}
	public void setFatReducingSensitivityScore(Double fatReducingSensitivityScore) {
		this.fatReducingSensitivityScore = fatReducingSensitivityScore;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Score [id=");
		builder.append(id);
		builder.append(", number=");
		builder.append(number);
		builder.append(", geneCode=");
		builder.append(geneCode);
		builder.append(", geneName=");
		builder.append(geneName);
		builder.append(", geneType=");
		builder.append(geneType);
		builder.append(", explosiveForce=");
		builder.append(explosiveForce);
		builder.append(", explosiveForceScore=");
		builder.append(explosiveForceScore);
		builder.append(", stamina=");
		builder.append(stamina);
		builder.append(", staminaScore=");
		builder.append(staminaScore);
		builder.append(", motionSensitivity=");
		builder.append(motionSensitivity);
		builder.append(", motionSensitivityScore=");
		builder.append(motionSensitivityScore);
		builder.append(", injuryRecoveryAbility=");
		builder.append(injuryRecoveryAbility);
		builder.append(", injuryRecoveryAbilityScore=");
		builder.append(injuryRecoveryAbilityScore);
		builder.append(", injuryRisk=");
		builder.append(injuryRisk);
		builder.append(", injuryRiskScore=");
		builder.append(injuryRiskScore);
		builder.append(", obesityRisk=");
		builder.append(obesityRisk);
		builder.append(", obesityRiskScore=");
		builder.append(obesityRiskScore);
		builder.append(", fatReducingSensitivity=");
		builder.append(fatReducingSensitivity);
		builder.append(", fatReducingSensitivityScore=");
		builder.append(fatReducingSensitivityScore);
		builder.append("]");
		return builder.toString();
	}
	
}
