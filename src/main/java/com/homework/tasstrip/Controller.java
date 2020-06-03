package com.homework.tasstrip;

import com.homework.tasstrip.model.ArrivalStrip;
import com.homework.tasstrip.model.DepartureStrip;
import com.homework.tasstrip.service.StripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class Controller {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CSVReader csvReader;
    @Autowired
    StripService stripService;

    @GetMapping("/arrivals")
    public List<ArrivalStrip> getArrivals() throws IOException {
        return stripService.getArrivalStripInformation("/home/gigi/Coding/tasstrip/src/main/java/com/homework/tasstrip/csv/AMR01H-1.csv");
    }

    @GetMapping("/departures")
    public List<DepartureStrip> getDepartures() throws IOException {
        return stripService.getDepartureStripInformation("/home/gigi/Coding/tasstrip/src/main/java/com/homework/tasstrip/csv/AMR19H-2.csv");
    }

}
