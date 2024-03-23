package com.kvsb.pp.repositories;

import com.kvsb.pp.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event, Long> {
}
