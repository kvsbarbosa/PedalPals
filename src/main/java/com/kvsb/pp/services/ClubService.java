package com.kvsb.pp.services;

import com.kvsb.pp.dto.ClubDTO;
import com.kvsb.pp.entities.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {

    List<ClubDTO> findAllClubs();
    Club save(ClubDTO clubDTO);
    ClubDTO findClubById(Long id);

    void updateClub(ClubDTO clubDTO);
    void delete(Long id);

    List<ClubDTO> searchClubs(String query);
}
