package com.example.charlesgao.activity.Database.Base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by CharlesGao on 15-07-06.
 * Function: This class should be Singleton as well.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static SQLiteDBConfig sqLiteDBConfig;
    private Context context;
    private static SQLiteHelper INSTANCE;

    public interface SQLiteDataTable{
        public void OnCreate(SQLiteDatabase database);
        public void OnUpgrade(SQLiteDatabase database);
    }

    public SQLiteHelper(Context context) {
        super(context, sqLiteDBConfig.getDatabaseName(), null, sqLiteDBConfig.getVersion());
        this.context = context;
    }

    public static SQLiteHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SQLiteHelper(context);
        }
        return INSTANCE;
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        ArrayList<String> arrayList = sqLiteDBConfig.getTables();
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
