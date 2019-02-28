package com.handler.tracker.config;

import com.handler.tracker.securityHandler.AuthenticationEntryPointException;
import com.handler.tracker.securityHandler.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@Order(1)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationEntryPointException authenticationEntryPointException;

  @Bean
  public AuthenticationFilter authenticationFilter() {
    return new AuthenticationFilter();
  }

  private String permit[] = {"/"};

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
        .and().csrf().disable().exceptionHandling().authenticationEntryPoint(authenticationEntryPointException)
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeRequests().antMatchers(permit).permitAll().anyRequest().authenticated();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    super.configure(auth);
  }

}
