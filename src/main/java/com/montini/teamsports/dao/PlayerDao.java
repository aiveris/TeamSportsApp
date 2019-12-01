package com.montini.teamsports.dao;

import com.montini.teamsports.model.Player;

import java.util.List;

public interface PlayerDao {

    void save(Player player);
    void update(Player player);
    void delete(int id);
    Player get(int id);
    List<Player> getAll();

}
