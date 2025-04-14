package com.nawale.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nawale.dto.RegisterDTO;
import com.nawale.models.User;
import com.nawale.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerUser(RegisterDTO registerDTO) {

        // Check if the email or mobile already exists
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            return "Email already exists!";
        }

        if (userRepository.existsByMobile(registerDTO.getMobile())) {
            return "Mobile number already registered!";
        }

        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(registerDTO.getPassword());

        // Create and save the user
        User user = new User();
        user.setFullName(registerDTO.getFullName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(encryptedPassword);
        user.setMobile(registerDTO.getMobile());

        userRepository.save(user);

        return "Registration successful!";
    }
    
    public boolean authenticateUser(String email, String rawPassword) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            String storedHashedPassword = userOpt.get().getPassword();
            return new BCryptPasswordEncoder().matches(rawPassword, storedHashedPassword);
        }
        return false;
    }
}
