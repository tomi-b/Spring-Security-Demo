 package ca.sheridancollege.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ca.sheridancollege.UserDetailedServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginAccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
				
				.antMatchers("/role/owner/**").hasRole("OWNER")
					.antMatchers("/", "user/owner/css/**", "user/owner/img/**", "users/owner/**")
					.permitAll()
					.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/role/employee/**").hasRole("EMPLOYEE")
					.antMatchers("/", "user/employee/css/**", "user/employee/img/**", "users/employee/**")
					.permitAll()
					.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/role/manager/**").hasRole("MANAGER")
					.antMatchers("/", "user/manager/css/**", "user/manager/img/**", "/users/manager/**")
					.permitAll()
					.antMatchers("/h2-console/**").permitAll()	
				.antMatchers("/role/**").hasRole("ADMIN")
					.antMatchers("/", "/**", "user/**", "users/**")
					.permitAll()
					.antMatchers("/h2-console/**").permitAll()
				.anyRequest().authenticated()
				.and()
					.formLogin().loginPage("/login").permitAll().and().logout().invalidateHttpSession(true)
					.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login?logout").permitAll()
					.and()               
					.exceptionHandling()            
					.accessDeniedHandler(accessDeniedHandler);
	}
	
	@Bean 
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	
	@Autowired
	UserDetailedServiceImpl userDetailsService;
	
	@Autowired 
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("owner")
				.password("password").roles("OWNER").and().withUser("manager").password("password").roles("MANAGER")
				.and().withUser("employee").password("password").roles("EMPLOYEE").and().withUser("admin")
				.password("password").roles("OWNER", "MANAGER", "EMPLOYEE");
	}
	

}
