package recipes.security.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import recipes.user.details.role.UserRole;
import recipes.user.details.service.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/admin/**")
		    .hasRole(UserRole.ADMIN.name())
		    .antMatchers("/api/recipe/**")
		    .hasAnyRole(UserRole.ADMIN.name(), UserRole.USER.name())
		    .antMatchers("/actuator/shutdown**", "/api/register")
		    .permitAll()
		    .antMatchers("/spring-security-rest/api/v2/**")
		    .permitAll()
		    .and()
		    .formLogin()
		    .and()
		    .csrf()
		    .disable()
		    .headers()
		    .frameOptions()
		    .disable()
		    .and()
		    .httpBasic();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(4);
	}
}
