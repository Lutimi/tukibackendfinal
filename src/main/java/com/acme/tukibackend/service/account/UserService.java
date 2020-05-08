package com.acme.tukibackend.service.account;

import com.acme.tukibackend.model.account.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User userDetails );
    }
