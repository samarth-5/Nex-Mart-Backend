package com.samarth_dev.service.impl;

import com.samarth_dev.config.JwtProvider;
import com.samarth_dev.domain.USER_ROLE;
import com.samarth_dev.modal.Cart;
import com.samarth_dev.modal.User;
import com.samarth_dev.modal.VerificationCode;
import com.samarth_dev.repository.CartRepository;
import com.samarth_dev.repository.UserRepository;
import com.samarth_dev.repository.VerificationCodeRepository;
import com.samarth_dev.response.SignupRequest;
import com.samarth_dev.service.AuthService;
import com.samarth_dev.service.EmailService;
import com.samarth_dev.utils.OtpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;
    private final JwtProvider jwtProvider;
    private final VerificationCodeRepository verificationCodeRepository;
    private final EmailService emailService;

    @Override
    public void sentLoginOtp(String email) throws Exception {
        String SIGNING_PREFIX = "signin_";

        if (email.startsWith(SIGNING_PREFIX)) {
            email = email.substring(SIGNING_PREFIX.length());

            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new Exception("user not exist with provided email");
            }
        }

        VerificationCode isExist = verificationCodeRepository.findByEmail(email);

        if(isExist!=null){
            verificationCodeRepository.delete(isExist);
        }

        String otp = OtpUtil.generateOtp();

        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setOtp(otp);
        verificationCode.setEmail(email);
        verificationCodeRepository.save(verificationCode);

        String subject = "Nex-Mart Login / Signup OTP";
        String text = "Your OTP is : "+otp;

        emailService.sendVerificationOtpEmail(email,subject,otp,text);
    }


    @Override
    public String createUser(SignupRequest req) throws Exception {

        VerificationCode verificationCode = verificationCodeRepository.findByEmail(req.getEmail());

        if(verificationCode == null || !verificationCode.getOtp().equals(req.getOtp())){
            throw new Exception("Wrong otp!!");
        }

        User user = userRepository.findByEmail(req.getEmail());

        if(user==null){
            User createdUser = new User();
            createdUser.setEmail(req.getEmail());
            createdUser.setFullName(req.getFullName());
            createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
            createdUser.setMobile("1234567890");
            createdUser.setPassword(passwordEncoder.encode(req.getOtp()));

            user=userRepository.save(createdUser);

            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(req.getEmail(),null,authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);
    }
}
