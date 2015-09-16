package com.mviniciuspimenta.marketshoppinglist.model;

import java.util.Date;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 15:40
 */
public class Item {

    private String name;
    private int quantity;
    private float unitPrice;
    private Date date;
    private Store store;
    private Category category;

    public Item(String name, int quantity, float unitPrice, Date date, Store store, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.date = date;
        this.store = store;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
