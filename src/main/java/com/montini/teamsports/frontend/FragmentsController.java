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
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

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
        return "redirect:/events";
    }

    ///////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/events")
    public String eventsDisplay(Model model) {
        Collection<PlayEvent> playEventCollection = playEventService.getAllPlayEvent();
        Collection<Location> locationCollection = locationService.getAllLocation();
        model.addAttribute("playevents", playEventCollection);
        model.addAttribute("locations", locationCollection);
        return "fragments/events";
    }

    @RequestMapping(value = "/addPlayEvent", method = RequestMethod.POST)
    public String addPlayEvent(@ModelAttribute("playEventForm") PlayEvent newPlayEvent) {
        newPlayEvent.setLocation(newPlayEvent.getLocation());
        newPlayEvent.setEventDate(newPlayEvent.getEventDate());
        newPlayEvent.setEventTime(newPlayEvent.getEventTime());
        newPlayEvent.setTitle(newPlayEvent.getTitle());
        newPlayEvent.setGameType(newPlayEvent.getGameType());
        newPlayEvent.setFreeSlots(newPlayEvent.getFreeSlots());
        playEventService.savePlayEvent(newPlayEvent);
        return "redirect:/locations";
    }


    @ModelAttribute(value = "playEventForm")
    public PlayEvent getPlayEvent() {
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
    public Location getLocation() {
        return new Location();
    }

    ///////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/players")
    public String playersDisplay(Model model) {
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
    public Player getPlayer() {
        return new Player();
    }

    ///////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/reviews{id}")
    public String reviewsDisplay(@PathVariable Integer id, Model model) {
        PlayEvent playEvent = playEventService.getPlayEvent(id);
        Integer eventId = playEvent.getId();
        String playEventTitle = playEvent.getTitle();
        Set<Review> reviewsSet = playEvent.getReviews();
        model.addAttribute("reviews", reviewsSet);
        model.addAttribute("eventId", eventId);
        model.addAttribute("eventName", playEventTitle);
        return "fragments/reviews";
    }

    @RequestMapping(value = "/addReview{id}", method = RequestMethod.POST)
    public String addReview(@PathVariable Integer id, @ModelAttribute("reviewForm") Review newReview) {

        PlayEvent playEvent = playEventService.getPlayEvent(id);

        Player player = new Player("Marius", "kokokok", "jojo@jojo.com", 0, 10);

        newReview.setTimestamp(new Timestamp(System.currentTimeMillis()));
        newReview.setDescription(newReview.getDescription());
        newReview.setPlayer(player);

        reviewService.create(newReview);
        playerService.create(player);

        Set<Player> players = new HashSet<Player>();
        players.add(player);
        playEvent.setPlayers(players);

        Set<Review> reviews = new HashSet<>();
        reviews.add(newReview);
        playEvent.setReviews(reviews);

        return "redirect:/reviews" + id;
    }

    @ModelAttribute(value = "reviewForm")
    public Review getReview() {
        return new Review();
    }
}