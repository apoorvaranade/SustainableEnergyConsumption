package com.me.sustainable.living.model.core;

import java.io.Serializable;

import com.me.sustainable.living.model.resource.EnergyConsumptionType;

public class Goal implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int goalId;

	private Double consumptionLimit;
	
	private EnergyConsumptionType resourceType;
	
	public Goal() {
		
	}
	public Goal(int goalId, Double consumptionLimit, EnergyConsumptionType resourceType) {
		super();
		this.goalId = goalId;
		this.consumptionLimit = consumptionLimit;
		this.resourceType = resourceType;
	}

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public Goal(int goalId) {
		super();
		this.goalId = goalId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goalId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goal other = (Goal) obj;
		if (goalId != other.goalId)
			return false;
		return true;
	}

	public Double getConsumptionLimit() {
		return consumptionLimit;
	}

	public void setConsumptionLimit(Double consumptionLimit) {
		this.consumptionLimit = consumptionLimit;
	}

	public EnergyConsumptionType getResourceType() {
		return resourceType;
	}

	public void setResourceType(EnergyConsumptionType resourceType) {
		this.resourceType = resourceType;
	}
}
