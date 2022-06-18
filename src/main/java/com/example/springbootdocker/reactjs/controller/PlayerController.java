package com.example.springbootdocker.reactjs.controller;

import com.example.springbootdocker.reactjs.dto.ResponseData;
import com.example.springbootdocker.reactjs.entity.Player;
import com.example.springbootdocker.reactjs.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("createPlayer")
    public ResponseData<Object> createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player);
        return new ResponseData<>().ok("wererwe", player);
    }
}
