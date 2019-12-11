package com.montini.teamsports.frontend;

import com.montini.teamsports.model.Location;
import com.montini.teamsports.model.PlayEvent;
import com.montini.teamsports.model.Player;
import com.montini.teamsports.service.LocationService;
import com.montini.teamsports.service.PlayEventService;
import com.montini.teamsports.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class FragmentsController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PlayEventService playEventService;

    @RequestMapping("/")
    public String rootDisplay() {
        return "fragments/events";
    }

    @RequestMapping("/events")
    public String eventsDisplay(Model model) {
        Collection<PlayEvent> playEventCollection = playEventService.getAllPlayEvent();
        model.addAttribute("playevents", playEventCollection);
        return "fragments/events";
    }

    @RequestMapping("/locations")
    public String locationsDisplay(Model model) {
        Collection<Location> locationCollection = locationService.getAllLocation();
        model.addAttribute("locations", locationCollection);
        return "fragments/locations";
    }

    @RequestMapping("/players")
    public String playersDisplay(Model model){
        Collection<Player> playerSet = playerService.getAll();
        model.addAttribute("players", playerSet);
        return "fragments/players";
    }

}