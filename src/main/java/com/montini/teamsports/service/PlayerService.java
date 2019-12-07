package com.montini.teamsports.service;

import com.montini.teamsports.model.Player;

import java.util.Collection;

public interface PlayerService {

    void create(Player player);

    Player get(int id);

    void update(int id, Player player);

    void delete(int id);

    Collection<Player> getAll();

}
