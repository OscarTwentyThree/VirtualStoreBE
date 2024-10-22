package com.virtualstore.virtualstore.webServices;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.dtos.UserBasicInfo;
import com.virtualstore.virtualstore.entities.User;
import com.virtualstore.virtualstore.mappers.UserMapper;
import com.virtualstore.virtualstore.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("${url.user}")
public class UserServiceController {
    
    @Autowired
    private UserService UserService;

    @Autowired
    UserMapper userMapper;

    @GetMapping
    public ResponseEntity<Object> getUsers() {

    Collection<UserBasicInfo> users = userMapper.usersToUserBasicInfos(UserService.getUsers());
      return new ResponseEntity<>(users, HttpStatus.OK);
   }

   @GetMapping(value = "{id}")
   public ResponseEntity<Object> getUser(@PathVariable("id") Long id) {

    try{   
        User foundUser = UserService.getUser(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);

    }catch(Exception e){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
  }
   
   @PostMapping
   public ResponseEntity<Object> createProduct(@RequestBody User user) {
    UserService.createUser(user);
    try{
        if(UserService.getUser(user.getId()) == null){
        UserService.createUser(user);
        return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
        }else{
            throw new Exception("User already exists");
        }
        
    }catch(Exception e){
        return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
    }
      
   }

   @PutMapping(value = "{id}")
   public ResponseEntity<Object> 
      updateProduct(@PathVariable("id") Long id, @RequestBody User user) {
      
      UserService.updateUser(id, user);
      return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
   }

   @DeleteMapping(value = "{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
    try{
        if(UserService.getUser(id) == null){
            throw new Exception("User not found");
        }else{
            UserService.deleteUser(id);
            return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
        }
    }catch(Exception e){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
   } 
}
