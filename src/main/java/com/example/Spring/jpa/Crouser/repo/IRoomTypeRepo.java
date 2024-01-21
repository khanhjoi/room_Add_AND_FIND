package com.example.Spring.jpa.Crouser.repo;

import com.example.Spring.jpa.Crouser.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRoomTypeRepo extends JpaRepository<RoomType, UUID> {

    RoomType findByIdAndLanguageCode(UUID id, String languageCode);

    RoomType findByParentIdAndLanguageCode(String ParentId, String languageCode);
}
