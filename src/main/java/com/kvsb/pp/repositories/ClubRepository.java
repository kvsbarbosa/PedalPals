package com.kvsb.pp.repositories;

import com.kvsb.pp.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {

    Optional<Club> findByTitle(String title);

}
