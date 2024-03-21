package com.kvsb.pp.controllers;

import com.kvsb.pp.dto.ClubDTO;
import com.kvsb.pp.services.ClubService;
import com.kvsb.pp.services.impl.ClubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClubController {

    @Autowired
    private ClubServiceImpl service;


    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDTO> clubs = service.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }
}
