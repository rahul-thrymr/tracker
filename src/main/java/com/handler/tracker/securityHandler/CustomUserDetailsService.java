package com.handler.tracker.securityHandler;

import com.handler.tracker.model.RegistrationDetails;
import com.handler.tracker.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private RegistrationRepo registrationRepo;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    RegistrationDetails registrationDetails = registrationRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));
    return UserPrincipal.create(registrationDetails);
  }

  @Transactional
  public UserDetails loadUserById(Long id) {
    RegistrationDetails registrationDetails = registrationRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
    return UserPrincipal.create(registrationDetails);
  }

}
