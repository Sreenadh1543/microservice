package com.practice.spring.data.repository;

import com.practice.spring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationReposirtory extends CrudRepository<Reservation, Long> {
}
