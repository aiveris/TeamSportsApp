package com.montini.teamsports.service;

import com.montini.teamsports.model.Player;

import java.util.Collection;
import java.util.List;

public interface PlayerService {

    Player create(Player player);
    void update(Player player);
    void delete(Integer id);
    Player get(Integer id);
    List<Player> getAll();

}
