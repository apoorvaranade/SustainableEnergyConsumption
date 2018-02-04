package com.me.sustainable.living.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.me.sustainable.living.dao.sql.SQLHolder;
import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.core.Home;
import com.me.sustainable.living.model.core.User;
import com.me.sustainable.living.model.resource.AbstractEnergySource;
import com.me.sustainable.living.model.resource.EnergyConsumptionType;
import com.me.sustainable.living.model.resource.EnergySourceGas;
import com.me.sustainable.living.model.resource.EnergySourcePower;

@Service
@Component
public class UserDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public User getUser(int userId) {
		String sql = SQLHolder.GET_USER;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		User user = npJdbcTemplate.query(sql, paramMap, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = null;

				while (rs.next()) {
					user = new User(rs.getInt("USER_ID"), rs.getString("USER_NAME"));
				}
				return user;
			}
		});

		return user;
	}

	public void saveUserHomeResources(User user) {

		String sql = SQLHolder.SAVE_RESOURCES;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int idCount = 18;
		for (AbstractEnergySource energySource : user.getHome().getResources()) {
			// paramMap.put("resourceId", idCount);
			paramMap.put("homeId", user.getHome().getHomeId());
			paramMap.put("resourceType", energySource.getType().toString());
			paramMap.put("amountUsed", energySource.getConsumptionAmount());
			paramMap.put("asOfDate", new Date());
			int row = npJdbcTemplate.update(sql, paramMap);
			idCount++;
		}

	}

	public List<AbstractEnergySource> getConsumptionByHomeId(int homeId) {

		String sql = SQLHolder.GET_HOME_CONSUMPTION;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("homeID", homeId);
		List<AbstractEnergySource> resourcesList = npJdbcTemplate.query(sql, paramMap,
				new ResultSetExtractor<List<AbstractEnergySource>>() {

					@Override
					public List<AbstractEnergySource> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<AbstractEnergySource> resourcesList = new ArrayList<AbstractEnergySource>();

						EnergySourceGas energySourceGas = new EnergySourceGas();
						energySourceGas.setAsOfDate(new Date());
						EnergySourcePower energySourcePower = new EnergySourcePower();
						energySourcePower.setAsOfDate(new Date());

						while (rs.next()) {

							if (EnergyConsumptionType.GAS.toString().equalsIgnoreCase(rs.getString("RESOURCE_TYPE"))) {
								energySourceGas.setConsumptionAmount(
										energySourceGas.getConsumptionAmount() + rs.getInt("AMT_USED"));
							} else if (EnergyConsumptionType.POWER.toString()
									.equalsIgnoreCase(rs.getString("RESOURCE_TYPE"))) {
								energySourcePower.setConsumptionAmount(
										energySourcePower.getConsumptionAmount() + rs.getInt("AMT_USED"));
							}
						}

						resourcesList.add(energySourceGas);
						resourcesList.add(energySourcePower);

						return resourcesList;
					}
				});
		logger.info("User Consumption Details for Home ID : " + homeId );
		return resourcesList;
	}

	public User getUserDetails(int userId) {

		String sql = SQLHolder.GET_USER_DETAIL;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		User user = npJdbcTemplate.query(sql, paramMap, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = null;
				Map<Integer, User> userMap = new HashMap<Integer, User>();
				Map<Integer, Home> homeMap = new HashMap<Integer, Home>();

				while (rs.next()) {
					user = userMap.get(rs.getInt("USER_ID"));
					if (user == null) {
						userMap.put(rs.getInt("USER_ID"), new User(rs.getInt("USER_ID"), rs.getString("USER_NAME")));
					}
					// set remaining user fields if present
					Home home = homeMap.get(rs.getInt("HOME_ID"));
					if (home == null) {
						homeMap.put(rs.getInt("HOME_ID"), new Home(rs.getInt("HOME_ID")));
					}
					// set remaining home fields if present
					if (!user.getHomeGoalMap().keySet().contains(home))
						user.getHomeGoalMap().put(home, new ArrayList<Goal>());
					List<Goal> homeGoals = user.getHomeGoalMap().get(home);
					Goal goal = new Goal(rs.getInt("GOAL_ID"));
					if (!homeGoals.contains(goal)) {
						homeGoals.add(goal);
					}
					// set remaining goal fields if present

				}
				return user;
			}
		});

		return user;
	}

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setNpJdbcTemplate(NamedParameterJdbcTemplate npJdbcTemplate) {
		this.npJdbcTemplate = npJdbcTemplate;
	}
}
