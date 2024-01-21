package com.example.Spring.jpa.Crouser.repo;

import com.example.Spring.jpa.Crouser.entity.RoomImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IRoomImageRepo extends JpaRepository<RoomImage, UUID> {

    List<RoomImage> findAllByRoomId(UUID roomId);
}
