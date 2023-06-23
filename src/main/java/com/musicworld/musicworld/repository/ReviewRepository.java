package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.Review;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository extends ParentRepository<Review> {
    @Override
    public String getEntityName() {
        return Review.class.getSimpleName();
    }
}