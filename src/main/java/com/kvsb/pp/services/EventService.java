package com.kvsb.pp.services;

import com.kvsb.pp.dto.EventDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    void createEvent(Long clubId, EventDTO eventDTO);

    List<EventDTO> findAllEvents();
}
