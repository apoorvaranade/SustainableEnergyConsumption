package com.me.sustainable.living.main;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages={"com.me"})
@RestController
@EnableAutoConfiguration(exclude={ DataSourceAutoConfiguration.class})
public class Application {

	@RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String home() {
		return "Nothing here. Go to <a href='/test'>/test</a>";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Bean(name = "dataSource")
	@Primary
	public DataSource dataSource() {
	    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	    dataSourceBuilder.url("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12219307");
	    dataSourceBuilder.username("sql12219307");
	    dataSourceBuilder.password("wQmjPxrJR9");
	    dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
	    return dataSourceBuilder.build();   
	}
	
}