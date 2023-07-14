package com.example.hotelservices.Controller;

import com.example.hotelservices.Entities.Hotel;
import com.example.hotelservices.Services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelServices hotelServices;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel saveHotel = hotelServices.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveHotel);
    }
    @PreAuthorize("hasAuthority('SCOPE_internal')|| hasAnyAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotelList = hotelServices.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(hotelList);

    }
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        Hotel hotel = hotelServices.getHotel(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

}

