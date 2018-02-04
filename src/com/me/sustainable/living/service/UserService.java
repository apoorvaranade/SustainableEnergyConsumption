package com.me.sustainable.living.service;

import java.util.List;

import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.core.User;
import com.me.sustainable.living.model.resource.AbstractEnergySource;

public interface UserService extends IService<User>{

	List<Goal> getGoalsForUser(String userId);
	
	User setGoalsForUser(List<Goal> goals , int userId);
	
    List<AbstractEnergySource> getConsumption(int homeId);
    
	User setHomeResources(List<AbstractEnergySource> sourecList,int id);

}
