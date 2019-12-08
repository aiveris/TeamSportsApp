package com.montini.teamsports.controller;
import com.montini.teamsports.dao.PlayEventDao;
import com.montini.teamsports.model.PlayEvent;
import com.montini.teamsports.model.PlayEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class PlayEventController {

    @Autowired
    private PlayEventDao playEventDao;

    @RequestMapping(value = "playEvents", method = RequestMethod.GET)
    public List<PlayEvent> list() {
        return playEventDao.getAllPlayEvent();
    }

    @RequestMapping(value = "playEvents", method = RequestMethod.POST)
    public PlayEvent create(@RequestBody PlayEvent playEvent) {
        return playEventDao.savePlayEvent(playEvent);
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.GET)
    public PlayEvent get(@PathVariable Integer id) {
        Optional<PlayEvent> playEventOptional = Optional.ofNullable(playEventDao.getPlayEvent(id));
        return playEventOptional.orElse(null);
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.PUT)
    public PlayEvent update(@PathVariable int id, @RequestBody PlayEvent playEvent) {
        Optional<PlayEvent> playEventOptional = Optional.ofNullable(playEventDao.getPlayEvent(id));
        PlayEvent existPlayEvent = playEventOptional.orElse(null);
        if (existPlayEvent != null) {
            BeanUtils.copyProperties(playEvent, existPlayEvent);
            return playEventDao.savePlayEvent(existPlayEvent);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "playEvents/{id}", method = RequestMethod.DELETE)
    public PlayEvent delete(@PathVariable int id) {
        Optional<PlayEvent> playEventOptional = Optional.ofNullable(playEventDao.getPlayEvent(id));
        PlayEvent existPlayEvent = playEventOptional.orElse(null);
        if (existPlayEvent != null) {
            playEventDao.deletePlayEvent(existPlayEvent);
        }
        return existPlayEvent;
    }
}
