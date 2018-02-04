package com.me.sustainable.living.model.resource;

import java.util.Date;

public interface IEnergySource {

	public int getConsumption(Date start, Date end);

	EnergyConsumptionUnit getUnit();
	
}
