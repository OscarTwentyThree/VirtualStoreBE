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
import com.virtualstore.virtualstore.responses.GenericResponse;
import com.virtualstore.virtualstore.services.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
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

        try {
            User foundUser = UserService.getUser(id);
            return new ResponseEntity<>(userMapper.userToUserBasicInfo(foundUser), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createProduct(@RequestBody User user) {
        GenericResponse response;
        try {
            if (UserService.getUser(user.getId()) == null) {
                UserService.createUser(user);
                response = new GenericResponse().setMsg("Se ha registrado con exito!").setError(false).setData(userMapper.userToUserBasicInfo(user)).setToken(null).setExpiresIn(0);
                return ResponseEntity.ok(response);
            } else {
                throw new Exception("El usuario ya existe");
            }

        } catch (Exception e) {
            response = new GenericResponse().setMsg(e.getMessage()).setError(true).setData(null).setToken(null).setExpiresIn(0);
            return ResponseEntity.ok(response);
        }

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<GenericResponse> updateProduct(@PathVariable("id") Long id, @RequestBody User user) {

        GenericResponse response;
        User updated;

        try {
            UserService.updateUser(id, user);
            updated = UserService.getUser(id);
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(userMapper.userToUserBasicInfo(updated)).setMsg("Usuario actualizado");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } 
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try {
            if (UserService.getUser(id) == null) {
                throw new Exception("User not found");
            } else {
                UserService.deleteUser(id);
                return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "bills/{id}")
    public ResponseEntity<Object> getUserBillManagewment(@PathVariable("id") Long id) {

        try {
            User foundUser = UserService.getUser(id);
            return new ResponseEntity<>(userMapper.userToManagementUserBill(foundUser), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
