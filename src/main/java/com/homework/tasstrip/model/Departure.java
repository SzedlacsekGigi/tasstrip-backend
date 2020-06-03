package com.homework.tasstrip.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Departure {
    private String calls;
    private String definedFor;
    private String type;
    private String acModel;
    private String adep;
    private String ades;
    private String time;
    private String depTime;
    private String efl;
    private String goTo;
    private String ssr;
    private String nssr;
    private String ssrModeOut;
    private String cMode;
    private String fms;
    private String acas;
    private String wtc;
    private String ads;
    private String masps;
    private String sMode;
    private String modeSAddress;
    private String registrationNumber;
    private String nsapSel;
    private String datalink;
    private String flightRules;
    private String flrange;
    private String fltyp;
    private String flag1;
    private String flag2;
    private String flag3;
    private String patrol;
    private String forcedCentre;
    private String forcedSector;
    private String airManagement;
    private String adsB;
    private String adsC;
    private String asas;
    private String asasSeq;
    private String asasCross;
    private String routeName;
    private String rfl;
    private String tasSpeed;
    private String sid;
    private String star;
    private String entryPoint;
    private String nextPoint;
    private String heading;
    private String rvsm;
    private String speedMode;
    private String cwpInstructions;
    private String firstGroundDesign;
    private String rtaPoint;
    private String rtaTime;
    private String flag6;
    private String flag7;
    private String flag8;
    private String flag9;
    private String flag10;
    private String aircraftVersion;
    private String payload;
    private String fuelReserve;
    private String approachEquipment;
    private String wtcRecatEu;
    private String holdName;
    private String holdDuration;
    private String pointI;
    private String pointI2;
    private String machNumber;
    private String routeOfFlight;

}
