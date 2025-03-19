package com.databaes.learnermanagementsystem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from frontend
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String response = userService.registerUser(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, String>> signIn(@RequestBody User user) {
        String response = userService.signInUser(user.getUsername(), user.getPassword());

        if (response.equals("User not found!") || response.equals("Incorrect password!")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", response));
        }

        return ResponseEntity.ok(Map.of("message", response, "token", "dummy-jwt-token"));
    }
}
