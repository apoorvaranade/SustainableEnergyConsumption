package com.me.sustainable.living.model.resource;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = EnergySourceGas.class, name = "GAS") , @JsonSubTypes.Type(value = EnergySourcePower.class, name = "POWER")}) //add more sub types
public abstract class AbstractEnergySource implements IEnergySource {
	
	private Date asOfDate; 
	private int consumptionAmount;
	private EnergyConsumptionType type;
	private EnergyConsumptionUnit unit;
	
	public void setUnit(EnergyConsumptionUnit unit) {
		this.unit = unit;
	}
	public Date getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}
	public int getConsumptionAmount() {
		return consumptionAmount;
	}
	public void setConsumptionAmount(int consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}
	public EnergyConsumptionType getType() {
		return type;
	}
	public void setType(EnergyConsumptionType type) {
		this.type = type;
	}
	public EnergyConsumptionUnit getUnit() {
		return unit;
	}

}
