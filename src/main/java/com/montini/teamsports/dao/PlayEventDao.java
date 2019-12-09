package com.montini.teamsports.dao;

import com.montini.teamsports.model.PlayEvent;

import java.util.List;

public interface PlayEventDao {

    public PlayEvent getPlayEvent(Integer id);
    public List<PlayEvent> getAllPlayEvent();
    public void deletePlayEvent(PlayEvent id);
    public void updatePlayEvent(Integer playEvent);
    public PlayEvent savePlayEvent(PlayEvent playEvent);

}

