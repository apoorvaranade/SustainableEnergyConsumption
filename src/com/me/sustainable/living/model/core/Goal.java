package com.me.sustainable.living.model.core;

import java.io.Serializable;

public class Goal implements Serializable {
	int goalId;

	public Goal(int goalId) {
		super();
		this.goalId = goalId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goalId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goal other = (Goal) obj;
		if (goalId != other.goalId)
			return false;
		return true;
	}
}
