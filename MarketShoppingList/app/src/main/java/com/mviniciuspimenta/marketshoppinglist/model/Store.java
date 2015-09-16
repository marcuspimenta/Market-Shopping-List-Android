package com.mviniciuspimenta.marketshoppinglist.model;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 15:34
 */
public class Store {

    private String name;
    private Double lat;
    private Double longitude;

    public Store(String name, Double lat, Double longitude) {
        this.name = name;
        this.lat = lat;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
