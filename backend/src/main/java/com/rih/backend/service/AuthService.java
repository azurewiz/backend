package com.rih.backend.service;

import com.rih.backend.model.User;
import com.rih.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(String email, String password) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Email already in use!");
        }

        String otp = emailService.generateOTP();
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        System.out.println("Encoded Password: " + passwordEncoder.encode(password));
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
}
