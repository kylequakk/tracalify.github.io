package com.caltracker.controller;

import com.caltracker.model.User;
import com.caltracker.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            return "Email already exists";
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);

        return "Account created";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = userRepo.findByEmail(user.getEmail());

        if (dbUser == null) return "User not found";
        if (!encoder.matches(user.getPassword(), dbUser.getPassword())) return "Wrong password";

        return "Login successful";
    }
}
