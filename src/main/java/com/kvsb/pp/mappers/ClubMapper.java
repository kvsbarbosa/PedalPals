package com.kvsb.pp.mappers;

import com.kvsb.pp.dto.ClubDTO;
import com.kvsb.pp.dto.EventDTO;
import com.kvsb.pp.entities.Club;
import com.kvsb.pp.entities.Event;

import java.util.stream.Collectors;

import static com.kvsb.pp.mappers.EventMapper.mapToEventDTO;

public class ClubMapper {

    public static Club mapToClub(ClubDTO club) {
        Club clubDTO = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDTO;
    }

    public static ClubDTO mapToClubDTO(Club club) {
        ClubDTO clubDTO = ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event) -> mapToEventDTO(event)).collect(Collectors.toList()))
                .build();
        return clubDTO;
    }



}
