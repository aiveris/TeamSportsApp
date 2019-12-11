package com.montini.teamsports.controller;

import com.montini.teamsports.model.PlayEvent;
import com.montini.teamsports.service.PlayEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class PlayEventController {

    @Autowired
    private PlayEventService playEventService;

    @RequestMapping(value = "playEvents", method = RequestMethod.GET)
    public List<PlayEvent> list() {
        return playEventService.getAllPlayEvent();
    }

    @RequestMapping(value = "playEvents", method = RequestMethod.POST)
    public PlayEvent create(@RequestBody PlayEvent playEvent) {
        return playEventService.savePlayEvent(playEvent);
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.GET)
    public PlayEvent get(@PathVariable Integer id) {

        PlayEvent playEventOptional = playEventService.getPlayEvent(id);
        return playEventOptional;
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.PUT)
    public PlayEvent update(@PathVariable int id, @RequestBody PlayEvent playEvent) {
        Optional<PlayEvent> playEventOptional = Optional.ofNullable(playEventService.getPlayEvent(id));
        PlayEvent existPlayEvent = playEventOptional.orElse(null);
        if (existPlayEvent != null) {
            BeanUtils.copyProperties(playEvent, existPlayEvent);
            return playEventService.savePlayEvent(existPlayEvent);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.DELETE)
    public PlayEvent delete(@PathVariable Integer id) {
        Optional<PlayEvent> playEventOptional = Optional.ofNullable(playEventService.getPlayEvent(id));
        PlayEvent existPlayEvent = playEventOptional.orElse(null);
        if (existPlayEvent != null) {
            playEventService.deletePlayEvent(id);
        }
        return existPlayEvent;
    }
}
