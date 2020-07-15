package com.practice.spring.controller;

import com.practice.spring.business.domain.RoomReservation;
import com.practice.spring.business.service.ReservationService;
import com.practice.spring.data.entity.Reservation;
import com.practice.spring.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public Iterable<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/byDate/{date}")
    public Iterable<RoomReservation> getReservations(@PathVariable String date) {
        try {
            return reservationService.getRoomReservationsForDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
