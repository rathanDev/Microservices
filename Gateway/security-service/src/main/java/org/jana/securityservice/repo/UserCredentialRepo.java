package org.jana.securityservice.repo;

import org.jana.securityservice.jpa.JpaUserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepo extends JpaRepository<JpaUserCredential, Integer> {

    Optional<JpaUserCredential> findByName(String username);

}
