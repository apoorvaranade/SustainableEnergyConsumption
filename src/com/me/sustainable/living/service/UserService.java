package com.me.sustainable.living.service;

import java.util.List;

import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.core.User;
import com.me.sustainable.living.model.resource.AbstractEnergySource;
import com.me.sustainable.living.model.resource.EnergyConsumptionType;

public interface UserService extends IService<User>{

	User saveConsumption(List<AbstractEnergySource> sourecList,int homeId);

	List<AbstractEnergySource> getConsumptionByHomeId(int homeId);
	
	List<Goal> setGoalsForHome(List<Goal> goals , int homeId);
	
	List<Goal> getGoalsForHome(int homeId);
	
	void updateGoalsForHome(int goalId, EnergyConsumptionType energyConsumptionType, int consumptionLimit);

}
