package org.jana.securityservice.repo;

import org.jana.securityservice.jpa.JpaUserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepo extends JpaRepository<JpaUserCredential, Integer> {
}
