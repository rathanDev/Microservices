package org.jana.securityservice.controller;

import org.jana.securityservice.entity.AuthRequest;
import org.jana.securityservice.jpa.JpaUserCredential;
import org.jana.securityservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public JpaUserCredential registerUser(@RequestBody JpaUserCredential credential) {
        return authService.addUser(credential);
    }

    @PostMapping("/token")
    public String generateToken(@RequestBody AuthRequest req) {
        return authService.generateToken(req);
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "ok";
    }

}
