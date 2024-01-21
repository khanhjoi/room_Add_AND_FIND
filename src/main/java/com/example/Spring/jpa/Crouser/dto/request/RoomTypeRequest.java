package com.example.Spring.jpa.Crouser.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class RoomTypeRequest {
    private UUID id;

    private String parentId;

    private String languageCode;

    private String nameType;

    Boolean isDelete;
}
