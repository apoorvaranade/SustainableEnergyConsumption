package com.me.sustainable.living.service;

import java.util.List;

import com.me.sustainable.living.dao.UserDao;
import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.core.User;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	@Override
	public User getEntity(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public List<Goal> getGoalsForUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
