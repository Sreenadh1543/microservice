package com.practice.spring.controller;

import com.practice.spring.data.entity.Guest;
import com.practice.spring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public Iterable<Guest> getRooms() {
        return this.guestRepository.findAll();
    }
}
