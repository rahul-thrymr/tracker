package com.handler.tracker.repo;

import com.handler.tracker.model.RegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationDetails, Long> {
  Optional<RegistrationDetails> findByEmail(String email);
}
