package com.me.sustainable.living.dao.sql;

public class SQLHolder {
	public static final String GET_USER = "SELECT * FROM user WHERE USER_ID = :userId";
	public static final String GET_USER_DETAIL = "select u.user_id,u.user_name,h.home_id,g.goal_id,resource_cte.resource_type from user u left join home h on u.user_id  = h.user_id left join goal g on g.home_id = h.home_id left join (select distinct r.home_id,r.resource_type from resource r)resource_cte  on h.HOME_ID = resource_cte.home_id WHERE u.USER_ID = :userId";
	public static final String GET_HOME_CONSUMPTION = "select * from resource where HOME_ID = :homeID";

	public static final String UPDATE_GOAL = "update goal_detail set consumption_limit = :consumptionLimit where resource_type = :resourceType and GOAL_ID= :goalID";
	public static final String SET_GOAL = "insert into goal (HOME_ID) values( :homeID)";
	// join
	public static final String GET_GOALS = "select g.GOAL_ID,gd.consumption_limit,gd.resource_type from goal g , goal_detail gd where g.GOAL_ID= gd.GOAL_ID and g.HOME_ID = :homeId";
	public static final String SET_GOAL_DETAILS = "insert into goal_detail (GOAL_ID , resource_type , consumption_limit ) values(:goalID , :resourceType , :consumptionLimit)";
	public static final String GET_HOME = "SELECT * FROM home WHERE USER_ID = :userId";
	public static final String SAVE_RESOURCES = "insert into resource values(:resourceId,:resourceType, :amountUsed, :asOfDate , :homeId)";
}
