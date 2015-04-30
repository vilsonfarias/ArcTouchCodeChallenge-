package com.example.user01.myapplication.model.service;

import com.example.user01.myapplication.model.pojo.BusLine;
import com.example.user01.myapplication.model.pojo.BusStops;
import com.example.user01.myapplication.model.pojo.LineDepartures;
import com.example.user01.myapplication.model.pojo.internal.ResponseWrapper;
import com.example.user01.myapplication.model.pojo.internal.BodyParameters;

import retrofit.http.Body;
import retrofit.http.POST;


public interface BusLineRemoteService {
    @POST("/v1/queries/findRoutesByStopName/run")
    ResponseWrapper<BusLine> getBusLine(@Body BodyParameters wrappedLine);

    @POST("/v1/queries/findStopsByRouteId/run")
    ResponseWrapper<BusStops> findStopsByRouteId(@Body BodyParameters wrappedRouteId);

    @POST("/v1/queries/findDeparturesByRouteId/run")
    ResponseWrapper<LineDepartures> findDeparturesByRouteId(@Body BodyParameters wrappedRouteId);
}
