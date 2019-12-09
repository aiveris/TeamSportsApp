package com.montini.teamsports.controller;
import com.montini.teamsports.model.PlayEvent;
import com.montini.teamsports.service.PlayEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class PlayEventController {

    @Autowired
    private PlayEventService playEventService;

    @RequestMapping(value = "playEvents", method = RequestMethod.GET)
    public ResponseEntity<Object> list() {
        return new ResponseEntity<>(playEventService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "playEvents", method = RequestMethod.POST)
    public PlayEvent create(@RequestBody PlayEvent playEvent) {
        return playEventService.create(playEvent);
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.GET)
    public Serializable get(@PathVariable int id) {
        Optional<PlayEvent> playEventOptional = Optional.ofNullable(playEventService.get(id));
        return playEventOptional.orElse(null);
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.PUT)
    public PlayEvent update(@PathVariable Integer id, @RequestBody PlayEvent playEvent) {
        Optional<PlayEvent> playEventOptional = Optional.ofNullable(playEventService.get(id));
        PlayEvent existPlayEvent = playEventOptional.orElse(null);
        if (existPlayEvent != null) {
            BeanUtils.copyProperties(playEvent, existPlayEvent);
            return playEventService.create(existPlayEvent);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.DELETE)
    public PlayEvent delete(@PathVariable Integer id) {
        Optional<PlayEvent> playEventOptional = Optional.ofNullable(playEventService.get(id));
        PlayEvent existPlayEvent = playEventOptional.orElse(null);
        if (existPlayEvent != null) {
            playEventService.delete(existPlayEvent.getId());
        }
        return existPlayEvent;
    }
}
