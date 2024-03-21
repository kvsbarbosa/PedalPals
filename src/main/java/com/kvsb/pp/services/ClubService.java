package com.kvsb.pp.services;

import com.kvsb.pp.dto.ClubDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {

    List<ClubDTO> findAllClubs();

}
