package com.example.user01.myapplication.model.service;

import com.example.user01.myapplication.model.pojo.BusLine;
import com.example.user01.myapplication.model.pojo.BusStops;
import com.example.user01.myapplication.model.pojo.LineDepartures;
import com.example.user01.myapplication.model.pojo.internal.BodyParameters;

import java.util.List;

public class BusLineServiceFacade {
private static final String mask = "%%%s%%";

    BusLineRemoteService remoteService;

    public BusLineServiceFacade() {
        remoteService = new BusLineService().getService();
    }

    public List<BusLine> getBusLine(String streetName) {
        BodyParameters params = new BodyParameters().putParam("stopName", String.format(mask, streetName));
        return remoteService.getBusLine(params).getRows();
    }

    public List<BusStops> getBusStops(Integer routeId) {
        BodyParameters params = new BodyParameters().putParam("routeId", String.format(mask, routeId));
        return remoteService.findStopsByRouteId(params).getRows();
    }

    public List<LineDepartures> getLineDepartures(Integer routeId){
        BodyParameters params = new BodyParameters().putParam("routeId", String.format(mask, routeId));
        return remoteService.findDeparturesByRouteId(params).getRows();
    }

}
