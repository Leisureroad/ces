package com.dapeng.ces.dto;

public class UserScorePerItemResult {
	private String userId;
	private String name;
    private Double explosiveForceScore;
    private Double explosiveForceScore_percentage;
    private Double staminaScore;
    private Double staminaScore_percentage;
    private Double injuryRecoveryAbilityScore;
    private Double injuryRecoveryAbilityScore_percentage;
    private Double injuryRiskScore;
    private Double injuryRiskScore_percentage;
    private Double obesityRiskScore;
    private Double obesityRiskScore_percentage;
    private Double fatReducingSensitivityScore;
    private Double fatReducingSensitivityScore_percentage;
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
	public Double getExplosiveForceScore() {
		return explosiveForceScore;
	}
	public void setExplosiveForceScore(Double explosiveForceScore) {
		this.explosiveForceScore = explosiveForceScore;
	}
	public Double getExplosiveForceScore_percentage() {
		return explosiveForceScore_percentage;
	}
	public void setExplosiveForceScore_percentage(Double explosiveForceScore_percentage) {
		this.explosiveForceScore_percentage = explosiveForceScore_percentage;
	}
	public Double getStaminaScore() {
		return staminaScore;
	}
	public void setStaminaScore(Double staminaScore) {
		this.staminaScore = staminaScore;
	}
	public Double getStaminaScore_percentage() {
		return staminaScore_percentage;
	}
	public void setStaminaScore_percentage(Double staminaScore_percentage) {
		this.staminaScore_percentage = staminaScore_percentage;
	}
	public Double getInjuryRecoveryAbilityScore() {
		return injuryRecoveryAbilityScore;
	}
	public void setInjuryRecoveryAbilityScore(Double injuryRecoveryAbilityScore) {
		this.injuryRecoveryAbilityScore = injuryRecoveryAbilityScore;
	}
	public Double getInjuryRecoveryAbilityScore_percentage() {
		return injuryRecoveryAbilityScore_percentage;
	}
	public void setInjuryRecoveryAbilityScore_percentage(Double injuryRecoveryAbilityScore_percentage) {
		this.injuryRecoveryAbilityScore_percentage = injuryRecoveryAbilityScore_percentage;
	}
	public Double getInjuryRiskScore() {
		return injuryRiskScore;
	}
	public void setInjuryRiskScore(Double injuryRiskScore) {
		this.injuryRiskScore = injuryRiskScore;
	}
	public Double getInjuryRiskScore_percentage() {
		return injuryRiskScore_percentage;
	}
	public void setInjuryRiskScore_percentage(Double injuryRiskScore_percentage) {
		this.injuryRiskScore_percentage = injuryRiskScore_percentage;
	}
	public Double getObesityRiskScore() {
		return obesityRiskScore;
	}
	public void setObesityRiskScore(Double obesityRiskScore) {
		this.obesityRiskScore = obesityRiskScore;
	}
	public Double getObesityRiskScore_percentage() {
		return obesityRiskScore_percentage;
	}
	public void setObesityRiskScore_percentage(Double obesityRiskScore_percentage) {
		this.obesityRiskScore_percentage = obesityRiskScore_percentage;
	}
	public Double getFatReducingSensitivityScore() {
		return fatReducingSensitivityScore;
	}
	public void setFatReducingSensitivityScore(Double fatReducingSensitivityScore) {
		this.fatReducingSensitivityScore = fatReducingSensitivityScore;
	}
	public Double getFatReducingSensitivityScore_percentage() {
		return fatReducingSensitivityScore_percentage;
	}
	public void setFatReducingSensitivityScore_percentage(Double fatReducingSensitivityScore_percentage) {
		this.fatReducingSensitivityScore_percentage = fatReducingSensitivityScore_percentage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserScorePerItemResult [userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", explosiveForceScore=");
		builder.append(explosiveForceScore);
		builder.append(", explosiveForceScore_percentage=");
		builder.append(explosiveForceScore_percentage);
		builder.append(", staminaScore=");
		builder.append(staminaScore);
		builder.append(", staminaScore_percentage=");
		builder.append(staminaScore_percentage);
		builder.append(", injuryRecoveryAbilityScore=");
		builder.append(injuryRecoveryAbilityScore);
		builder.append(", injuryRecoveryAbilityScore_percentage=");
		builder.append(injuryRecoveryAbilityScore_percentage);
		builder.append(", injuryRiskScore=");
		builder.append(injuryRiskScore);
		builder.append(", injuryRiskScore_percentage=");
		builder.append(injuryRiskScore_percentage);
		builder.append(", obesityRiskScore=");
		builder.append(obesityRiskScore);
		builder.append(", obesityRiskScore_percentage=");
		builder.append(obesityRiskScore_percentage);
		builder.append(", fatReducingSensitivityScore=");
		builder.append(fatReducingSensitivityScore);
		builder.append(", fatReducingSensitivityScore_percentage=");
		builder.append(fatReducingSensitivityScore_percentage);
		builder.append("]");
		return builder.toString();
	}
}
