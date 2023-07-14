package com.example.hotelservices.Services;

import com.example.hotelservices.Entities.Hotel;

import java.util.List;

public interface HotelServices {
    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel getHotel(String id);
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(String id);
}
