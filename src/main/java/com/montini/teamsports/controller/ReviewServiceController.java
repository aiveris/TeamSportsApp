package com.montini.teamsports.controller;

import com.montini.teamsports.model.Review;
import com.montini.teamsports.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ReviewServiceController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewServiceController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "reviews", method = RequestMethod.GET)
    public List<Review> findAll() {
        return reviewService.getAll();
    }

    @RequestMapping(value = "reviews", method = RequestMethod.POST)
    public Review create(@RequestBody Review review) {

        review.setId(0);
        reviewService.create(review);
        return review;
    }

    @RequestMapping(value = "reviews/{id}", method = RequestMethod.GET)
    public Review get(@PathVariable Integer id) {

        Review review = reviewService.getById(id);

        if (review == null) {
            throw new RuntimeException("Review id not found: " + id);
        }
        return review;
    }

    @RequestMapping(value = "reviews", method = RequestMethod.PUT)
    public Review update(@RequestBody Review review) {

        reviewService.update(review);

        return review;
    }

    @RequestMapping(value = "reviews/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {

        Review review = reviewService.getById(id);

        if (review == null) {
            throw new RuntimeException("Review id not found: " + id);
        }

        reviewService.delete(id);
        return "Deleted review id: " + id;
    }

}
