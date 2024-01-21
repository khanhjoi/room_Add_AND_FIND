package com.example.Spring.jpa.Crouser.Service.serviceImp;

import com.example.Spring.jpa.Crouser.Service.IRoomService;
import com.example.Spring.jpa.Crouser.dto.RoomDTO;
import com.example.Spring.jpa.Crouser.dto.RoomImageDto;
import com.example.Spring.jpa.Crouser.dto.RoomInformationDTO;
import com.example.Spring.jpa.Crouser.dto.request.RoomRequest;
import com.example.Spring.jpa.Crouser.entity.*;
import com.example.Spring.jpa.Crouser.repo.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor
public class RoomServiceImp implements IRoomService {

    private final IRoomRepo roomRepo;

    private final IHotelRepo hotelRepo;

    private final IRoomInformationRepo roomInformationRepo;

    private final IRoomTypeRepo roomTypeRepo;

    private final IRoomImageRepo roomImageRepo;

    private final IRoomUtilityRepo roomUtilityRepo;
    @Override
    public RoomDTO createRoom(RoomRequest roomRequest) {
        try {
//            create and build room entity
            Hotel hotel = hotelRepo.findById(roomRequest.getHotelId())
                    .orElseThrow(() -> new Exception("Không tồn tại hotel"));
            RoomType roomType = roomTypeRepo.findById(roomRequest.getRoomType())
                    .orElseThrow(() -> new Exception("Không tồn tại hotel"));

            Room room = Room.builder()
                    .hotel(hotel)
                    .numberRoom(roomRequest.getNumberRoom())
                    .priceRoom(roomRequest.getPriceRoom())
                    .capacity(roomRequest.getCapacity())
                    .isDelete(roomRequest.getIsDelete())
                    .roomType(roomType)
                    .build();
            Room savedRoom = roomRepo.save(room);

            // create and build room utility entities
            List<RoomUtility> roomUtilities = roomRequest.getRoomUtility().stream()
                    .map(item -> {
                        try {
                            return roomUtilityRepo.findById(item).orElseThrow(() -> new Exception("Không tồn tại room utility"));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());

            List<RoomInformation> roomInformationEntities = roomRequest.getRoomInformation().stream()
                    .map(item -> RoomInformation.builder()
                            .room(savedRoom) // Set the reference to the parent room
                            .roomName(item.getRoomName())
                            .Description(item.getDescription())
                            .languageCode(item.getLanguageCode())
                            .isDelete(item.getIsDelete())
                            .ParentId(item.getParentId())
                            .roomUtilities(roomUtilities)
                            .status(item.getStatus())
                            .build())
                    .collect(Collectors.toList());
            List<RoomInformation> savedRoomInformationList = roomInformationRepo.saveAll(roomInformationEntities);

            List<RoomImage>  roomImages = roomRequest.getRoomImages().stream()
                    .map(item -> RoomImage.builder()
                            .room(room)
                            .URL(item.getURL())
                            .isDelete(item.isDelete())
                            .status(item.getStatus())
                            .build())
                    .collect(Collectors.toList());
            List<RoomImage> savedRoomImages = roomImageRepo.saveAll(roomImages);

            RoomDTO roomDTO = convertToRoomDTO(savedRoom, savedRoomInformationList, savedRoomImages);
            return roomDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private RoomDTO convertToRoomDTO(Room savedRoom, List<RoomInformation> savedRoomInformations, List<RoomImage> savedRoomImages) {
        Hotel hotel = savedRoom.getHotel();

        RoomType roomType = savedRoom.getRoomType();
        // Set roomInfoMation
        List<RoomInformationDTO> roomInformationDTOs = savedRoomInformations.stream()
                .map(this::convertToRoomInformationDTO)
                .collect(Collectors.toList());

        // Set room images
        List<RoomImageDto> roomImageDTOs = savedRoomImages.stream()
                .map(this::convertToRoomImageDTO)
                .collect(Collectors.toList());

        RoomDTO roomDTO = RoomDTO.builder()
                .id(savedRoom.getId())
                .numberRoom(savedRoom.getNumberRoom())
                .priceRoom(savedRoom.getPriceRoom())
                .capacity(savedRoom.getCapacity())
                .isDelete(savedRoom.getIsDelete())
                .hotel(hotel)
                .roomType(roomType)
                .roomInformation(roomInformationDTOs.get(0))
                .roomImages(roomImageDTOs)
                .build();
        return roomDTO;
    }

    private RoomInformationDTO convertToRoomInformationDTO(RoomInformation roomInformation) {
        RoomInformationDTO roomInformationDTO = RoomInformationDTO.builder()
                .roomName(roomInformation.getRoomName())
                .Description(roomInformation.getDescription())
                .isDelete(roomInformation.getIsDelete())
                .status(roomInformation.getStatus())
                .build();
        // Set other properties if needed
        return roomInformationDTO;
    }

    private RoomImageDto convertToRoomImageDTO(RoomImage roomImage) {
        RoomImageDto roomImageDTO = RoomImageDto.builder()
                .URL(roomImage.getURL())
                .isDelete(roomImage.isDelete())
                .status(roomImage.getStatus())
                .build();
        // Set other properties if needed
        return roomImageDTO;
    }

    @Override
    public List<RoomDTO> findRoomByHotel(String languageCode, UUID hotelId) {

        List<Room> roomsRepo = roomRepo.findByHotelId(hotelId);
        List<RoomDTO> roomDTOList = new ArrayList<>();


        for (Room room : roomsRepo) {
            // find RoomType
            RoomType roomType = roomTypeRepo.findByIdAndLanguageCode(room.getRoomType().getId(), languageCode) ;
            if(Objects.isNull(roomType)) {
                roomType = roomTypeRepo.findByParentIdAndLanguageCode(room.getRoomType().getId().toString(), languageCode);
            }

            // get Room image by roomId and conver to DTO
            List<RoomImage> roomImages = roomImageRepo.findAllByRoomId(room.getId());
            List<RoomImageDto> roomImageDTOList = roomImages.stream()
                    .map(this::convertToRoomImageDTO)
                    .collect(Collectors.toList());

            RoomInformation roomInformation = roomInformationRepo.findByRoomAndAndLanguageCode(room, languageCode);
            RoomInformationDTO roomInformationDTO = convertToRoomInformationDTO(roomInformation);

            List<RoomUtility> roomUtilities = roomUtilityRepo.findByRoomInformations(roomInformation);

            List<RoomUtility> filteredRoomUtilities = roomUtilities.stream()
                    .filter(roomUtility -> {
                        return Objects.equals(roomUtility.getLanguageCode(), languageCode);
                    })
                    .collect(Collectors.toList());

            RoomDTO roomDTO = RoomDTO.builder()
                    .id(room.getId())
                    .parentId(room.getParentId())
                    .numberRoom(room.getNumberRoom())
                    .priceRoom(room.getPriceRoom())
                    .capacity(room.getCapacity())
                    .isDelete(room.getIsDelete())
                    .roomType(roomType)
                    .roomImages(roomImageDTOList)
                    .roomInformation(roomInformationDTO)
                    .roomUtilities(filteredRoomUtilities)
                    // Set other properties accordingly
                    .build();

            roomDTOList.add(roomDTO);
        }

        return roomDTOList;
    }

    @Override
    public RoomDTO updateRoom() {
        return null;
    }

    @Override
    public RoomDTO deleteRoom() {
        return null;
    }
}
