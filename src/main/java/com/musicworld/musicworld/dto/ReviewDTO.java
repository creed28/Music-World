package com.musicworld.musicworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long id;
    private Double rating;
    private String comment;
    private String createdAt;
    private AppUserDTO appUser;
}