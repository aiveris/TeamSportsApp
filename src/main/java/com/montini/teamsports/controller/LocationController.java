package com.montini.teamsports.controller;

import com.montini.teamsports.model.Location;
import com.montini.teamsports.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class LocationController {

    // @Autowired
    // private LocationRepo locationRepo;
    //
    // @GetMapping("/locations")
    // public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
    //     model.addAttribute("data", locationRepo.findAll(PageRequest.of(page, 4)));
    //     return "index";
    // }
    //
    // @PostMapping("/save")
    // public String save(Location location) {
    //     locationRepo.save(location);
    //     return "redirect:/";
    // }
    //
    // @GetMapping("/delete")
    // public String delete(Location location) {
    //     locationRepo.delete(location);
    //     return "redirect:/";
    // }

    // @GetMapping("/findOne")
    // @ResponseBody
    // public Location find(Integer id) {
    //     return locationRepo.findById(id);
    // }

}
