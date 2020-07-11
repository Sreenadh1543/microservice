package com.practice.spring.microservicedev.data.repository;

import com.practice.spring.microservicedev.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
