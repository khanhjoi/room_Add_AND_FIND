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
@Table(name = "room_information")

public class RoomInformation {
    @Id
    @Column(name = "roomInfoID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID RoomId;

    @ManyToOne
    @JsonIgnore
    private Room room;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    @JoinTable(
            name = "service_information",
            joinColumns = @JoinColumn(name = "roomInfoID"),
            inverseJoinColumns = @JoinColumn(name = "room_utility_id")

    )
    private List<RoomUtility> roomUtilities;

    private String roomName;

    private String languageCode;

    private String Description;

    private String ParentId;

    private Boolean isDelete;

    private String status;

}