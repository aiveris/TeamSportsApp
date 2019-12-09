package com.montini.teamsports.dao;

import com.montini.teamsports.model.PlayEvent;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlayEventDao {

    PlayEvent getPlayEvent(Integer id);
    List<PlayEvent> getAllPlayEvent();
    void deletePlayEvent(PlayEvent playEvent);
    void updatePlayEvent(PlayEvent playEvent);
    PlayEvent savePlayEvent(PlayEvent playEvent);

}

