package com.me.sustainable.living.service;

import java.util.List;

import com.me.sustainable.living.model.core.User;
import com.me.sustainable.living.model.resource.AbstractEnergySource;

public interface IService<T> {

	public User getEntity(int id);
	
}
