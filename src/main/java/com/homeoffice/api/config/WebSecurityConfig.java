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

//import com.homeofficeapi.config.security.AuthenticationByTokenFilter;
import com.homeoffice.api.config.security.AuthenticationService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
//	Configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	}

	//	Configurações de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/user/**").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/activity").permitAll()
			.antMatchers(HttpMethod.GET,"/activity").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/activity/save").permitAll()
			.antMatchers(HttpMethod.POST,"/activity/save").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/activity/update").permitAll()
			.antMatchers(HttpMethod.PUT,"/activity/update").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/activity/*").permitAll()
			.antMatchers(HttpMethod.DELETE,"/activity/*").permitAll()
			.antMatchers(HttpMethod.GET,"/activity/*").permitAll()
			.antMatchers(HttpMethod.POST,"/activity/auth").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable().cors().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//			.and().addFilterBefore(new AuthenticationByTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
