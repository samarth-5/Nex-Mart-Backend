package com.samarth_dev.controller;

import com.samarth_dev.modal.User;
import com.samarth_dev.repository.UserRepository;
import com.samarth_dev.response.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody SignupRequest req){

        User user = new User();
        user.setEmail(req.getEmail());
        user.setFullName(req.getFullName());

        User saveduser = userRepository.save(user);
        
        return ResponseEntity.ok(saveduser);
    }
}
