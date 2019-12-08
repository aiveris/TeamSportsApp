package com.montini.teamsports.dao;

import com.montini.teamsports.model.PlayEvent;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlayEventDao {

    public PlayEvent getPlayEvent(Integer playEvent);
    public List<PlayEvent> getAllPlayEvent();
    public void deletePlayEvent(PlayEvent playEvent);
    public void updatePlayEvent(PlayEvent playEvent);
    public PlayEvent savePlayEvent(PlayEvent playEvent);

}

