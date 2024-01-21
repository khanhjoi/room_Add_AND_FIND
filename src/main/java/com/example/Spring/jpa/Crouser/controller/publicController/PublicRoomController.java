package com.example.Spring.jpa.Crouser.controller.publicController;

import com.example.Spring.jpa.Crouser.Service.serviceImp.RoomServiceImp;
import com.example.Spring.jpa.Crouser.dto.RoomDTO;
import com.example.Spring.jpa.Crouser.dto.request.RoomRequest;
import com.example.Spring.jpa.Crouser.entity.Room;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/public/v1/room")
public class PublicRoomController {
    private final RoomServiceImp roomService;

    /**
     * Retrieves a list of rooms for a given hotel ID.
     *
     * @param language The language header (optional). Defaults to "vi" if not provided.
     * @param hotelId   The UUID of the hotel.
     * @return ResponseEntity containing a list of Room objects.
     */
    @GetMapping("/{hotelId}")
    public ResponseEntity<List<RoomDTO>> createRoom(
            @RequestHeader(name = "language", required = false)
            String language, @PathVariable UUID hotelId) {
        if (language == null || language.isEmpty()) {
            language = "vn";
        }
        List<RoomDTO> rooms = roomService.findRoomByHotel(language, hotelId);
        return new ResponseEntity<>(rooms, HttpStatus.CREATED);
    }
}
