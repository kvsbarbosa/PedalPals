package com.kvsb.pp.services.impl;

import com.kvsb.pp.dto.EventDTO;
import com.kvsb.pp.entities.Event;
import com.kvsb.pp.repositories.ClubRepository;
import com.kvsb.pp.repositories.EventRepository;
import com.kvsb.pp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kvsb.pp.entities.Club;

import java.util.List;
import java.util.stream.Collectors;

import static com.kvsb.pp.mappers.EventMapper.mapToEvent;
import static com.kvsb.pp.mappers.EventMapper.mapToEventDTO;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public void createEvent(Long clubId, EventDTO eventDTO) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDTO);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDTO> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDTO(event)).collect(Collectors.toList());
    }

    @Override
    public EventDTO findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDTO(event);
    }

    @Override
    public void updateEvent(EventDTO eventDTO) {
        Event event = mapToEvent(eventDTO);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}

