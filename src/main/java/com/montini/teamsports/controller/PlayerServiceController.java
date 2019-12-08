package com.montini.teamsports.controller;

import com.montini.teamsports.model.Player;
import com.montini.teamsports.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/${application.api.vr}/")
public class PlayerServiceController {

    @Autowired
    PlayerService playerService;

    @GetMapping(value = "/players/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") int id) {
        return new ResponseEntity<>(playerService.get(id), HttpStatus.OK);
    }

    @GetMapping(value = "/players")
    public ResponseEntity<Object> getPlayers() {
        return new ResponseEntity<>(playerService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/players")
    public ResponseEntity<Object> createPlayer(@RequestBody Player player) {
        playerService.create(player);
        return new ResponseEntity<>("New player saved.", HttpStatus.OK);
    }
}
