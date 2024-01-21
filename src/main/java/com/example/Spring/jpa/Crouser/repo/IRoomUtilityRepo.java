package com.example.Spring.jpa.Crouser.repo;

import com.example.Spring.jpa.Crouser.entity.RoomInformation;
import com.example.Spring.jpa.Crouser.entity.RoomUtility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IRoomUtilityRepo extends JpaRepository<RoomUtility, UUID> {

    List<RoomUtility> findByRoomInformations(RoomInformation roomInformation);
}
