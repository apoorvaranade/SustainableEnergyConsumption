package com.me.sustainable.living.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.sustainable.living.dao.UserDao;
import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.core.Home;
import com.me.sustainable.living.model.core.User;
import com.me.sustainable.living.model.resource.AbstractEnergySource;
import com.me.sustainable.living.model.resource.EnergySourceGas;
import com.me.sustainable.living.model.resource.EnergySourcePower;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getEntity(int id) {
		return userDao.getUser(id);
	}

	@Override
	public List<Goal> getGoalsForUser(String userId) {
		return null;
	}

	@Override
	public User setHomeResources(List<AbstractEnergySource> energyResourceList, int id) {
		
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
	    Home home = new Home("Home", resources);
	    user.setHome(home);
	    
	    userDao.saveUserHomeResources(user);
	    
		return user;  
		    
	}
	
	@Override
	public User setGoalsForUser(List<Goal> goals, int userId) {
		return null;
	}

	@Override
	public List<AbstractEnergySource> getConsumption(int homeId) {
		return null;
	}
	
}
