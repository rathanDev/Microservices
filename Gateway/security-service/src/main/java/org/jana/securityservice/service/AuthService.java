package org.jana.securityservice.service;

import org.jana.securityservice.jpa.JpaUserCredential;
import org.jana.securityservice.repo.UserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public JpaUserCredential addUser(JpaUserCredential credential) {
        String encodedPassword = passwordEncoder.encode(credential.getPassword());
        credential.setPassword(encodedPassword);
        JpaUserCredential saved = repo.save(credential);
        return saved;
    }

    public String generateToken(String username) {
        String token = jwtService.generateToken(username);
        return token;
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
