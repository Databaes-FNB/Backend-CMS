package com.databaes.learnermanagementsystem; // Ensure this matches your package structure

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.databaes.learnermanagementsystem.User;

@Repository  // ✅ Mark as a repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
