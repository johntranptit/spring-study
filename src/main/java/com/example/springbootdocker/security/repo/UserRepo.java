package com.example.springbootdocker.security.repo;

import com.example.springbootdocker.security.domain.UserPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserPass, Long> {
    UserPass findByUsername(String username);
}
