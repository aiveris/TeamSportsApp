package com.montini.teamsports.service;

import com.montini.teamsports.dao.PlayEventDao;
import com.montini.teamsports.model.PlayEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional
public class PlayEventServiceImpl implements PlayEventService {

    @Autowired
    private PlayEventDao playEventDao;

    @Override
    public PlayEvent getPlayEvent(Integer id) {
        return this.playEventDao.getPlayEvent(id);
    }

    @Override
    public List<PlayEvent> getAllPlayEvent() {
        return this.playEventDao.getAllPlayEvent();
    }

    @Override
    public void deletePlayEvent(Integer id) {
        this.playEventDao.deletePlayEvent(id);
    }

    @Override
    public void updatePlayEvent(PlayEvent playEvent) {
        this.playEventDao.updatePlayEvent(playEvent);
    }

    @Override
    public PlayEvent savePlayEvent(PlayEvent playEvent) {
        this.playEventDao.savePlayEvent(playEvent);
        return playEvent;
    }
}


