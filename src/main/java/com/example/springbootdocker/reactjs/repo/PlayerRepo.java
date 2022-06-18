package com.example.springbootdocker.reactjs.repo;

import com.example.springbootdocker.reactjs.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
}
