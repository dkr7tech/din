package com.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.security.AuthenticationService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@ComponentScan({ "com.security"})
public class SecurityConfig {
	@Autowired
	DataSource dataSource;
	@Autowired
	AuthenticationService authenticationService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 /*PathPatternRequestMatcher.Builder restMatcherBuilder = PathPatternRequestMatcher.withDefaults()
	                .servletPath("/spring/data/rest");*/
		
		 
		http
			.authorizeHttpRequests(authz -> authz
			//	.requestMatchers("/din-web/**").hasRole("User Administrator") // secure Spring MVC URLs
				//.requestMatchers("/aa.jsp").permitAll() // allow direct JSP access
				//	.requestMatchers(configServlet).permitAll() // allow direct JSP access
				.anyRequest().permitAll() // allow all other requests (including static resources)
			)
			.formLogin(form -> form
				.loginPage("/logon.htm")
				.usernameParameter("login")
				.passwordParameter("password")
				.permitAll()
			)
			.logout(logout -> logout.permitAll())
			.csrf();
		http.exceptionHandling(ex -> ex.accessDeniedPage("/403"));
		System.out.println("configure" + authenticationService.loadUserByUsername("din"));
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	        .userDetailsService(authenticationService)
	        .passwordEncoder(passwordEncoder())
	        .and()
	        .build();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}