package com.me.sustainable.living.model.resource;

import java.util.Date;

public class EnergySourceGas extends AbstractEnergySource{

	EnergyConsumptionType type;
	
	@Override
	public EnergyConsumptionType getUnit() {
		return EnergyConsumptionType.GAS;
	}
	
	@Override
	public int getConsumption(Date start, Date end) {
		// TODO Auto-generated method stub
		return 0;
	}

}
