package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.PlayEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface PlayEventDao {

    public PlayEvent get(int id);

    @SuppressWarnings("unchecked")
    public List<PlayEvent> getAll();


}

