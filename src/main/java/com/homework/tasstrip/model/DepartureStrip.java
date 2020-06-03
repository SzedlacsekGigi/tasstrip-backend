package com.homework.tasstrip.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartureStrip {
    private String ssr;
    private String calls;
    private String type;
    private String wtc;
    private String machNumber;
    private String sid;
    private String routeName;
    private String time;
    private String goTo;
    private String rfl;
    private String routeOfFlight;
    private String adep;
    private String ades;

}
