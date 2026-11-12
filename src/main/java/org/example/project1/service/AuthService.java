package org.example.project1.service;

import org.example.project1.dto.AuthRequest;
import org.example.project1.model.User;
import org.example.project1.repository.UserRepository;
import org.example.project1.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String login(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Неверный логин или пароль"));

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername(), user.getRole());
        }
        throw new RuntimeException("Неверный логин или пароль");
    }
}