package com.nawale.services;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Map<String, String>> registerUser(RegisterDTO registerDTO) {

        Map<String, String> response = new HashMap<>();

        // Check if the email or mobile already exists
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            response.put("message", "Email already exists!");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        else if (userRepository.existsByMobile(registerDTO.getMobile())) {
            response.put("message", "Mobile number already registered!");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
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


        response.put("message", "Registration successful!");
        
        return ResponseEntity.ok(response);
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
