package com.home.nocrail.numerator;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by nocrail on 09.06.17.
 */

public class Dbhelper extends SQLiteOpenHelper {
    private static final String LOG_TAG = "my_tag";

    public static final String TABLE_NAME = "Records";

    public static final String KEY_TIME = "time";
    public static final String KEY_NAME = "name";
    public static final String KEY_LINES = "lines";


    private static final String DATABASE_NAME = "StatisticRec";
    private static final int DATABASE_VERSION = 1;

    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME +" ("
                + KEY_TIME + "integer"
                + KEY_NAME + " text,"+ KEY_LINES + "integer");


        ContentValues cv = new ContentValues();

        cv.put(KEY_TIME, 10);
        cv.put(KEY_NAME, "Владислав");
        cv.put(KEY_LINES, 1);
    };



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    };
}
