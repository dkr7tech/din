package com.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {
	auth
	.jdbcAuthentication()
	.dataSource(dataSource)
	.usersByUsernameQuery(
	"select login, password" +
	"from tt_user where login=?")
	.authoritiesByUsernameQuery(
	"select username, 'ROLE_USER' from Spitter where username=?")
	.passwordEncoder(new BCryptPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin();
		
	}
}