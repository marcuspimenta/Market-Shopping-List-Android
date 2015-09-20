package com.mviniciuspimenta.marketshoppinglist.database;

import android.content.Context;

import com.mviniciuspimenta.marketshoppinglist.model.Item;

import java.util.List;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 15:42
 */
public class ItemDB implements DBControler<Item>{

    private static Context context;
    private static ItemDB instance = null;

    private ItemDB(Context context) {
        this.context = context;
    }

    public static ItemDB getInstance(Context ctx) {
        if (instance == null) {
            instance = new ItemDB(ctx.getApplicationContext());
        }

        return instance;
    }

    @Override
    public void insert(Item item) {

    }

    @Override
    public void delete(Item item) {

    }

    @Override
    public void update(Item item) {

    }

    @Override
    public List<Item> selectAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
