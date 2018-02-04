package com.me.sustainable.living.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.sustainable.living.model.core.EntityType;

@Service
@Transactional
public class DelegatorService<T> {
	//IService service;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	public <T extends IService<?>> Object getService(EntityType type)
	{
		switch(type)
		{  case USER: return  userServiceImpl;
		
		   default: return  userServiceImpl;
			
		}
	}
}
