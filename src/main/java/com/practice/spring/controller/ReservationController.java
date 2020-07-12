package com.practice.spring.controller;

import com.practice.spring.data.entity.Reservation;
import com.practice.spring.data.repository.ReservationReposirtory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationReposirtory reservationReposirtory;

    @GetMapping
    public Iterable<Reservation> getRooms() {
        return reservationReposirtory.findAll();
    }

}
