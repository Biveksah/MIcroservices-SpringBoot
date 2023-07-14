package com.example.ratingservices.Repository;

import com.example.ratingservices.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    //Customer Finder Method
    List<Rating> findByUserId(String userId);
    List<Rating>findByHotelId(String hotelId);
}
