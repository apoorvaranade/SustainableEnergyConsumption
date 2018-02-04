package com.me.sustainable.living.dao.sql;

public class SQLHolder {
	public static final String GET_USER="SELECT * FROM user WHERE USER_ID = :userId";
	public static final String GET_USER_DETAIL="select u.user_id,u.user_name,h.home_id,g.goal_id,resource_cte.resource_type from user u left join home h on u.user_id  = h.user_id left join goal g on g.home_id = h.home_id left join (select distinct r.home_id,r.resource_type from resource r)resource_cte  on h.HOME_ID = resource_cte.home_id WHERE u.USER_ID = :userId;";
	public static final String GET_HOME="SELECT * FROM home WHERE USER_ID = :userId";
	
	public static final String SAVE_RESOURCES="insert into resource values(:resourceId,:resourceType, :amountUsed, :asOfDate , :homeId)";
	
}
