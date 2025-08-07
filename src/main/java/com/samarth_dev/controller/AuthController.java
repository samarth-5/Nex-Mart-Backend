package com.samarth_dev.controller;

import com.samarth_dev.domain.USER_ROLE;
import com.samarth_dev.modal.VerificationCode;
import com.samarth_dev.repository.UserRepository;
import com.samarth_dev.request.LoginOtpRequest;
import com.samarth_dev.request.LoginRequest;
import com.samarth_dev.response.ApiResponse;
import com.samarth_dev.response.AuthResponse;
import com.samarth_dev.request.SignupRequest;
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

    @PostMapping("/sent/login-signup-otp")
    public ResponseEntity<ApiResponse> sentOtpHandler(@RequestBody LoginOtpRequest req)throws Exception{

        authService.sentLoginOtp(req.getEmail(),req.getRole());

        ApiResponse res = new ApiResponse();
        res.setMessage("OTP sent successfully!!");

        return ResponseEntity.ok(res);
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignupRequest req)throws Exception{

        String jwt = authService.createUser(req);

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setMessage("Registration Success!!");
        res.setRole(USER_ROLE.ROLE_CUSTOMER);

        return ResponseEntity.ok(res);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginHandler(@RequestBody LoginRequest req)throws Exception{

        AuthResponse authResponse = authService.signin(req);
        return ResponseEntity.ok(authResponse);
    }
}
