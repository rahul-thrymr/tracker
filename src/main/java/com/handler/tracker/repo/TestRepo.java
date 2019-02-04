package com.handler.tracker.repo;

import com.handler.tracker.model.RegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<RegistrationDetails, Long> {
}
