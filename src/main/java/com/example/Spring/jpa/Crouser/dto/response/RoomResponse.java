package com.example.Spring.jpa.Crouser.dto.response;

import com.example.Spring.jpa.Crouser.entity.Hotel;
import com.example.Spring.jpa.Crouser.entity.RoomImage;
import com.example.Spring.jpa.Crouser.entity.RoomInformation;
import com.example.Spring.jpa.Crouser.entity.RoomType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {

    private UUID id;

    private Hotel hotel;

    private String parentId;

    private Integer numberRoom; // Use camelCase for variable names

    private BigDecimal priceRoom;

    private Integer capacity;

    private Boolean isDelete;

    private RoomType roomType;

    private List<RoomImage> roomImages;

    private List<RoomInformation> roomInformations;
}
