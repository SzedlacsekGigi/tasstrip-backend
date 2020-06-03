package com.homework.tasstrip.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ArrivalStrip {
    private String ssr;
    private String calls;
    private String type;
    private String wtc;
    private String machNumber;
    private List<String> route;
    private String adep;
    private String ades;
    private String levelsOrAltitude;
}
