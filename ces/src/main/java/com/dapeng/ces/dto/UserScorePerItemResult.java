package com.dapeng.ces.dto;

public class UserScorePerItemResult {
	private String userId;
	private String name;
    private Double explosiveForceScore;
    private Double staminaScore;
//    private Double motionSensitivityScore;
    private Double injuryRecoveryAbilityScore;
    private Double injuryRiskScore;
    private Double obesityRiskScore;
    private Double fatReducingSensitivityScore;
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
	public Double getStaminaScore() {
		return staminaScore;
	}
	public void setStaminaScore(Double staminaScore) {
		this.staminaScore = staminaScore;
	}
//	public Double getMotionSensitivityScore() {
//		return motionSensitivityScore;
//	}
//	public void setMotionSensitivityScore(Double motionSensitivityScore) {
//		this.motionSensitivityScore = motionSensitivityScore;
//	}
	public Double getInjuryRecoveryAbilityScore() {
		return injuryRecoveryAbilityScore;
	}
	public void setInjuryRecoveryAbilityScore(Double injuryRecoveryAbilityScore) {
		this.injuryRecoveryAbilityScore = injuryRecoveryAbilityScore;
	}
	public Double getInjuryRiskScore() {
		return injuryRiskScore;
	}
	public void setInjuryRiskScore(Double injuryRiskScore) {
		this.injuryRiskScore = injuryRiskScore;
	}
	public Double getObesityRiskScore() {
		return obesityRiskScore;
	}
	public void setObesityRiskScore(Double obesityRiskScore) {
		this.obesityRiskScore = obesityRiskScore;
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
		builder.append("UserScorePerItemResult [userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", explosiveForceScore=");
		builder.append(explosiveForceScore);
		builder.append(", staminaScore=");
		builder.append(staminaScore);
//		builder.append(", motionSensitivityScore=");
//		builder.append(motionSensitivityScore);
		builder.append(", injuryRecoveryAbilityScore=");
		builder.append(injuryRecoveryAbilityScore);
		builder.append(", injuryRiskScore=");
		builder.append(injuryRiskScore);
		builder.append(", obesityRiskScore=");
		builder.append(obesityRiskScore);
		builder.append(", fatReducingSensitivityScore=");
		builder.append(fatReducingSensitivityScore);
		builder.append("]");
		return builder.toString();
	}
}
