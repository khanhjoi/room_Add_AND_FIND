package com.example.Spring.jpa.Crouser.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class RoomImageDto {

    private String URL;

    private boolean isDelete;

    private String status;
}
