package com.montini.teamsports.dao;

import com.montini.teamsports.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlayerDao {

    Player save(Player player);
    void update(Player player);
    void delete(Integer id);
    Player get(Integer id);
    List<Player> getAll();

}
