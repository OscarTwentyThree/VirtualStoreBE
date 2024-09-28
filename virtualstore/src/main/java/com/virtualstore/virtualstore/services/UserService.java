package com.virtualstore.virtualstore.services;
import java.util.Collection;
import com.virtualstore.virtualstore.entities.User;

public interface UserService {
    public abstract void createUser(User user);
    public abstract void updateUser(Long id, User user);
    public abstract void deleteUser(Long id);
    public abstract Collection<User> getUsers();
    public abstract User getUser(Long id);
 }

