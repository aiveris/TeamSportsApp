package com.montini.teamsports.service;

import com.montini.teamsports.model.PlayEvent;

import java.util.Collection;

public interface PlayEventService {

    PlayEvent create(PlayEvent playEvent);
    void update(PlayEvent playEvent);
    void delete(int id);
    PlayEvent get(int id);
    Collection<PlayEvent> getAll();

}
