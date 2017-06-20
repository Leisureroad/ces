package com.dapeng.ces.model;

public class Score {
    private String uuid;

    private String scoreId;

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
    
    private String heartLungFunction;
    
    private Double heartLungFunctionScore;
    
    private String energySupply;
    
    private Double energySupplyScore; 
    
    private String jointRisk;
    
    private Double jointRiskScore; 

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId == null ? null : scoreId.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getGeneCode() {
        return geneCode;
    }

    public void setGeneCode(String geneCode) {
        this.geneCode = geneCode == null ? null : geneCode.trim();
    }

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName == null ? null : geneName.trim();
    }

    public String getGeneType() {
        return geneType;
    }

    public void setGeneType(String geneType) {
        this.geneType = geneType == null ? null : geneType.trim();
    }

    public String getExplosiveForce() {
        return explosiveForce;
    }

    public void setExplosiveForce(String explosiveForce) {
        this.explosiveForce = explosiveForce == null ? null : explosiveForce.trim();
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
        this.stamina = stamina == null ? null : stamina.trim();
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
        this.motionSensitivity = motionSensitivity == null ? null : motionSensitivity.trim();
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
        this.injuryRecoveryAbility = injuryRecoveryAbility == null ? null : injuryRecoveryAbility.trim();
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
        this.injuryRisk = injuryRisk == null ? null : injuryRisk.trim();
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
        this.obesityRisk = obesityRisk == null ? null : obesityRisk.trim();
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
        this.fatReducingSensitivity = fatReducingSensitivity == null ? null : fatReducingSensitivity.trim();
    }

    public Double getFatReducingSensitivityScore() {
        return fatReducingSensitivityScore;
    }

    public void setFatReducingSensitivityScore(Double fatReducingSensitivityScore) {
        this.fatReducingSensitivityScore = fatReducingSensitivityScore;
    }

	public String getHeartLungFunction() {
		return heartLungFunction;
	}

	public void setHeartLungFunction(String heartLungFunction) {
		this.heartLungFunction = heartLungFunction == null ? null : heartLungFunction.trim();
	}

	public Double getHeartLungFunctionScore() {
		return heartLungFunctionScore;
	}

	public void setHeartLungFunctionScore(Double heartLungFunctionScore) {
		this.heartLungFunctionScore = heartLungFunctionScore;
	}

	public String getEnergySupply() {
		return energySupply;
	}

	public void setEnergySupply(String energySupply) {
		this.energySupply = energySupply == null ? null : energySupply.trim();
	}

	public Double getEnergySupplyScore() {
		return energySupplyScore;
	}

	public void setEnergySupplyScore(Double energySupplyScore) {
		this.energySupplyScore = energySupplyScore;
	}

	public String getJointRisk() {
		return jointRisk;
	}

	public void setJointRisk(String jointRisk) {
		this.jointRisk = jointRisk == null ? null : jointRisk.trim();
	}

	public Double getJointRiskScore() {
		return jointRiskScore;
	}

	public void setJointRiskScore(Double jointRiskScore) {
		this.jointRiskScore = jointRiskScore;
	}
    
    
}