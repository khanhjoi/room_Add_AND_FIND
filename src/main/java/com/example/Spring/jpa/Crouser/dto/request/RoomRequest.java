package com.example.Spring.jpa.Crouser.dto.request;

import com.example.Spring.jpa.Crouser.dto.RoomImageDto;
import com.example.Spring.jpa.Crouser.entity.Hotel;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
public class RoomRequest {

    private UUID id;

    private UUID hotelId;

    private String parentId;

    private Integer numberRoom;

    private BigDecimal priceRoom;

    private Integer capacity;

    private Boolean isDelete;

    private List<RoomInformationRequest> roomInformation;

    private List<UUID> RoomUtility;

    private UUID roomType;

    private List<RoomImageDto> roomImages;

}
