package com.me.sustainable.living.model.resource;

import java.util.Date;

public class EnergySourceGas extends AbstractEnergySource{
	
	public EnergySourceGas(){
		setUnit(EnergyConsumptionUnit.KILOGRAMS);
		setType(EnergyConsumptionType.GAS);
	}

	public EnergySourceGas(int consumptionAmount , Date asOfDate){
		this();
		setConsumptionAmount(consumptionAmount);
		setAsOfDate(asOfDate);
	}

}
