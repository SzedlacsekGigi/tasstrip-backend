package com.homework.tasstrip.service;

import com.homework.tasstrip.CSVReader;
import com.homework.tasstrip.model.ArrivalStrip;
import com.homework.tasstrip.model.DepartureStrip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class StripService {

    CSVReader csvReader = new CSVReader();

    public List<ArrivalStrip> getArrivalStripInformation(String filepath) throws IOException{
        List<ArrivalStrip> arrivals = new ArrayList<>();
        ArrayList<List<String>> records = csvReader.readCSV(filepath);
        records.remove(0);
        for (List<String> record:records) {
            ArrivalStrip newArrivalStrip = ArrivalStrip.builder()
                    .calls(record.get(0))
                    .type(record.get(2))
                    .adep(record.get(4))
                    .ades(record.get(5))
                    .ssr(record.get(10))
                    .wtc(record.get(16))
                    .machNumber(generateMachNumber())
                    .levelsOrAltitude("F100")
                    .route(starRoute(record.get(43)))
                    .build();
            arrivals.add(newArrivalStrip);
        }
        return arrivals;
    }

    public List<DepartureStrip> getDepartureStripInformation(String filepath) throws IOException{
        List<DepartureStrip> departures = new ArrayList<>();
        ArrayList<List<String>> records = csvReader.readCSV(filepath);
        records.remove(0);
        for (List<String> record:records) {
            DepartureStrip newDepartureStrip = DepartureStrip.builder()
                    .ssr(record.get(10))
                    .calls(record.get(0))
                    .type(record.get(2))
                    .wtc(record.get(16))
                    .machNumber(generateMachNumber())
                    .sid(formatSidName(record.get(42)))
                    .routeName(formatRouteName(record.get(39)))
                    .time(formatTime(record.get(6)))
                    .goTo(formatFlightLevel(record.get(9)))
                    .rfl(formatFlightLevel(record.get(40)))
                    .routeOfFlight(formatFlightRoute(record.get(65), record.get(66)))
                    .adep(record.get(4))
                    .ades(record.get(5))
                    .build();
            departures.add(newDepartureStrip);
        }
        return departures;
    }

    private String generateMachNumber(){
        Random r = new Random();
        Integer number = r.nextInt(82-79)+79;
        return "M0" + number.toString();
    }

    private String formatSidName(String sid){
        if (sid.isEmpty()){
            return "";
        } else {
            String endPiece = sid.substring(0, 2);
            String frontPiece = sid.substring(2);
            return frontPiece + endPiece;
        }
    }

    private String formatRouteName(String routeName){
        if (routeName.isEmpty()){
            return "";
        } else {
          return routeName.replaceAll("\\D+", "");
        }
    }

    private String formatTime(String time){
        return time.replaceAll(":", "").substring(0, 4);
    }

    private String formatFlightLevel(String flightLevel){
        return "F" + flightLevel;
    }

    private String formatFlightRoute(String pointI1, String pointI2){
        return pointI1 + " " + pointI2;
    }

    private String shortSidName(String sid){
        if(sid.isEmpty()){
            return "";
        } else {
            return sid.substring(0, sid.length()-2);
        }
    }

    public List<String> starRoute(String star){
        String formattedName = formatSidName(star);
        List<String> route = new ArrayList<>();
        route.add(shortSidName(formattedName));
        route.add(formattedName);
        switch (formattedName) {
            case "DEVUD3N":
            case "NASBU3N":
            case "ASRUN2N":
            case "BASLU2N":
                route.add("DEXON");
                break;
            case "INGAN3N":
            case "GIRUG2N":
            case "ELDIS2N":
            case "BIRNA1N":
                route.add("RENDU");
                break;
            case "DEVUD2K":
            case "NASBU2K":
            case "ASRUN2K":
            case "BASLU2K":
                route.add("ELVUM");
                break;
            case "INGAN2K":
            case "GIRUG2K":
            case "ELDIS2K":
            case "BIRNA2K":
                route.add("VALUX");
                break;
            case "":
                route.add("");
        }
        return route;
    }

}