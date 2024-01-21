package com.example.Spring.jpa.Crouser.repo;

import com.example.Spring.jpa.Crouser.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IHotelRepo extends JpaRepository<Hotel, UUID> {
}
