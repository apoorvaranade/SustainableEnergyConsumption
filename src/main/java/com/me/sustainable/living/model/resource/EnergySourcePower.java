package com.me.sustainable.living.model.resource;

import java.util.Date;


public class EnergySourcePower extends AbstractEnergySource{
	
	public EnergySourcePower() {
		setUnit(EnergyConsumptionUnit.WATTS);
		setType(EnergyConsumptionType.POWER);
	}

	public EnergySourcePower(int consumptionAmount , Date asOfDate){
		this();
		setConsumptionAmount(consumptionAmount);
		setAsOfDate(asOfDate);
	}

}
