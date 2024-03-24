package com.kvsb.pp.services;

import com.kvsb.pp.dto.EventDTO;
import org.springframework.stereotype.Service;

@Service
public interface EventService {

    void createEvent(Long clubId, EventDTO eventDTO);

}
