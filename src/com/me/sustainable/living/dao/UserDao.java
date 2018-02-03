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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.me.sustainable.living.dao.sql.SQLHolder;
import com.me.sustainable.living.model.core.Goal;
import com.me.sustainable.living.model.core.Home;
import com.me.sustainable.living.model.core.User;

public class UserDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public User getUser(int userId) {
		String sql = SQLHolder.GET_USER;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		User user = npJdbcTemplate.queryForObject(sql, paramMap, User.class);

		return user;
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
