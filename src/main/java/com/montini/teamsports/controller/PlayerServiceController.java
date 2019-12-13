package com.montini.teamsports.controller;


import com.montini.teamsports.model.PlayEvent;
import com.montini.teamsports.model.Player;
import com.montini.teamsports.service.PlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class PlayerServiceController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<Player> list() { // also possible with "returns ResponseEntity<Object>"
        return playerService.getAll();
    }

    @RequestMapping(value = "/players", method = RequestMethod.POST)
    public Player create(@RequestBody Player player) { return playerService.create(player); }

    @RequestMapping(value = "/players/{id}", method = RequestMethod.GET)
    public Serializable get(@PathVariable("id") Integer id) {
        return playerService.get(id);
    }

    @RequestMapping(value = "/players/{id}", method = RequestMethod.PUT)
    public Player update(@PathVariable int id, @RequestBody Player player) {
        Optional<Player> playerOptional = Optional.ofNullable(playerService.get(id));
        Player existPlayer = playerOptional.orElse(null);
        if (existPlayer != null) {
            BeanUtils.copyProperties(player, existPlayer);
            // playerService.create(existPlayer);
            return playerService.create(existPlayer);
        } else return null;
    }

    @RequestMapping(value = "players/{id}", method = RequestMethod.DELETE)
    public Player delete(@PathVariable int id) {
        Optional<Player> playerOptional = Optional.ofNullable(playerService.get(id));
        Player existPlayer = playerOptional.orElse(null);
        if (existPlayer != null) {
            playerService.delete(id);
        }
        return existPlayer;
    }

}