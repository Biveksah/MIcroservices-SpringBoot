package com.example.userservices.Services.ServisesImpl;

import com.example.userservices.Entities.Hotel;
import com.example.userservices.Entities.Rating;
import com.example.userservices.Entities.User;
import com.example.userservices.Exception.ResourceNotFoundException;
import com.example.userservices.External.Services.HotelServices;
import com.example.userservices.Repository.UserRepository;
import com.example.userservices.Services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelServices hotelServices;
    private final Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        // fetching the user from the User database
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on Server with this id"));
        // fetching ratings from Rating Service
        //http://localhost:8083/ratings/users/55d2a5a7-4e82-4c81-b58b-b2e78f4e50bf

        // set user ratings form Rating Service
        Rating[] ratingsOfUsers = restTemplate.getForObject("http://RATING-SERVICES/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}", ratingsOfUsers);
        List<Rating> ratings = Arrays.stream(ratingsOfUsers).toList();


        List<Rating> ratingList=ratings.stream().map(rating -> {
            // Api call to Hotel Services to get Hotel details
            //http://localhost:8082/hotels/568f0a5e-33f2-4c83-ac49-cb7b3b94a528
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICES/hotels/" + rating.getHotelId(), Hotel.class);
           // Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelServices.getHotel(rating.getHotelId());
           // logger.info("response status code:{}", forEntity.getStatusCode());
            //set hotel to rating
            rating.setHotel(hotel);
            //return rating
            return rating;

        }).collect(Collectors.toList());


        user.setRatings((ArrayList<Rating>) ratingList);

        return user;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }


}
