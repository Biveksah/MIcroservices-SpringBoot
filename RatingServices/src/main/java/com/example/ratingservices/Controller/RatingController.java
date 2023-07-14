package com.example.ratingservices.Controller;

import com.example.ratingservices.Entities.Rating;
import com.example.ratingservices.Services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;

    // Create Rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating createRating = ratingServices.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
    }

    // Get AllRatings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        //  return ResponseEntity.status(HttpStatus.OK).body(ratingServices.getAllRating());
        return ResponseEntity.ok(ratingServices.getAllRating());
    }

    // Get AllRatings ByUserId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingServices.getRatingByUserId(userId));
    }

    // Get AllRatings ByHotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingServices.getRatingByHotelId(hotelId));
    }
}
