package com.handler.tracker.securityHandler;

import com.handler.tracker.model.RegistrationDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

  private Long id;

  private String userName;

  private String password;

  public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  private Collection<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public UserPrincipal() {
  }

  public UserPrincipal(Long id, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.authorities = authorities;
  }

  @Override
  public String getUsername() {
    return userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public static UserPrincipal create(RegistrationDetails registrationDetails) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(){{
      add(new SimpleGrantedAuthority(registrationDetails.getRole().name()));
    }};

    return new UserPrincipal(
        registrationDetails.getId(),
        registrationDetails.getEmail(),
        registrationDetails.getPassword(),
        authorities
    );
  }

  /**
   * User has multiple authorities
   */
  /*public static UserPrincipal create(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
        new SimpleGrantedAuthority(role.getName().name())
    ).collect(Collectors.toList());

    return new UserPrincipal(
        user.getId(),
        user.getName(),
        user.getUsername(),
        user.getEmail(),
        user.getPassword(),
        authorities
    );
  }*/

}
