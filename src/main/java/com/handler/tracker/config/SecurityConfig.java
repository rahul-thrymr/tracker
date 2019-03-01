package com.handler.tracker.config;

import com.handler.tracker.securityHandler.AuthenticationEntryPointException;
import com.handler.tracker.securityHandler.AuthenticationFilter;
import com.handler.tracker.securityHandler.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(1)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationEntryPointException authenticationEntryPointException;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Bean
  public AuthenticationFilter authenticationFilter() {
    return new AuthenticationFilter();
  }

  private String permit[] = {"/"};

  private String ignoreUrls[] = {"/login","/save"};

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
        .and().csrf().disable().exceptionHandling().authenticationEntryPoint(authenticationEntryPointException)
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeRequests().antMatchers(permit).permitAll().anyRequest().authenticated();
    http.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(ignoreUrls);
  }

/*
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
  }
*/

  @Bean(BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
