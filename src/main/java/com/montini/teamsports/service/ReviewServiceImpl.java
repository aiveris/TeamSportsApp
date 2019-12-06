package com.montini.teamsports.service;

import com.montini.teamsports.dao.ReviewDao;
import com.montini.teamsports.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewDao reviewDao;

    @Autowired
    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public void create(Review review) {
        reviewDao.saveReview(review);
    }

    @Override
    public Review getById(int id) {
        return reviewDao.getReview(id);
    }

    @Override
    public List<Review> getAll() {
        return reviewDao.getAllReviews();
    }

    @Override
    public void update(Review review) {
        reviewDao.updateReview(review);
    }

    @Override
    public void delete(int id) {
        reviewDao.deleteReview(id);
    }
}
