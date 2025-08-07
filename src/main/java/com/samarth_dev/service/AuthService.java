package com.samarth_dev.service;

import com.samarth_dev.domain.USER_ROLE;
import com.samarth_dev.request.LoginRequest;
import com.samarth_dev.response.AuthResponse;
import com.samarth_dev.request.SignupRequest;

public interface AuthService {

    void sentLoginOtp(String email, USER_ROLE role) throws Exception;

    String createUser(SignupRequest req) throws Exception;

    AuthResponse signin(LoginRequest req);
}
