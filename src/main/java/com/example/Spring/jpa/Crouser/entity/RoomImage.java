package com.example.Spring.jpa.Crouser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class RoomImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String URL;

    @ManyToOne
    @JsonIgnore
    private Room room;

    private boolean isDelete;

    private String status;
}
