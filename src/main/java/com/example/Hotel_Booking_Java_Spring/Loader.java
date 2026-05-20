package com.example.Hotel_Booking_Java_Spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Load data into the h2 database (in memory) when app. starts

@Configuration
public class Loader {
    
    @Bean
    CommandLineRunner loadData(RoomRep repo) {
        return args -> {
            repo.save(new Room("Single", 100));
            repo.save(new Room("Single", 110));
            repo.save(new Room("Double", 130));
            repo.save(new Room("Suite", 160));
        };
    }
}