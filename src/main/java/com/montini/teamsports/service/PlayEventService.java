package com.montini.teamsports.service;

import com.montini.teamsports.model.PlayEvent;

import java.util.Collection;

public interface PlayEventService {

    PlayEvent create(PlayEvent id);
    void update(Integer playEvent);
    void delete(Integer id);
    PlayEvent get(Integer id);
    Collection<PlayEvent> getAll();

}
