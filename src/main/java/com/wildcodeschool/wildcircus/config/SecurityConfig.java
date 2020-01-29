package com.wildcodeschool.wildcircus.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception  {
		
		auth.jdbcAuthentication()
		   .dataSource(dataSource)
		   .usersByUsernameQuery("select username as principal, password as credentials, true from user where username = ?")
		   .authoritiesByUsernameQuery("select username as principal, role as role from user where username = ?")
		   .rolePrefix("ROLE_")
		   .passwordEncoder(new BCryptPasswordEncoder());
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	http
		  .authorizeRequests()
		  	.antMatchers("/css/**","/js/**","/img/**")
		  		.permitAll()
	   		.antMatchers("/admin/**")
	   			.hasAnyRole("ADMIN")
	   		.and()
	   			.formLogin()
	   			.loginPage("/login")
	   			.defaultSuccessUrl("/")
	   			.failureUrl("/login?error=true")
	   			.permitAll()
	   		.and()
	   			.exceptionHandling()
	   			.accessDeniedPage("/error.html")
	   		.and()
	   			.logout()
	   			.logoutSuccessUrl("/?logout=true")
	   			.invalidateHttpSession(true)
	   			.permitAll()
	   		.and()
	   			.sessionManagement().maximumSessions(1)
	   			.expiredUrl("/login");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}

