package com.me.sustainable.living.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.me.sustainable.living.dao.sql.SQLHolder;
import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.resource.EnergyConsumptionType;
@Service
@Component
public class GoalDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public int saveGoalsForHome(int homeId) {
		
		// DAO call to update goal table and retrive goal id and return it
		String sql = SQLHolder.SET_GOAL;
		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("homeID", homeId);
        npJdbcTemplate.update(sql,namedParameters,generatedKeyHolder);
        int goalId = generatedKeyHolder.getKey().intValue();
		return goalId;
	}
	
	public void updateGoalsForHome(int goalId, EnergyConsumptionType energyConsumptionType, int consumptionLimit) {

		String sql = SQLHolder.UPDATE_GOAL;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("resourceType", energyConsumptionType.toString());
		paramMap.put("goalID", goalId);
		paramMap.put("consumptionLimit", consumptionLimit);
		int row = npJdbcTemplate.update(sql, paramMap);
	}

	public List<Goal> getGoalsForHome(int homeId) {
		String sql = SQLHolder.GET_GOALS;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("homeId", homeId);
		List<Goal> goalList = npJdbcTemplate.query(sql, paramMap , new ResultSetExtractor<List<Goal>>() {

			@Override
			public List<Goal> extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				List<Goal> goalList = new ArrayList<Goal>();
				while (rs.next()) {
					Goal goal = new Goal(rs.getInt("GOAL_ID"), rs.getDouble("consumption_limit") , EnergyConsumptionType.valueOf(rs.getString("resource_type")));
					goalList.add(goal);
				}
				return goalList;
			}
		});
		return goalList;
	}

	public void saveDetailsForGoal(List<Goal> goals, int goalId) {

		String sql = SQLHolder.SET_GOAL_DETAILS;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (Goal goal : goals) {
			paramMap.put("goalID", goalId);
			paramMap.put("resourceType", goal.getResourceType().toString());
			paramMap.put("consumptionLimit", goal.getConsumptionLimit());
			int row = npJdbcTemplate.update(sql, paramMap);
		}
	}
}
