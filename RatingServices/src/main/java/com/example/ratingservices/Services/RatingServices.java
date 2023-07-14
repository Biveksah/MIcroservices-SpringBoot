package com.example.ratingservices.Services;

import com.example.ratingservices.Entities.Rating;

import java.util.List;

public interface RatingServices {
    Rating createRating(Rating rating);

    List<Rating> getAllRating();

    Rating getRating(String ratingId);

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

   // Rating updateRating(Rating rating);

}
