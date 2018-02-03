package com.me.sustainable.living.service;

import java.util.List;

import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.core.User;

public interface UserService extends IService<User>{

	List<Goal> getGoalsForUser(String userId);
}
