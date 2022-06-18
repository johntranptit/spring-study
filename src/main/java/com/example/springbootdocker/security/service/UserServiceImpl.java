package com.example.springbootdocker.security.service;

import com.example.springbootdocker.security.domain.Role;
import com.example.springbootdocker.security.domain.UserPass;
import com.example.springbootdocker.security.repo.RoleRepo;
import com.example.springbootdocker.security.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserPass saveUser(UserPass user) {
        log.info(("Saving new user to the database"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info(("Saving new role to the database"));
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserPass user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
        userRepo.save(user);
        log.info(("add new role to the user"));
    }

    @Override
    public UserPass getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<UserPass> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPass userPass = userRepo.findByUsername(username);
        if (Objects.isNull(userPass)) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("USer found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userPass.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new User(userPass.getUsername(), userPass.getPassword(), authorities);
    }
}
