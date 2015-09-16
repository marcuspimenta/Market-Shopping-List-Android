package com.mviniciuspimenta.marketshoppinglist.model;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 15:21
 */
public class Category {

    public static final String TABLE_NAME = "category";
    public static final String COLUMN_ID = "id_category";
    public static final String COLUMN_NAME = "name";

    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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
}

