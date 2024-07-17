package com.example.FileShare.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AppUserController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppUserDetails appUserDetailsService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(AppUser user) {
        AppUser existingUser = appUserService.findByUsername(user.getUserName());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        appUserService.registeruser(user);
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(AppUser user) {
        AppUser existingUser = appUserService.findByUsername(user.getUserName());
        if (existingUser == null) {
            return ResponseEntity.badRequest().body("User does not exist");
        }
        return ResponseEntity.ok("User logged in successfully");
    }
}
