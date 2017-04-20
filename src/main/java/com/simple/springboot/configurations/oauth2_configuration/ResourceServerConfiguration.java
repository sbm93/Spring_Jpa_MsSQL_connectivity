package com.simple.springboot.configurations.oauth2_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	private static final String RESOURCE_ID = "my_services";
	
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resource) {
		resource.resourceId(RESOURCE_ID).tokenStore(tokenStore);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/api/**").authenticated();	
	}
}
