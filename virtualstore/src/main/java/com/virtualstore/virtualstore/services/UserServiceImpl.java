package com.virtualstore.virtualstore.services;

import java.util.Collection;
import com.virtualstore.virtualstore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtualstore.virtualstore.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
    
    @Override
    public void updateUser(Long id, User user) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(userToUpdate);
    }
    
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    @Override
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        if(userRepository.findById(id).get() == null){
            throw new RuntimeException("User not found");
        }else{
            return userRepository.findById(id).get();
        }
    }

    public User getUserByEmail(String email) {

        if(userRepository.findByEmail(email) == null){
            throw new RuntimeException("User not found");
        }else{
            return userRepository.findByEmail(email).get();
        }
    }
}
