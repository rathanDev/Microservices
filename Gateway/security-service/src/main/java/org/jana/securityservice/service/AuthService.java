package org.jana.securityservice.service;

import org.jana.securityservice.entity.AuthRequest;
import org.jana.securityservice.jpa.JpaUserCredential;
import org.jana.securityservice.repo.UserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    @Autowired
    private AuthenticationManager authenticationManager;

    public JpaUserCredential addUser(JpaUserCredential credential) {
        String encodedPassword = passwordEncoder.encode(credential.getPassword());
        credential.setPassword(encodedPassword);
        JpaUserCredential saved = repo.save(credential);
        return saved;
    }

    public String generateToken(AuthRequest req) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(req.getUsername());
        }
        throw new RuntimeException("User not valid");
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
