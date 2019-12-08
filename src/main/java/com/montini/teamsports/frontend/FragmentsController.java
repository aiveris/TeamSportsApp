package com.montini.teamsports.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FragmentsController {

    @RequestMapping("/")
    public String rootDisplay() {
        return "fragments/events";
    }

    @RequestMapping("/events")
    public String eventsDisplay() {
        return "fragments/events";
    }

    @RequestMapping("/locations")
    public String locationsDisplay() {
        return "fragments/locations";
    }

    @RequestMapping("/players")
    public String playersDisplay() {
        return "fragments/players";
    }

}