package com.levimartines.hrgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

/*	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		// tokenConverter.setSigningKey("MY-SECRET-KEY");
		return new JwtAccessTokenConverter();
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}*/

}
