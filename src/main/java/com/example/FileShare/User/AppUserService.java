package com.example.FileShare.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    private PasswordEncoder passwordEncoder;
    public AppUser registeruser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    public AppUser save(AppUser user) {
        return appUserRepository.save(user);
    }
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
