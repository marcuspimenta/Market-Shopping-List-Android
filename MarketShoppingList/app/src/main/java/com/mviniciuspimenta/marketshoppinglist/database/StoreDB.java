package com.mviniciuspimenta.marketshoppinglist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mviniciuspimenta.marketshoppinglist.model.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 15:43
 */
public class StoreDB implements DBControler<Store> {

    private static Context context;
    private static StoreDB instance = null;

    private StoreDB(Context context) {
        this.context = context;
    }

    public static StoreDB getInstance(Context ctx) {
        if (instance == null) {
            instance = new StoreDB(ctx.getApplicationContext());
        }

        return instance;
    }

    @Override
    public void insert(Store store) {
        ContentValues values = new ContentValues();
        values.put(Store.COLUMN_NAME, store.getName());
        values.put(Store.COLUMN_LAT, store.getLatitude());
        values.put(Store.COLUMN_LONG, store.getLongitude());

        DBManager.getInstance(context).getWritableDatabase().insert(Store.TABLE_NAME, "", values);
    }

    @Override
    public void delete(Store store) {
        DBManager.getInstance(context).getWritableDatabase().delete(Store.TABLE_NAME, Store.COLUMN_ID + "=?", new String[]{String.valueOf(store.getId())});
    }

    @Override
    public void update(Store store) {

    }

    @Override
    public List<Store> selectAll() {
        List<Store> stores = new ArrayList<Store>();

        Cursor cursor = DBManager.getInstance(context).getWritableDatabase().query(Store.TABLE_NAME, new String[]{Store.COLUMN_ID, Store.COLUMN_NAME, Store.COLUMN_LAT, Store.COLUMN_LONG}, null, null, null, null, null, null);

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();
            for (int x = 0; x < cursor.getCount(); x++) {
                stores.add(new Store(cursor.getInt(0), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3)));
                cursor.moveToNext();
            }
        }

        cursor.close();

        return stores;
    }

    @Override
    public void deleteAll() {
        DBManager.getInstance(context).getWritableDatabase().execSQL("DELETE FROM " + Store.TABLE_NAME + ";");
    }
}
