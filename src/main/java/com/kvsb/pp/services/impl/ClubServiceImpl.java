package com.kvsb.pp.services.impl;

import com.kvsb.pp.dto.ClubDTO;
import com.kvsb.pp.entities.Club;
import com.kvsb.pp.repositories.ClubRepository;
import com.kvsb.pp.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvsb.pp.mappers.ClubMapper;

import java.util.List;

import java.util.stream.Collectors;

import static com.kvsb.pp.mappers.ClubMapper.mapToClub;
import static com.kvsb.pp.mappers.ClubMapper.mapToClubDTO;

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
    public Club save(ClubDTO clubDTO) {
        Club club = mapToClub(clubDTO);
        return repository.save(club);
    }

    public ClubDTO findClubById(Long clubId) {
        Club club = repository.findById(clubId).get();
        return mapToClubDTO(club);
    }

    @Override
    public void updateClub(ClubDTO clubDTO) {
        Club club = mapToClub(clubDTO);
        repository.save(club);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClubDTO> searchClubs(String query) {
        List<Club> clubs = repository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDTO(club)).collect(Collectors.toList());
    }

}
