package com.montini.teamsports.dao;

import com.montini.teamsports.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository {

    User getUserByUsername(String username);
    List<User> getAllAdmins();
}
