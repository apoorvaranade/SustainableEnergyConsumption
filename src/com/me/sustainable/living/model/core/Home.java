package com.me.sustainable.living.model.core;

import java.io.Serializable;

public class Home implements Serializable {

	// List<EnergyType> resource = new LinkedList<EnergyType>();
	private int homeId;

	public Home(int homeId) {
		this.homeId = homeId;
	}

	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + homeId;
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
		Home other = (Home) obj;
		if (homeId != other.homeId)
			return false;
		return true;
	}

}
