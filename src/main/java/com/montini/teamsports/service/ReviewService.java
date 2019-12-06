package com.montini.teamsports.service;

import com.montini.teamsports.model.Review;

import java.util.List;

public interface ReviewService {

    void create(Review review);

    Review getById(int id);

    List<Review> getAll();

    void update(Review review);

    void delete(int id);

}
