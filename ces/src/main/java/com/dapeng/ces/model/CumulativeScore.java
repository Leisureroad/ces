package com.dapeng.ces.model;

public class CumulativeScore {
    private String userId;

    private String name;

    private String star;

    private String sex;

    private Double explosiveForceStaminaCorePercentage;

    private Double injuryRecoveryAbilityScorePercentage;

    private Double injuryRiskScorePercentage;

    private Double obesityRiskScorePercentage;
    
    private Double heartLungFunctionScorePercentage;
    
    private Double energySupplyScorePercentage;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Double getExplosiveForceStaminaCorePercentage() {
        return explosiveForceStaminaCorePercentage;
    }

    public void setExplosiveForceStaminaCorePercentage(Double explosiveForceStaminaCorePercentage) {
        this.explosiveForceStaminaCorePercentage = explosiveForceStaminaCorePercentage;
    }

    public Double getInjuryRecoveryAbilityScorePercentage() {
        return injuryRecoveryAbilityScorePercentage;
    }

    public void setInjuryRecoveryAbilityScorePercentage(Double injuryRecoveryAbilityScorePercentage) {
        this.injuryRecoveryAbilityScorePercentage = injuryRecoveryAbilityScorePercentage;
    }

    public Double getInjuryRiskScorePercentage() {
        return injuryRiskScorePercentage;
    }

    public void setInjuryRiskScorePercentage(Double injuryRiskScorePercentage) {
        this.injuryRiskScorePercentage = injuryRiskScorePercentage;
    }

    public Double getObesityRiskScorePercentage() {
        return obesityRiskScorePercentage;
    }

    public void setObesityRiskScorePercentage(Double obesityRiskScorePercentage) {
        this.obesityRiskScorePercentage = obesityRiskScorePercentage;
    }

	public Double getHeartLungFunctionScorePercentage() {
		return heartLungFunctionScorePercentage;
	}

	public void setHeartLungFunctionScorePercentage(Double heartLungFunctionScorePercentage) {
		this.heartLungFunctionScorePercentage = heartLungFunctionScorePercentage;
	}

	public Double getEnergySupplyScorePercentage() {
		return energySupplyScorePercentage;
	}

	public void setEnergySupplyScorePercentage(Double energySupplyScorePercentage) {
		this.energySupplyScorePercentage = energySupplyScorePercentage;
	}
}