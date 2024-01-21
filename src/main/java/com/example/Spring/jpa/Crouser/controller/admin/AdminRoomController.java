package com.example.Spring.jpa.Crouser.controller.admin;

import com.example.Spring.jpa.Crouser.Service.serviceImp.RoomServiceImp;
import com.example.Spring.jpa.Crouser.dto.RoomDTO;

import com.example.Spring.jpa.Crouser.dto.request.RoomRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/v1/room")
public class AdminRoomController {

    private final RoomServiceImp roomService;

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomRequest roomRequest) {
        RoomDTO createdRoom = roomService.createRoom(roomRequest);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }
}
