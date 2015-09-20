package com.mviniciuspimenta.marketshoppinglist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 15:44
 */
public class DBManager extends SQLiteOpenHelper {

    public static final int VERSION_DB = 1;
    public static final String NAME_DB = "marcket_app";

    private final String CREATE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS category (id_category INTEGER PRIMARY KEY, name TEXT);";
    private final String CREATE_STORE_TABLE = "CREATE TABLE IF NOT EXISTS store (id_store INTEGER PRIMARY KEY, name TEXT, latitude REAL, longitude REAL);";
    private final String CREATE_ITEM_TABLE = "CREATE TABLE IF NOT EXISTS item (id_item INTEGER PRIMARY KEY, name TEXT, quantity INTEGER, unit_price REAL, " +
            "id_category INTEGER, id_store INTEGER, foreign key (id_category) references category (id_category), foreign key (id_store) references store (id_store));";

    private final String INSERT_CATEGORY_1 = "insert into category (id_category, name) values (1, \"Alimentação\");";
    private final String INSERT_CATEGORY_2 = "insert into category (id_category, name) values (2, \"Saúde\");";
    private final String INSERT_CATEGORY_3 = "insert into category (id_category, name) values (3, \"Roupas\");";
    private final String INSERT_CATEGORY_4 = "insert into category (id_category, name) values (4, \"Telefone\");";

    private static DBManager instance = null;

    public static DBManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new DBManager(ctx.getApplicationContext());
        }

        return instance;
    }

    private DBManager(Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_STORE_TABLE);
        db.execSQL(CREATE_ITEM_TABLE);

        db.execSQL(INSERT_CATEGORY_1);
        db.execSQL(INSERT_CATEGORY_2);
        db.execSQL(INSERT_CATEGORY_3);
        db.execSQL(INSERT_CATEGORY_4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
