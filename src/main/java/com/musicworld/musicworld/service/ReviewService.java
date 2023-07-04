package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.Review;
import com.musicworld.musicworld.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Review createReview(Review review) {
        return reviewRepository.create(review);
    }

    public Review updateReview(Review existingReview) {
        return reviewRepository.update(existingReview);
    }

    public void deleteReview(Long id) {
        reviewRepository.delete(id);
    }
}