package com.dapeng.ces.dto;

public class UserScoreNewResult {
	private String userId;
	
	private String name;
	
	private String geneUuid;
	
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

    public String getGeneUuid() {
        return geneUuid;
    }

    public void setGeneUuid(String geneUuid) {
        this.geneUuid = geneUuid;
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
        builder.append("UserScoreNewResult [userId=");
        builder.append(userId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", geneUuid=");
        builder.append(geneUuid);
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
