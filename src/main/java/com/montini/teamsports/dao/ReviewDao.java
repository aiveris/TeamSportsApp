package com.montini.teamsports.dao;

import com.montini.teamsports.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewDao {
    public Review getReview(int id);
    public List<Review> getAllReviews();
    public void updateReview(Review review);
    public void saveReview(Review review);
    public void deleteReview(int id);
}
