package com.dapeng.ces.dto;

public class UserScorePerItemResult {
	private String userId;
	private String name;
//    private Double explosiveForceScore;
    private Double explosiveForceScore_percentage;
    private String explosiveForceScore_ranking;
//    private Double staminaScore;
    private Double staminaScore_percentage;
    private String staminaScore_ranking;
//    private Double injuryRecoveryAbilityScore;
    private Double injuryRecoveryAbilityScore_percentage;
    private String injuryRecoveryAbilityScore_ranking;
//    private Double injuryRiskScore;
    private Double injuryRiskScore_percentage;
    private String injuryRiskScore_ranking;
//    private Double obesityRiskScore;
    private Double obesityRiskScore_percentage;
    private String obesityRiskScore_ranking;
    private Double fatReducingSensitivityScore_percentage;
    private String fatReducingSensitivityScore_ranking;
    private Double heartLungFunctionScore_percentage;
    private String heartLungFunctionScore_ranking;
    private Double energySupplyScore_percentage;
    private String energySupplyScore_ranking;
    
//    private Double fatReducingSensitivityScore;
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
	public Double getExplosiveForceScore_percentage() {
		return explosiveForceScore_percentage;
	}
	public void setExplosiveForceScore_percentage(Double explosiveForceScore_percentage) {
		this.explosiveForceScore_percentage = explosiveForceScore_percentage;
	}
	public String getExplosiveForceScore_ranking() {
		return explosiveForceScore_ranking;
	}
	public void setExplosiveForceScore_ranking(String explosiveForceScore_ranking) {
		this.explosiveForceScore_ranking = explosiveForceScore_ranking;
	}
	public Double getStaminaScore_percentage() {
		return staminaScore_percentage;
	}
	public void setStaminaScore_percentage(Double staminaScore_percentage) {
		this.staminaScore_percentage = staminaScore_percentage;
	}
	public String getStaminaScore_ranking() {
		return staminaScore_ranking;
	}
	public void setStaminaScore_ranking(String staminaScore_ranking) {
		this.staminaScore_ranking = staminaScore_ranking;
	}
	public Double getInjuryRecoveryAbilityScore_percentage() {
		return injuryRecoveryAbilityScore_percentage;
	}
	public void setInjuryRecoveryAbilityScore_percentage(Double injuryRecoveryAbilityScore_percentage) {
		this.injuryRecoveryAbilityScore_percentage = injuryRecoveryAbilityScore_percentage;
	}
	public String getInjuryRecoveryAbilityScore_ranking() {
		return injuryRecoveryAbilityScore_ranking;
	}
	public void setInjuryRecoveryAbilityScore_ranking(String injuryRecoveryAbilityScore_ranking) {
		this.injuryRecoveryAbilityScore_ranking = injuryRecoveryAbilityScore_ranking;
	}
	public Double getInjuryRiskScore_percentage() {
		return injuryRiskScore_percentage;
	}
	public void setInjuryRiskScore_percentage(Double injuryRiskScore_percentage) {
		this.injuryRiskScore_percentage = injuryRiskScore_percentage;
	}
	public String getInjuryRiskScore_ranking() {
		return injuryRiskScore_ranking;
	}
	public void setInjuryRiskScore_ranking(String injuryRiskScore_ranking) {
		this.injuryRiskScore_ranking = injuryRiskScore_ranking;
	}
	public Double getObesityRiskScore_percentage() {
		return obesityRiskScore_percentage;
	}
	public void setObesityRiskScore_percentage(Double obesityRiskScore_percentage) {
		this.obesityRiskScore_percentage = obesityRiskScore_percentage;
	}
	public String getObesityRiskScore_ranking() {
		return obesityRiskScore_ranking;
	}
	public void setObesityRiskScore_ranking(String obesityRiskScore_ranking) {
		this.obesityRiskScore_ranking = obesityRiskScore_ranking;
	}
	public Double getFatReducingSensitivityScore_percentage() {
		return fatReducingSensitivityScore_percentage;
	}
	public void setFatReducingSensitivityScore_percentage(Double fatReducingSensitivityScore_percentage) {
		this.fatReducingSensitivityScore_percentage = fatReducingSensitivityScore_percentage;
	}
	public String getFatReducingSensitivityScore_ranking() {
		return fatReducingSensitivityScore_ranking;
	}
	public void setFatReducingSensitivityScore_ranking(String fatReducingSensitivityScore_ranking) {
		this.fatReducingSensitivityScore_ranking = fatReducingSensitivityScore_ranking;
	}
	public Double getHeartLungFunctionScore_percentage() {
		return heartLungFunctionScore_percentage;
	}
	public void setHeartLungFunctionScore_percentage(Double heartLungFunctionScore_percentage) {
		this.heartLungFunctionScore_percentage = heartLungFunctionScore_percentage;
	}
	public String getHeartLungFunctionScore_ranking() {
		return heartLungFunctionScore_ranking;
	}
	public void setHeartLungFunctionScore_ranking(String heartLungFunctionScore_ranking) {
		this.heartLungFunctionScore_ranking = heartLungFunctionScore_ranking;
	}
	public Double getEnergySupplyScore_percentage() {
		return energySupplyScore_percentage;
	}
	public void setEnergySupplyScore_percentage(Double energySupplyScore_percentage) {
		this.energySupplyScore_percentage = energySupplyScore_percentage;
	}
	public String getEnergySupplyScore_ranking() {
		return energySupplyScore_ranking;
	}
	public void setEnergySupplyScore_ranking(String energySupplyScore_ranking) {
		this.energySupplyScore_ranking = energySupplyScore_ranking;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserScorePerItemResult [userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", explosiveForceScore_percentage=");
		builder.append(explosiveForceScore_percentage);
		builder.append(", explosiveForceScore_ranking=");
		builder.append(explosiveForceScore_ranking);
		builder.append(", staminaScore_percentage=");
		builder.append(staminaScore_percentage);
		builder.append(", staminaScore_ranking=");
		builder.append(staminaScore_ranking);
		builder.append(", injuryRecoveryAbilityScore_percentage=");
		builder.append(injuryRecoveryAbilityScore_percentage);
		builder.append(", injuryRecoveryAbilityScore_ranking=");
		builder.append(injuryRecoveryAbilityScore_ranking);
		builder.append(", injuryRiskScore_percentage=");
		builder.append(injuryRiskScore_percentage);
		builder.append(", injuryRiskScore_ranking=");
		builder.append(injuryRiskScore_ranking);
		builder.append(", obesityRiskScore_percentage=");
		builder.append(obesityRiskScore_percentage);
		builder.append(", obesityRiskScore_ranking=");
		builder.append(obesityRiskScore_ranking);
		builder.append(", fatReducingSensitivityScore_percentage=");
		builder.append(fatReducingSensitivityScore_percentage);
		builder.append(", fatReducingSensitivityScore_ranking=");
		builder.append(fatReducingSensitivityScore_ranking);
		builder.append(", heartLungFunctionScore_percentage=");
		builder.append(heartLungFunctionScore_percentage);
		builder.append(", heartLungFunctionScore_ranking=");
		builder.append(heartLungFunctionScore_ranking);
		builder.append(", energySupplyScore_percentage=");
		builder.append(energySupplyScore_percentage);
		builder.append(", energySupplyScore_ranking=");
		builder.append(energySupplyScore_ranking);
		builder.append("]");
		return builder.toString();
	}
	
}
