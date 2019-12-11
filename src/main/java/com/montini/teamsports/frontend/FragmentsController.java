package com.montini.teamsports.frontend;

import com.montini.teamsports.model.Location;
import com.montini.teamsports.model.PlayEvent;
import com.montini.teamsports.model.Player;
import com.montini.teamsports.model.Review;
import com.montini.teamsports.service.LocationService;
import com.montini.teamsports.service.PlayEventService;
import com.montini.teamsports.service.PlayerService;
import com.montini.teamsports.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
public class FragmentsController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PlayEventService playEventService;

    @Autowired
    private ReviewService reviewService;

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

    @RequestMapping("/reviews")
    public String reviewsDisplay(Model model){
        List<Review> reviewsList= reviewService.getAll();
        model.addAttribute("reviews", reviewsList);
        return "fragments/reviews";
    }

    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute("player") Player newPlayer, Model model) {
        newPlayer.setRank(0);
        newPlayer.setUserType(1);
        playerService.create(newPlayer);
        return "fragments/locations";
    }

    @ModelAttribute(value = "player")
    public Player getPlayer()
    {
        return new Player();
    }
}