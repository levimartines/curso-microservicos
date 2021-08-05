package com.levimartines.hrgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class ResourceServerConfig {

/*	@Autowired
	private JwtTokenStore tokenStore;

	private static final String[] PUBLIC = {
			"/hr-auth/oauth/token",
	};
	private static final String[] OPERATOR = {
			"/hr-worker/**",
	};
	private static final String[] ADMIN = {
			"/hr-payroll/**",
			"/hr-user/**"
	};*/

	@Bean
	public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
		return http
				.csrf().disable()
				.authorizeExchange()
/*				.pathMatchers(PUBLIC).permitAll()
				.pathMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("ROLE_OPERATOR", "ROLE_ADMIN")
				.pathMatchers(ADMIN).hasRole("ROLE_ADMIN")
				.anyExchange().authenticated()*/
				.anyExchange().permitAll()
				.and().build();
	}

/*	@Bean
	public DefaultTokenServices tokenServices(){
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(tokenStore);
		return tokenServices;
	}*/
}
