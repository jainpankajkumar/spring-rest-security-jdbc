package com.learning.security.jdbc.datasource;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSource {

	@Autowired
	private Environment env;

	@Bean
	public OracleDataSource getDataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setDriverType(env.getProperty("oracle.driver"));
		dataSource.setURL(env.getProperty("oracle.jdbcUrl"));
		dataSource.setUser(env.getProperty("oracle.username"));
		dataSource.setPassword(env.getProperty("oracle.password"));
		return dataSource;
	}
}
