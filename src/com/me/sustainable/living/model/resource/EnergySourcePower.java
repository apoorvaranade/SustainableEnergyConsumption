package com.me.sustainable.living.model.resource;

import java.util.Date;


public class EnergySourcePower extends AbstractEnergySource{

	public EnergySourcePower(int consumptionAmount , Date asOfDate){
		this.consumptionAmount = consumptionAmount;
		this.type = EnergyConsumptionType.POWER;
		this.asOfDate = asOfDate;
	}

	@Override
	public EnergyConsumptionUnit getUnit() {
		return EnergyConsumptionUnit.WATTS;
	}
	
	@Override
	public int getConsumption(Date start, Date end) {
		return 0;
	}

}
