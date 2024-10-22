package com.virtualstore.virtualstore.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.virtualstore.virtualstore.dtos.LoginUserDto;
import com.virtualstore.virtualstore.dtos.RegisterUserDto;
import com.virtualstore.virtualstore.entities.Role;
import com.virtualstore.virtualstore.entities.User;
import com.virtualstore.virtualstore.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        var user = new User();

        Role role = new Role();

        List<Role> roles = new ArrayList<Role>();

        role.setId(2L);
        role.setName("USER_ROLE");

        roles.add(role);

            user.setId(input.getId());
            user.setFirstName(input.getFirstName());
            user.setLastName(input.getLastName());
            user.setEmail(input.getEmail());
            user.setPassword(passwordEncoder.encode(input.getPassword()));
            user.setPhoneNumber(input.getPhoneNumber());
            user.setRoles(roles);
            user.setBills(null);


        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getEmail(),
                input.getPassword()
            )
        );

        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
