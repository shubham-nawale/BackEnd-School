package com.nawale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nawale.dto.LoginRequest;
import com.nawale.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

 @Autowired
 private UserService userService;

 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
     boolean isValid = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

     if (isValid) {
         return ResponseEntity.ok("Login successful");
     } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
     }
 }
}
