package com.homeoffice.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.homeoffice.api.config.security.AuthenticationByTokenFilter;
//import com.homeofficeapi.config.security.AuthenticationByTokenFilter;
import com.homeoffice.api.config.security.AuthenticationService;
import com.homeoffice.api.config.security.TokenService;
import com.homeoffice.api.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/user/save").permitAll()
			.antMatchers(HttpMethod.POST,"/user/save").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/company/save").permitAll()
			.antMatchers(HttpMethod.POST,"/company/save").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/company/associate").permitAll()
			.antMatchers(HttpMethod.POST,"/company/associate").permitAll()
			.antMatchers(HttpMethod.GET,"/sector/*").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/sector").permitAll()
			.antMatchers(HttpMethod.GET,"/sector").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/sector/save").permitAll()
			.antMatchers(HttpMethod.POST,"/sector/save").permitAll()			
			.antMatchers(HttpMethod.OPTIONS,"/auth").permitAll()
			.antMatchers(HttpMethod.POST,"/auth").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/activity").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/activity/save").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/activity/*").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/activity/update").permitAll()
//			.antMatchers(HttpMethod.GET,"/activity").permitAll()
//			.antMatchers(HttpMethod.POST,"/activity/save").permitAll()
//			.antMatchers(HttpMethod.PUT,"/activity/update").permitAll()
//			.antMatchers(HttpMethod.DELETE,"/activity/*").permitAll()
//			.antMatchers(HttpMethod.GET,"/activity/*").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(new AuthenticationByTokenFilter(tokenService,userRepository), UsernamePasswordAuthenticationFilter.class);
	}
}
