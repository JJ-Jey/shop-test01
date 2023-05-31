package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		 .csrf(csrf->csrf.disable())
		 .authorizeHttpRequests(requests -> requests
        		 .requestMatchers("/css/**","/js/**","/images/**").permitAll()
                 .requestMatchers("/", "/sign/*","/layout/*","/etc/*").permitAll()
                 .anyRequest().authenticated())
         .formLogin(login -> login
                 .loginPage("/signin")            
                 .usernameParameter("email")
                 .passwordParameter("pass")
                 .defaultSuccessUrl("/", true)
                 .permitAll())
         .logout(logout->logout
        		 .logoutUrl("/logout")
        		 .deleteCookies("JSESSIONID"))
         ;
		return http.build();
	}

}