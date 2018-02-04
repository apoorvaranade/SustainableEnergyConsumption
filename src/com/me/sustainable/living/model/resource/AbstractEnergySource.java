package com.me.sustainable.living.model.resource;

import java.util.Date;


public class AbstractEnergySource implements IEnergySource {
	
	Date asOfDate; 
	int consumptionAmount;
	EnergyConsumptionType type;
	EnergyConsumptionUnit unit;
	
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
	@Override
	public int getConsumption(Date start, Date end) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public EnergyConsumptionUnit getUnit() {
		return null;
	}

}
