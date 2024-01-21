package com.example.Spring.jpa.Crouser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID hotelId;
    private String nameHotel;

    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<Room> rooms;
}
