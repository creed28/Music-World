package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.model.Review;
import com.musicworld.musicworld.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public List<Review> getAllReviews(){
        return reviewService.getReviews();
    }

    @GetMapping("/review/{id}")
    public Review getReview(@PathVariable Long id){
        return reviewService.getReviewById(id);
    }

    @PostMapping("/add")
    public Review addReview(@RequestBody Review review){
        return reviewService.createReview(review);
    }

    @PutMapping("/update")
    public Review updateReview(@RequestBody Review existingReview){
        return reviewService.updateReview(existingReview);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
    }
}