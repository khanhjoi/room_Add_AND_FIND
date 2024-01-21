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
@Table(name = "room_type")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String parentId;

    private String languageCode;

    private String nameType;

    Boolean isDelete;

    @OneToMany(mappedBy = "roomType")
    @JsonIgnore
    private List<Room> rooms;
}
