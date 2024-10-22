package com.virtualstore.virtualstore.webServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.dtos.LoginUserDto;
import com.virtualstore.virtualstore.dtos.RegisterUserDto;
import com.virtualstore.virtualstore.dtos.UserBasicInfo;
import com.virtualstore.virtualstore.entities.User;
import com.virtualstore.virtualstore.mappers.UserMapper;
import com.virtualstore.virtualstore.responses.LoginResponse;
import com.virtualstore.virtualstore.services.AuthenticationService;
import com.virtualstore.virtualstore.services.JwtService;

@RequestMapping("${url.auth}")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @Autowired
    UserMapper userMapper;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, UserMapper userMapper) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping("${url.auth.signup}")
    public ResponseEntity<UserBasicInfo> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        UserBasicInfo userBasicInfo = userMapper.userToUserBasicInfo(registeredUser);
        return ResponseEntity.ok(userBasicInfo);
    }

    @PostMapping("${url.auth.login}")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }


    
}
