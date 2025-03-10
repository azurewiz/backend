package com.rih.backend.service;

import com.rih.backend.dto.JwtResponse;
import com.rih.backend.dto.LoginRequest;
import com.rih.backend.model.User;
import com.rih.backend.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String registerUser(String email, String password) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Email already in use!");
        }

        String otp = emailService.generateOTP();
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setOtp(otp);
        user.setVerified(false);
        userRepository.save(user);

        emailService.sendEmail(email, otp);
        return "OTP sent to email!";
    }

    public String verifyOTP(String email, String otp) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found!"));

        if (user.getOtp().equals(otp)) {
            user.setVerified(true);
            user.setOtp(null);
            userRepository.save(user);
            return "User verified successfully!";
        } else {
            throw new IllegalStateException("Invalid OTP!");
        }
    }

    // JwtResponse authenticator
    public JwtResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalStateException("User not found!"));
        String token = jwtService.generateJwtToken(user);
        return new JwtResponse(token);
    }

}
