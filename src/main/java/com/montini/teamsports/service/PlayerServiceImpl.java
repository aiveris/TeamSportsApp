package com.montini.teamsports.service;


import com.montini.teamsports.dao.PlayerDao;
import com.montini.teamsports.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Override
    public Player create(Player player) {
        this.playerDao.save(player);
        return player;
    }

    // for backup purpose (don't pay attention): //
    // playerDao.delete(id);
    // player.setId(id);
    // playerDao.save(player);
    @Override
    public void update(Player player) { playerDao.update(player); }

    @Override
    public void delete(Integer id) {
        playerDao.delete(id);
    }

    @Override
    public Player get(Integer id) { return playerDao.get(id); }

    @Override
    public List<Player> getAll() { return playerDao.getAll(); }
}