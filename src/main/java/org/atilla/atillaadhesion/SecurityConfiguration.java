package org.atilla.atillaadhesion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("admin").password("admin").roles("ADMIN"))
			.withUser(users.username("Jane").password("123").roles("TRESORIER"));
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/form").permitAll()
			.antMatchers("/tresorie/**").hasRole("TRESORIER")
			.antMatchers("/admin/**").hasAnyRole("ADMIN","TRESORIER")
			.and()
			.formLogin()
				.loginPage("/connexion")
				.loginProcessingUrl("/authentification")
				.defaultSuccessUrl("/",true)
				.permitAll()
			.and()
			.logout()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/erreur-501");
	}
	
	
	
}
