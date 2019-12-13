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

import java.sql.Timestamp;
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


    @ModelAttribute(value = "playEvent")
    public PlayEvent getPlayEvent()
    {
        return new PlayEvent();
    }

    ///////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/locations")
    public String locationsDisplay(Model model) {
        Collection<Location> locationCollection = locationService.getAllLocation();
        model.addAttribute("locations", locationCollection);
        return "fragments/locations";
    }

    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    public String addLocation(@ModelAttribute("locationForm") Location newLocation) {
        newLocation.setName(newLocation.getName());
        newLocation.setAddress(newLocation.getAddress());
        newLocation.setMaxCourts(newLocation.getMaxCourts());
        newLocation.setFreeCourts(1);
        locationService.saveLocation(newLocation);
        return "redirect:/locations";
    }

    @ModelAttribute(value = "locationForm")
    public Location getLocation() {return new Location();}

    ///////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/players")
    public String playersDisplay(Model model){
        Collection<Player> playerSet = playerService.getAll();
        model.addAttribute("players", playerSet);
        return "fragments/players";
    }

    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute("player") Player newPlayer) {
        newPlayer.setUsername(newPlayer.getUsername());
        newPlayer.setPassword(newPlayer.getPassword());
        newPlayer.setEmail(newPlayer.getEmail());
        newPlayer.setRank(0);
        newPlayer.setUserType(1);
        playerService.create(newPlayer);
        return "redirect:/players";
    }

    @ModelAttribute(value = "player")
    public Player getPlayer()
    {
        return new Player();
    }

    ///////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/reviews")
    public String reviewsDisplay(Model model){
        List<Review> reviewsList= reviewService.getAll();
        model.addAttribute("reviews", reviewsList);
        return "fragments/reviews";
    }

    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String addReview(@ModelAttribute("reviewForm") Review newReview) {
        newReview.setTimestamp(new Timestamp(System.currentTimeMillis()));
        newReview.setDescription(newReview.getDescription());
        reviewService.create(newReview);
        return "redirect:/reviews";
    }

    @ModelAttribute(value = "reviewForm")
    public Review getReview() {return new Review();}

}