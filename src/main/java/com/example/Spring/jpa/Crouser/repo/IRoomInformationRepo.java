package com.example.Spring.jpa.Crouser.repo;

import com.example.Spring.jpa.Crouser.entity.Room;
import com.example.Spring.jpa.Crouser.entity.RoomInformation;
import com.example.Spring.jpa.Crouser.entity.RoomUtility;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRoomInformationRepo extends JpaRepository<RoomInformation, UUID> {

    RoomInformation findByRoomAndAndLanguageCode(Room room, String languageCode);


}
