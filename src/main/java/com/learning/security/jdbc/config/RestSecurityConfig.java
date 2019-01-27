package com.learning.security.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import oracle.jdbc.pool.OracleDataSource;

@EnableWebSecurity
@Configuration
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private OracleDataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled" + " from users where username=?")
				.authoritiesByUsernameQuery("select username, role " + "from user_roles where username=?")
				.passwordEncoder(new BCryptPasswordEncoder());;
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.authorizeRequests()
		.anyRequest()
		.fullyAuthenticated()
		.and()
		.httpBasic();
		httpSecurity.csrf().disable();
	}
	
	// TODO - override Role Voter if you have roles without prefix - ROLE_
	/*
	 * @Bean public RoleVoter roleVoter() { RoleVoter roleVoter = new RoleVoter();
	 * roleVoter.setRolePrefix(""); return roleVoter; }
	 */
}
