package com.example.user01.myapplication.model.service;

import com.example.user01.myapplication.model.pojo.BusLine;
import com.example.user01.myapplication.model.pojo.BusStop;
import com.example.user01.myapplication.model.pojo.LineDeparture;
import com.example.user01.myapplication.model.pojo.internal.BodyParameters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class BusLineServiceAdapter {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'+'SSS";
    private static final String SEARCH_MASK = "%%%s%%";

    BusLineRemoteService adapter;

    public BusLineServiceAdapter() {
        createRestService();
    }

    private void createRestService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.appglu.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(createInterceptorForHeader())
                .setConverter(createCustomGsonConverter()).build();
        adapter = restAdapter.create(BusLineRemoteService.class);
    }

    private RequestInterceptor createInterceptorForHeader(){
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            public void intercept(RequestFacade request) {
                request.addHeader("X-AppGlu-Environment", "staging");
                request.addHeader("Content-Type", "application/json");
                request.addHeader("Authorization", "Basic V0tENE43WU1BMXVpTThWOkR0ZFR0ek1MUWxBMGhrMkMxWWk1cEx5VklsQVE2OA==");
            }
        };
        return requestInterceptor;
    }

    private GsonConverter createCustomGsonConverter() {
        Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
        return new GsonConverter(gson);
    }

    public List<BusLine> getBusLine(String streetName) {
        BodyParameters params = new BodyParameters().putParam("stopName", String.format(SEARCH_MASK, streetName));
        return adapter.getBusLine(params).getRows();
    }

    public List<BusStop> getBusStops(Integer routeId) {
        BodyParameters params = new BodyParameters().putParam("routeId", routeId);
        return adapter.findStopsByRouteId(params).getRows();
    }

    public List<LineDeparture> getLineDepartures(Integer routeId){
        BodyParameters params = new BodyParameters().putParam("routeId", routeId);
        return adapter.findDeparturesByRouteId(params).getRows();
    }
}
