package com.example.Spring.jpa.Crouser.dto;

import com.example.Spring.jpa.Crouser.entity.RoomInformation;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
public class RoomUtilityDto {

    private UUID id;

    private String name;

    private String type;
}
