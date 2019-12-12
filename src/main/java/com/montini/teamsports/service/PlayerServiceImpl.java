package com.montini.teamsports.service;

import com.montini.teamsports.dao.PlayerDao;
import com.montini.teamsports.dao.PlayerDaoImpl;
import com.montini.teamsports.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    // public PlayerServiceImpl() { }

    @Override
    public void create(Player player) {
        playerDao.save(player);
    }

    // for backup purpose (don't pay attention): //
    // playerDao.delete(id);
    // player.setId(id);
    // playerDao.save(player);
    @Override
    public void update(Player player) { playerDao.update(player); }

    @Override
    public void delete(int id) {
        playerDao.delete(id);
    }

    @Override
    public Player get(int id) { return playerDao.get(id); }

    @Override
    public Collection<Player> getAll() { return playerDao.getAll(); }
}