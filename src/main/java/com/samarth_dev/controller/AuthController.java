package com.samarth_dev.controller;

import com.samarth_dev.domain.USER_ROLE;
import com.samarth_dev.modal.User;
import com.samarth_dev.repository.UserRepository;
import com.samarth_dev.response.AuthResponse;
import com.samarth_dev.response.SignupRequest;
import com.samarth_dev.service.AuthService;
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
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignupRequest req){

        String jwt = authService.createUser(req);

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setMessage("Registration Success!!");
        res.setRole(USER_ROLE.ROLE_CUSTOMER);
        
        return ResponseEntity.ok(res);
    }
}
