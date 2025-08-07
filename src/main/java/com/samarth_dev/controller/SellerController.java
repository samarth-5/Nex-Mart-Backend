package com.samarth_dev.controller;

import com.samarth_dev.modal.VerificationCode;
import com.samarth_dev.request.LoginRequest;
import com.samarth_dev.response.ApiResponse;
import com.samarth_dev.response.AuthResponse;
import com.samarth_dev.service.AuthService;
import com.samarth_dev.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers")
public class SellerController {
    private final SellerService sellerService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginSeller(@RequestBody LoginRequest req) throws Exception {

        String otp = req.getOtp();
        String email = req.getEmail();

        req.setEmail("seller_" + email);
        AuthResponse authResponse = authService.signin(req);

        return ResponseEntity.ok(authResponse);
    }

}
