package com.me.sustainable.living.service;

import com.me.sustainable.living.model.core.EntityType;

public class DelegatorService {
	//IService service;
	
	public IService getEntity(EntityType type)
	{
		switch(type)
		{
			case USER: return new UserServiceImpl();
		}
		return null;
	}
}
