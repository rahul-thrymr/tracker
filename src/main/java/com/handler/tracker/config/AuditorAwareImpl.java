package com.handler.tracker.config;

import com.handler.tracker.model.RegistrationDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    try {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      RegistrationDetails registrationDetails = (RegistrationDetails) authentication.getPrincipal();
      return Optional.of(registrationDetails.getEmail());
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
