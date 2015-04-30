package com.example.user01.myapplication.model.service;

import com.example.user01.myapplication.model.pojo.BusLine;
import com.example.user01.myapplication.model.pojo.BusStop;
import com.example.user01.myapplication.model.pojo.LineDeparture;
import com.example.user01.myapplication.model.pojo.internal.BodyParameters;

import java.util.List;

public class BusLineServiceFacade {
private static final String SEARCH_MASK = "%%%s%%";

    BusLineRemoteService remoteService;

    public BusLineServiceFacade() {
        remoteService = new BusLineService().getService();
    }

    public List<BusLine> getBusLine(String streetName) {
        BodyParameters params = new BodyParameters().putParam("stopName", String.format(SEARCH_MASK, streetName));
        return remoteService.getBusLine(params).getRows();
    }

    public List<BusStop> getBusStops(Integer routeId) {
        BodyParameters params = new BodyParameters().putParam("routeId", routeId);
        return remoteService.findStopsByRouteId(params).getRows();
    }

    public List<LineDeparture> getLineDepartures(Integer routeId){
        BodyParameters params = new BodyParameters().putParam("routeId", routeId);
        return remoteService.findDeparturesByRouteId(params).getRows();
    }

}
