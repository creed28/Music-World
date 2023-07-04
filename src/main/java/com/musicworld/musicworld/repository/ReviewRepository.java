package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.Review;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository extends ParentRepository<Review> {

    @Override
    public Class<Review> getEntityClass() {
        return Review.class;
    }
}