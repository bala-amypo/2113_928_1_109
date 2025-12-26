package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthController {

    private final UserProfileService userService;
    private final UserProfileRepository userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserProfileService userService,
                          UserProfileRepository userRepo,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    /* =========================
       REGISTER  (TEST 55)
       ========================= */
    public ResponseEntity<JwtResponse> register(RegisterRequest request) {

        // ✔ check email exists
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        UserProfile user = new UserProfile();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        // ✔ save user
        UserProfile saved = userService.createUser(user);

        // ✔ generate token
        String token = jwtUtil.generateToken(
                saved.getId(),
                saved.getEmail(),
                saved.getRole()
        );

        return ResponseEntity.ok(
                new JwtResponse(saved.getId(), saved.getEmail(), token)
        );
    }

    /* =========================
       LOGIN  (TEST 56)
       ========================= */
    public ResponseEntity<JwtResponse> login(LoginRequest request) {

        // ✔ authenticate via AuthenticationManager
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // ✔ load user by email
        UserProfile user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid login"));

        // ✔ generate token
        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(
                new JwtResponse(user.getId(), user.getEmail(), token)
        );
    }
}
