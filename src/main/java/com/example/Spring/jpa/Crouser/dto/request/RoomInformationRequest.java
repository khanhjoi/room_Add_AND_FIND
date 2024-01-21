package com.example.Spring.jpa.Crouser.dto.request;


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
public class RoomInformationRequest {

    private Room room;

    private String roomName;

    private String languageCode;

    private String description;

    private String ParentId;

    private Boolean isDelete;

    private String status;
}
