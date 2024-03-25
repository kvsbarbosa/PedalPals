package com.kvsb.pp.controllers;

import com.kvsb.pp.dto.ClubDTO;
import com.kvsb.pp.dto.EventDTO;
import com.kvsb.pp.entities.Event;
import com.kvsb.pp.entities.UserEntity;
import com.kvsb.pp.security.SecurityUtil;
import com.kvsb.pp.services.ClubService;
import com.kvsb.pp.services.UserService;
import com.kvsb.pp.services.impl.EventServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventServiceImpl service;
    @Autowired
    private UserService userService;
    @Autowired
    private ClubService clubService;

    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, @ModelAttribute("event") EventDTO eventDTO,
                              Model model, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("event", eventDTO);
            return "clubs-create";
        }

        service.createEvent(clubId, eventDTO);
        return "redirect:/clubs/" + clubId;
    }

    @GetMapping("/events")
    public String eventList(Model model) {
        UserEntity user = new UserEntity();
        List<EventDTO> events = service.findAllEvents();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId, Model model) {
        UserEntity user = new UserEntity();
        EventDTO eventDTO = service.findByEventId(eventId);
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("club", eventDTO.getClub());
        model.addAttribute("user", user);
        model.addAttribute("event", eventDTO);
        return "events-detail";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model) {
        EventDTO eventDTO = service.findByEventId(eventId);
        model.addAttribute("event", eventDTO);
        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute("event") EventDTO event,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", event);
            return "events-edit";
        }
        EventDTO eventDTO = service.findByEventId(eventId);
        event.setId(eventId);
        event.setClub(eventDTO.getClub());
        service.updateEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long eventId) {
        service.deleteEvent(eventId);
        return "redirect:/events";
    }

}
