package com.montini.teamsports.controller;

import com.montini.teamsports.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerServiceController {

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/players")
    public ResponseEntity<Object> getPlayer() {
        return new ResponseEntity<>(playerService.getPlayers(), HttpStatus.OK);
    }

}
