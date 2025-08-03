package com.samarth_dev.service.impl;

import com.samarth_dev.domain.USER_ROLE;
import com.samarth_dev.modal.User;
import com.samarth_dev.repository.UserRepository;
import com.samarth_dev.response.SignupRequest;
import com.samarth_dev.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String createUser(SignupRequest req){

        User user = userRepository.findByEmail(req.getEmail());

        if(user==null){
            User createdUser = new User();
            createdUser.setEmail(req.getEmail());
            createdUser.setFullName(req.getFullName());
            createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
            createdUser.setMobile("1234567890");
            createdUser.setPassword(passwordEncoder.encode(req.getOtp()));

            user=userRepository.save(createdUser);
        }
        return "";
    }
}
