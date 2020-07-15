package com.practice.spring.business.service;

import com.practice.spring.business.domain.RoomReservation;
import com.practice.spring.data.entity.Guest;
import com.practice.spring.data.entity.Reservation;
import com.practice.spring.data.entity.Room;
import com.practice.spring.data.repository.GuestRepository;
import com.practice.spring.data.repository.ReservationRepository;
import com.practice.spring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {

    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ReservationService(GuestRepository guestRepository,
                              ReservationRepository reservationRepository,
                              RoomRepository roomRepository) {
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = reservationRepository.
                findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
            roomReservationMap.put(reservation.getRoomId(), roomReservation);
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        return roomReservations;
    }
}
