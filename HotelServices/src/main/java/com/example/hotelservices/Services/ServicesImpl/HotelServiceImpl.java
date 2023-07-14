package com.example.hotelservices.Services.ServicesImpl;

import com.example.hotelservices.Entities.Hotel;
import com.example.hotelservices.Exception.ResourceNotFoundException;
import com.example.hotelservices.Repository.HotelRepository;
import com.example.hotelservices.Services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelServices {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomUserId = UUID.randomUUID().toString();
        hotel.setHotelId(randomUserId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found on Server with this id"));
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public void deleteHotel(String id) {

    }
}
