package com.samarth_dev.service;

import com.samarth_dev.response.SignupRequest;

public interface AuthService {

    String createUser(SignupRequest req);
}
