package com.databaes.learnermanagementsystem;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String signInUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return "User not found!";
        }

        System.out.println("User found: " + user.getUsername());  // Debugging

        if (!user.getPassword().equals(password)) {
            return "Incorrect password!";
        }

        return "Login successful!";
    }
}
