package com.me.sustainable.living.model.resource;

import java.util.Date;

public class EnergySourceGas extends AbstractEnergySource{

	public EnergySourceGas(int consumptionAmount , Date asOfDate){
		this.consumptionAmount = consumptionAmount;
		this.type = EnergyConsumptionType.GAS;
		this.asOfDate = asOfDate;
	}
	
	@Override
	public EnergyConsumptionUnit getUnit() {
		return EnergyConsumptionUnit.KILOGRAMS;
	}
	
	@Override
	public int getConsumption(Date start, Date end) {
		return 0;
	}

}
