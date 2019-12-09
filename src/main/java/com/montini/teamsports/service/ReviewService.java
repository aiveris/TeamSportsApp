package com.montini.teamsports.service;

import com.montini.teamsports.model.Review;

import java.util.List;

public interface ReviewService {

    void create(Review review);
    void update(Review review);
    void delete(int id);
    Review getById(int id);
    List<Review> getAll();

}
