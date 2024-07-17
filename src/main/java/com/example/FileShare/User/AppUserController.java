package com.example.FileShare.User;

import com.example.FileShare.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AppUserController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private UserDetailsService userDetailsService;
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

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
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(jwt);
    }
}