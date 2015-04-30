package com.example.user01.myapplication.model.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class BusLineService {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'+'SSS";

    BusLineRemoteService adapter;

    public BusLineService() {
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

    public BusLineRemoteService getService() {
        return adapter;
    }
}
