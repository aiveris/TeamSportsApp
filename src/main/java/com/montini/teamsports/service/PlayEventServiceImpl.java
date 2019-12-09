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
    public PlayEvent create(PlayEvent playEvent) {
        this.playEventDao.savePlayEvent(playEvent);
        return playEvent;
    }

    @Override
    public void update(PlayEvent playEvent) {
        this.playEventDao.updatePlayEvent(playEvent);
    }

    @Override
    public void delete(int id) {
        this.playEventDao.deletePlayEvent(playEventDao.getPlayEvent(id));
    }

    @Override
    public PlayEvent get(int id) {
        return this.playEventDao.getPlayEvent(id);
    }

    @Override
    public List<PlayEvent> getAll() {
        return this.playEventDao.getAllPlayEvent();
    }

}


