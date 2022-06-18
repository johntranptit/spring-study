package com.example.springbootdocker.reactjs.service;

import com.example.springbootdocker.reactjs.entity.Player;
import com.example.springbootdocker.reactjs.repo.PlayerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepo playerRepo;

    public void createPlayer(Player player) {
        playerRepo.save(player);
    }
}
