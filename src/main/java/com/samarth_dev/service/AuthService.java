package com.samarth_dev.service;

import com.samarth_dev.response.SignupRequest;

public interface AuthService {

    void sentLoginOtp(String email) throws Exception;

    String createUser(SignupRequest req) throws Exception;
}
