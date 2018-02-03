package com.me.sustainable.living.model.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Serializable {

	private static final long serialVersionUID = 5745820694966852830L;
	private int userId;
	private String userName;

	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	private Map<Home, List<Goal>> homeGoalMap = new HashMap<Home, List<Goal>>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<Home, List<Goal>> getHomeGoalMap() {
		return homeGoalMap;
	}

}
