package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.PlayEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PlayEventDao {

    public PlayEvent getPlayEvent(int id);
    public List<PlayEvent> getAllPlayEvent();
    public void deletePlayEvent(int id);
    public void updatePlayEvent(PlayEvent playEvent);
    public void savePlayEvent(PlayEvent playEvent);

}

