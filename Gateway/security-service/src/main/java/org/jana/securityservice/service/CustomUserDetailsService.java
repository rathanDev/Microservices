package org.jana.securityservice.service;

import org.jana.securityservice.entity.CustomUserDetails;
import org.jana.securityservice.jpa.JpaUserCredential;
import org.jana.securityservice.repo.UserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<JpaUserCredential> userOpt = repo.findByName(username);
        return userOpt.map(CustomUserDetails::new).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
