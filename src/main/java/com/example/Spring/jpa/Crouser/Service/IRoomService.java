package com.example.Spring.jpa.Crouser.Service;

import com.example.Spring.jpa.Crouser.dto.RoomDTO;
import com.example.Spring.jpa.Crouser.dto.request.RoomRequest;
import com.example.Spring.jpa.Crouser.entity.Room;

import java.util.List;
import java.util.UUID;

public interface IRoomService {

    RoomDTO createRoom(RoomRequest roomRequest);

    List<RoomDTO> findRoomByHotel(String languageCode, UUID Hotel);

    RoomDTO updateRoom();

    RoomDTO deleteRoom();
}
