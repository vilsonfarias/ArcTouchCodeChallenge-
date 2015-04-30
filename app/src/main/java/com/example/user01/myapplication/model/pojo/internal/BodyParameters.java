package com.example.user01.myapplication.model.pojo.internal;

import java.util.HashMap;
import java.util.Map;

public class BodyParameters {

    public BodyParameters putParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    public BodyParameters putParam(String key, Integer value) {
        params.put(key, value.toString());
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    private Map<String, String> params = new HashMap<String, String>();
}