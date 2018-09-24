package com.avi.auth;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class AppSecurityConfig  extends WebSecurityConfigurerAdapter{
	
 static	Logger logger =LoggerFactory.getLogger(AppSecurityConfig.class);
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("avinash").password("secret").roles("USER");
		
	}
	
	
	public void configure(HttpSecurity http) throws Exception {
		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

		http.csrf().disable().formLogin().and().logout().and().authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("/student").hasAuthority("USER").anyRequest().authenticated();

			
	}

}
