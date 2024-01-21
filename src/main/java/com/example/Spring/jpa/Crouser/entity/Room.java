package com.example.Spring.jpa.Crouser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor // Add this annotation for @Builder to work with non-final fields
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Hotel hotel;

    private String parentId;

    private Integer numberRoom; // Use camelCase for variable names

    private BigDecimal priceRoom;

    private Integer capacity;

    private Boolean isDelete;

    @ManyToOne
    @JsonIgnore
    private RoomType roomType;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<RoomImage> roomImages;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<RoomInformation> roomInformations;
}
