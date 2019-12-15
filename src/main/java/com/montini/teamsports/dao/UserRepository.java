package com.montini.teamsports.dao;

import com.montini.teamsports.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserByUsername(String username);
    List<User> getAllAdmins();

    public Integer add(User user);
    public void delete(User o);
    public User update(User o);

}
