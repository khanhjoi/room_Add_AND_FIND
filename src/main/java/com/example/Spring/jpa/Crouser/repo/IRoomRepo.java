package com.example.Spring.jpa.Crouser.repo;

import com.example.Spring.jpa.Crouser.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IRoomRepo extends JpaRepository<Room, UUID> {
    @Query("SELECT r FROM Room r WHERE r.hotel.hotelId = :hotelId")
    List<Room> findByHotelId(UUID hotelId);
}
