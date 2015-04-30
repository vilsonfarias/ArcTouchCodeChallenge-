package com.example.user01.myapplication.model.pojo;

public class BusStop {
    Integer id;
    Integer routeId;
    String name;
    String sequence;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append("id: ").append(id).append(" | ");
        b.append("routeId: ").append(routeId).append(" | ");
        b.append("name: ").append(name).append(" | ");
        b.append("sequence: ").append(sequence);

        return b.toString();
    }

}
