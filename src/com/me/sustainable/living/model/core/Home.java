package com.me.sustainable.living.model.core;

import java.io.Serializable;
import java.util.List;

import com.me.sustainable.living.model.resource.AbstractEnergySource;

public class Home implements Serializable {

	private static final long serialVersionUID = 1L;

	private int homeId;
	private String name;
	private Double sustainabilityScore;
	private List<AbstractEnergySource> resources;
	private List<Goal> goals;

	public Home(String name, List<AbstractEnergySource> resources , int homeId) {
		this.name = name;
		this.resources = resources;
		this.homeId = homeId;
	}

	public Home() {
	}
	
	public int getHomeId() {
		return homeId;
	}

	public Double getSustainabilityScore() {
		return sustainabilityScore;
	}

	public void setSustainabilityScore(Double sustainabilityScore) {
		this.sustainabilityScore = sustainabilityScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AbstractEnergySource> getResources() {
		return resources;
	}

	public void setResources(List<AbstractEnergySource> resources) {
		this.resources = resources;
	}

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

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

}
