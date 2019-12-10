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
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class PlayerServiceController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/players", method = RequestMethod.GET, produces = "application/json")
    public Collection<Player> list() { // also possible with "returns ResponseEntity<Object>"
        return playerService.getAll();
    }

    @RequestMapping(value = "/players", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> create(@RequestBody Player player) {
        playerService.create(player);
        return new ResponseEntity<>("Player " + player.getUsername() + " saved.", HttpStatus.OK);
    }

    @RequestMapping(value = "/players/{id}", method = RequestMethod.GET, produces = "application/json")
    public Serializable get(@PathVariable("id") int id) {
        return Optional.ofNullable(playerService.get(id)).orElse(null);
    }

    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Player player) {
        Optional<Player> playerOptional = Optional.ofNullable(playerService.get(id));
        Player existPlayer = playerOptional.orElse(null);
        if (existPlayer != null) {
            BeanUtils.copyProperties(player, existPlayer);
            playerService.create(existPlayer);
            return new ResponseEntity<>("Player " + existPlayer.getUsername() + " updated.", HttpStatus.OK);
        } else return new ResponseEntity<>("Invalid player object", HttpStatus.OK);
    }

    @RequestMapping(value = "players/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Optional<Player> playerOptional = Optional.ofNullable(playerService.get(id));
        Player existPlayer = playerOptional.orElse(null);
        if (existPlayer != null) {
            playerService.delete(existPlayer.getId());
            return new ResponseEntity<>("Player " + existPlayer.getUsername() + " was deleted.", HttpStatus.OK);
        } else return new ResponseEntity<>("Invalid player object", HttpStatus.OK);
    }

}