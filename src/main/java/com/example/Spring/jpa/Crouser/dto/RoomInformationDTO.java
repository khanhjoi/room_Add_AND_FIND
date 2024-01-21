package com.example.Spring.jpa.Crouser.dto;

import com.example.Spring.jpa.Crouser.entity.Room;
import com.example.Spring.jpa.Crouser.entity.RoomUtility;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class RoomInformationDTO {

    private UUID RoomId;

    private String roomName;

    private String Description;

    private Boolean isDelete;

    private String status;
}
