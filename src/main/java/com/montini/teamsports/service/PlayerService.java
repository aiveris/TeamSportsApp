package com.montini.teamsports.service;

import com.montini.teamsports.model.Player;

import java.util.Collection;

public interface PlayerService {

    void create(Player player);
    void update(Player player);
    void delete(int id);
    Player get(int id);
    Collection<Player> getAll();

}
