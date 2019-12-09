package com.montini.teamsports;

import com.montini.teamsports.dao.LocationDao;
import com.montini.teamsports.model.Location;
import com.montini.teamsports.service.LocationServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration("classpath:resources")
@ComponentScan("com.montini.teamsports")
public class LocationTests {

    private static final Logger log = LoggerFactory.getLogger( Location.class );

    @Mock
    LocationDao locationDao;

    @InjectMocks
    LocationServiceImpl locationService;

    final List<Location> locations = new ArrayList<Location>();

    public void getLocationsList() {

        Location l1 = new Location();
        l1.setId(1);
        l1.setName("Axel");
        l1.setAddress("balcikonio 9");
        l1.setMaxCourts(5);
        l1.setFreeCourts(4);

        Location l2 = new Location();
        l2.setId(2);
        l2.setName("paxel");
        l2.setAddress("gerulaicio 9");
        l2.setMaxCourts(6);
        l2.setFreeCourts(3);

        locations.add(l1);
        locations.add(l2);

    }

    @PostConstruct
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.getLocationsList();
    }

    @Test
    public void getLocation(){
        Location location = locations.get(0);
        when(locationDao.getLocation(anyInt())).thenReturn(location);
        Assert.assertNotNull(locationService.getLocation( location.getId() ));
        Assert.assertTrue(locationService.getLocation( location.getId() ).getId() > 0);
    }

    @Test
    public void saveLocation(){
            doNothing().doThrow(new RuntimeException()).when( locationDao).saveLocation( locations.get(0), true );
    }

    @Test
    public void updateLocation(){
        Location location = locations.get(0);
        when(locationDao.getLocation(anyInt())).thenReturn(location);
        locationService.updateLocation(location);
        verify(locationDao, atLeastOnce()).updateLocation(any());
    }

    @Test
    public void deleteLocation(){
        doNothing().when(locationDao).deleteLocation(anyInt());
        locationService.deleteLocation(anyInt());
        verify(locationDao, atLeastOnce()).deleteLocation(anyInt());
    }

    @Test
    public void getAllLocation(){
        when(locationDao.getAllLocation()).thenReturn(locations);
        Assert.assertEquals(locationService.getAllLocation(), locations);
    }




}