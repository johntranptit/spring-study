package com.example.springbootdocker.security.service;

import com.example.springbootdocker.security.domain.Role;
import com.example.springbootdocker.security.domain.UserPass;

import java.util.List;

public interface UserService {
    UserPass saveUser(UserPass user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    UserPass getUser(String username);

    List<UserPass> getUsers();
}
