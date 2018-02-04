package com.me.sustainable.living.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.sustainable.living.dao.GoalDao;
import com.me.sustainable.living.dao.UserDao;
import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.core.Home;
import com.me.sustainable.living.model.core.User;
import com.me.sustainable.living.model.resource.AbstractEnergySource;
import com.me.sustainable.living.model.resource.EnergyConsumptionType;
import com.me.sustainable.living.model.resource.EnergySourceGas;
import com.me.sustainable.living.model.resource.EnergySourcePower;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GoalDao goalDao;
	
	@Override
	public User getEntity(int id) {
		return userDao.getUser(id);
	}

	@Override
	public User saveConsumption(List<AbstractEnergySource> energyResourceList, int homeId) {
		
		User user = new User(1, "Apoorva");
		List<AbstractEnergySource> resources = new ArrayList<>();
		
	    for(AbstractEnergySource enrrySource : energyResourceList) {  
	      switch (enrrySource.getType()) {
	        case POWER:
	          resources.add(new EnergySourcePower(enrrySource.getConsumptionAmount() , enrrySource.getAsOfDate()));
	          break;
	        case GAS:
	          resources.add(new EnergySourceGas(enrrySource.getConsumptionAmount(), enrrySource.getAsOfDate()));  
	          break;
	        default:
	          System.err.println("Incorrect resource type! Try again, please.");
	      }
	    }
	    Home home = new Home("Home", resources , homeId);
	    user.setHome(home);
	    
	    userDao.saveUserHomeResources(user);
	    
		return user;  
		    
	}
	

	@Override
	public List<AbstractEnergySource> getConsumptionByHomeId(int homeId) {
		return userDao.getConsumptionByHomeId(homeId);
	}

	@Override
	public List<Goal> setGoalsForHome(List<Goal> goals, int homeId) {

		int goalId = goalDao.saveGoalsForHome(homeId);
		goalDao.saveDetailsForGoal(goals , goalId);
		return goals;
	}

	@Override
	public List<Goal> getGoalsForHome(int homeId) {
		return goalDao.getGoalsForHome(homeId);
	}

	@Override
	public void updateGoalsForHome(int goalId, EnergyConsumptionType energyConsumptionType , int consumptionLimit) {  
		goalDao.updateGoalsForHome(goalId, energyConsumptionType , consumptionLimit);  
	}
	
}
