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

    public void getReviews() {
        List<Review> reviewList = reviewRepository.findAll();
        for (Review review : reviewList) {
            System.out.println(review.getComment());
        }
    }

    public void getReviewById(Long id) {
        Review review = reviewRepository.findById(id);
        System.out.println(review.getComment());
    }

    public void createReview(Review review) {
        reviewRepository.create(review);
        getReviews();
    }

    public void updateReview(Review existingReview) {
        reviewRepository.update(existingReview);
        getReviews();
    }

    public void deleteReview(Long id) {
        reviewRepository.delete(id);
        getReviews();
    }
}