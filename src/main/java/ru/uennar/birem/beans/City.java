package ru.uennar.birem.beans;

import java.util.Map;

public class City {
    private Map<String, String> city;

    public City(Map<String, String> city) {
        this.city = city;
    }

    public Map<String, String> getCity() {
        return city;
    }

    public void setCity(Map<String, String> city) {
        this.city = city;
    }
}
