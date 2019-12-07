package com.montini.teamsports.service;

import com.montini.teamsports.dao.PlayerDao;
import com.montini.teamsports.dao.PlayerDaoImpl;
import com.montini.teamsports.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerDao playerDao;

    public PlayerServiceImpl() {
    }

    // public PlayerServiceImpl() { this.playerDao = new PlayerDaoImpl(); }

    @Override
    public void create(Player player) {
        playerDao.save(player);
    }

    public Player get(int id) {
        System.out.println(playerDao.get(id));
        return playerDao.get(id);
    }

    @Override
    public void update(int id, Player player) {
        playerDao.delete(id);
        player.setId(id);
        playerDao.save(player);
    }

    @Override
    public void delete(int id) {
        playerDao.delete(id);
    }

    @Override
    public Collection<Player> getAll() {
        return playerDao.getAll();
    }
}
