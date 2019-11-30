package com.montini.teamsports.controller;

import com.montini.teamsports.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {

    @Autowired
    private PlayerRepo playerRepo;

    @GetMapping("/players")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("data", playerRepo.findAll(PageRequest.of(page, 4)));
        return "/";
    }
}
