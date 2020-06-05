package com.i.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource loginDS;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(loginDS);
	/*	UserBuilder users=User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("iy").password("m").roles("ADMIN"))
		.withUser(users.username("a").password("b").roles("PERSONEL","HR"))
		.withUser(users.username("k").password("y").roles("PERSONEL"));
		// TODO Auto-generated method stub
		//super.configure(auth);*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//butun erisimlerde authentica oldugu surece her yere gidebilir anlaminda authorize etmek istedigim islerin tumunu
	//http.authorizeRequests().anyRequest().authenticated();
	
	http.authorizeRequests() 
	.antMatchers("/").authenticated()
	.antMatchers("/admin/**").hasRole("ADMIN") 
	.antMatchers("/personel/**").hasRole("PERSONEL");
	//.antMatchers("/personel/**").hasAnyRole("ADMIN","PERSONEL");
	
	
	
	http 
	.formLogin() 
	.loginPage("/loginForm") 
	.loginProcessingUrl("/authenticateTheUser") 
	.permitAll();
	
	http 
	.logout() 
	.permitAll();
	
	http.exceptionHandling().accessDeniedPage("/access-denied"); 

	}
}
