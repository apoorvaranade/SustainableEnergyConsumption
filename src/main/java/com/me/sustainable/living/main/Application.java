package com.me.sustainable.living.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication(scanBasePackages={"com.me"})
@EnableAutoConfiguration(exclude={ DataSourceAutoConfiguration.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Value("${spring.datasource.url}")
	private String url; 
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	
	@Bean(name = "dataSource")
	@Primary
	public DataSource dataSource() {
	    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//	    dataSourceBuilder.url("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12219307");
	    dataSourceBuilder.url(url);
	    dataSourceBuilder.username(username);
	    dataSourceBuilder.password(password);
	    dataSourceBuilder.driverClassName(driverClassName);
	    return dataSourceBuilder.build();   
	}
	
}