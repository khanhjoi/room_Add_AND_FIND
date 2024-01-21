package com.example.Spring.jpa.Crouser.dto;

import com.example.Spring.jpa.Crouser.entity.Hotel;
import com.example.Spring.jpa.Crouser.entity.RoomInformation;
import com.example.Spring.jpa.Crouser.entity.RoomType;
import com.example.Spring.jpa.Crouser.entity.RoomUtility;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class RoomDTO {

    private UUID id;

    private Hotel hotel;

    private String parentId;

    private Integer numberRoom;

    private BigDecimal priceRoom;

    private Integer capacity;

    private Boolean isDelete;

    private RoomType roomType;

    private List<RoomImageDto> roomImages;

    private RoomInformationDTO roomInformation;

    private List<RoomUtility> roomUtilities;
}
