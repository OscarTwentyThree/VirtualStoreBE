package com.virtualstore.virtualstore.webServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.virtualstore.virtualstore.responses.SignUpResponse;
import com.virtualstore.virtualstore.services.AuthenticationService;
import com.virtualstore.virtualstore.services.JwtService;

@CrossOrigin(origins = "http://127.0.0.1:5173")
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
    public ResponseEntity<SignUpResponse> register(@RequestBody RegisterUserDto registerUserDto) {

        SignUpResponse signUpResponse;
        try{
        User registeredUser = authenticationService.signup(registerUserDto);
        UserBasicInfo userBasicInfo = userMapper.userToUserBasicInfo(registeredUser);

        signUpResponse = new SignUpResponse().setToken(null).setExpiresIn(0).setError(false).setData(userBasicInfo).setMsg("User registered");
        return ResponseEntity.ok(signUpResponse);

        } catch (Exception e) {
            signUpResponse = new SignUpResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(signUpResponse);
        }
    }

    @PostMapping("${url.auth.login}")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        
        LoginResponse loginResponse;
        try {
           
            User authenticatedUser = authenticationService.authenticate(loginUserDto);

            String jwtToken = jwtService.generateToken(authenticatedUser);

            UserBasicInfo SimplyUser = userMapper.userToUserBasicInfo(authenticatedUser);

            loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime()).setError(false).setData(SimplyUser).setMsg("User authenticated");

            return ResponseEntity.ok(loginResponse);
        } catch (Exception e) {
            loginResponse = new LoginResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg("Email or password incorrect");

            return ResponseEntity.badRequest().body(loginResponse);
        }
    }


    
}
