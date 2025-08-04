package com.samarth_dev.response;

import com.samarth_dev.domain.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;
    private String message;
    private USER_ROLE role;
}
