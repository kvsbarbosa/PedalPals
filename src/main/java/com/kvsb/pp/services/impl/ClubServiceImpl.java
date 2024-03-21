package com.kvsb.pp.services.impl;

import com.kvsb.pp.dto.ClubDTO;
import com.kvsb.pp.entities.Club;
import com.kvsb.pp.repositories.ClubRepository;
import com.kvsb.pp.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository repository;

    @Override
    public List<ClubDTO> findAllClubs() {
        List<Club> clubs = repository.findAll();
        return clubs.stream().map((club -> mapToClubDTO(club))).collect(Collectors.toList());
    }

    @Override
    public Club save(Club club) {
        return repository.save(club);
    }

    private ClubDTO mapToClubDTO(Club club) {
        ClubDTO clubDTO = ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updateOn(club.getUpdateOn())
                .build();
        return clubDTO;
    }
}
