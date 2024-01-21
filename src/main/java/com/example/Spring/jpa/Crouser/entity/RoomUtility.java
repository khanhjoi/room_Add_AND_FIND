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
@Table(name = "room_utility")
public class RoomUtility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany(mappedBy = "roomUtilities")
    @JsonIgnore
    private List<RoomInformation> roomInformations;

    private String name;

    private String languageCode;

    private String parentID;

    private boolean isDelete;

    private String type;
}
