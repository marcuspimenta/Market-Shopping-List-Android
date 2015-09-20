package com.mviniciuspimenta.marketshoppinglist.model;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 15:34
 */
public class Store {

    public static final String TABLE_NAME = "store";
    public static final String COLUMN_ID = "id_store";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LAT = "latitude";
    public static final String COLUMN_LONG = "longitude";

    private int id;
    private String name;
    private Double latitude;
    private Double longitude;

    public Store(int id, String name, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
