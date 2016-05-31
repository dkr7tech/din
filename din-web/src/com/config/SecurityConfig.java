package com.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.AuthenticationService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan({ "com.security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Autowired
	AuthenticationService authenticationService;
	
/*	@Override
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
	}*/
/*	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/din-web/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin();
		
	}
	*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests().antMatchers("/din-web/**")
		.access("hasRole('User Administrator')").and().formLogin()
		.loginPage("/logon.htm")
		.usernameParameter("login")
		.passwordParameter("password")
		//.and().logout().logoutSuccessUrl("/login?logout")
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/403");
	   System.out.println("configure"+authenticationService.loadUserByUsername("din"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {
	auth
	.userDetailsService(authenticationService);
	}
/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/din-web/**").access("hasRole('ROLE_ADMIN')").
		and().formLogin();
		System.out.println("configure");
	}*/
	   @Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	            
	            auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	            System.out.println("configureGlobal"+authenticationService);
		}
}