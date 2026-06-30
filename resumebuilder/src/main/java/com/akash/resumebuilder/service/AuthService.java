package com.akash.resumebuilder.service;

import com.akash.resumebuilder.document.User;
import com.akash.resumebuilder.dtos.AuthResponse;
import com.akash.resumebuilder.dtos.RegisterRequest;
import com.akash.resumebuilder.exception.ResourceExistsException;
import com.akash.resumebuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private  final UserRepository userRepository;

    public AuthResponse register(RegisterRequest request){
       log.info("inside AuthService : register() {}",request);
       if(userRepository.existsByEmail(request.getEmail())){
           throw new ResourceExistsException("User already exist with this email");
       }
        User newUser = toUser(request);
        userRepository.save(newUser);
       //TODO: send verification email later

     return toResponse(newUser);


    }
    private AuthResponse toResponse(User newUser){
        return   AuthResponse.builder()
                .id(newUser.getId())
                .name(newUser.getName())
                .email(newUser.getEmail())
                .profileImageUrl(newUser.getProfileImageUrl())
                .emailVerified(newUser.isEmailVerified())
                .subscriptionPlan(newUser.getSubscriptionPlan())
                .build();
    }
    private User toUser(RegisterRequest request){
       return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .profileImageUrl(request.getProfileImageUrl())
                .subscriptionPlan("Basic")
                .emailVerified(false)
                .verificationToken(UUID.randomUUID().toString())
                .verificationExpires(LocalDateTime.now().plusHours(24))
                .build();

    }

}
