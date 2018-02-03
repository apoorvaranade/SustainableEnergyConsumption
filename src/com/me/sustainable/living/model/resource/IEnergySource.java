package com.me.sustainable.living.model.resource;

import java.util.Date;

public interface IEnergySource {
	
	
	default public EnergyConsumptionType getUnit() {
		return EnergyConsumptionType.DEFAULT;
	}

	public int getConsumption(Date start, Date end);
}
