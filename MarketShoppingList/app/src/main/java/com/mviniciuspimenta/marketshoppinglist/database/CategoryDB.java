package com.mviniciuspimenta.marketshoppinglist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mviniciuspimenta.marketshoppinglist.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 15:42
 */
public class CategoryDB implements DBControler<Category>{

    private static Context context;
    private static CategoryDB instance = null;

    private CategoryDB(Context context) {
        this.context = context;
    }

    public static CategoryDB getInstance(Context ctx) {
        if (instance == null) {
            instance = new CategoryDB(ctx.getApplicationContext());
        }

        return instance;
    }

    @Override
    public void insert(Category category) {
        ContentValues values = new ContentValues();
        values.put(Category.COLUMN_NAME, category.getName());

        DBManager.getInstance(context).getWritableDatabase().insert(Category.TABLE_NAME, "", values);
    }

    @Override
    public void delete(Category category) {
        DBManager.getInstance(context).getWritableDatabase().delete(Category.TABLE_NAME, Category.COLUMN_ID + "=?", new String[]{String.valueOf(category.getId())});
    }

    @Override
    public void update(Category category) {
        ContentValues values = new ContentValues();
        values.put(Category.COLUMN_NAME, category.getName());

        DBManager.getInstance(context).getWritableDatabase().update(Category.TABLE_NAME, values, Category.COLUMN_ID + "=?", new String[]{String.valueOf(category.getId())});
    }

    @Override
    public List<Category> selectAll(){
        List<Category> categories = new ArrayList<Category>();

        Cursor cursor = DBManager.getInstance(context).getWritableDatabase().query(Category.TABLE_NAME, new String[]{Category.COLUMN_ID, Category.COLUMN_NAME}, null, null, null, null, null, null);

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();
            for (int x = 0; x < cursor.getCount(); x++) {
                categories.add(new Category(cursor.getInt(0), cursor.getString(1)));
                cursor.moveToNext();
            }
        }

        cursor.close();

        return categories;
    }

    @Override
    public void deleteAll() {
        DBManager.getInstance(context).getWritableDatabase().execSQL("DELETE FROM " + Category.TABLE_NAME + ";");
    }
}
