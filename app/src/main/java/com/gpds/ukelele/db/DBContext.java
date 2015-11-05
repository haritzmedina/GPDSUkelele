package com.gpds.ukelele.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Haritz on 04/11/2015.
 */
public class DBContext extends SQLiteOpenHelper {

    private static String DATABASE_FILE_NAME = "users.db";
    private static int DATABASE_VERSION = 1;

    public static String USERS_TABLE = "users";
    public static String TRACE_TABLE = "trace";

    public DBContext(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create users table
        db.execSQL("CREATE TABLE "+USERS_TABLE+" (" +
                "username TEXT PRIMARY KEY," +
                "password TEXT)"
        );
        // Acciones del usuario por menu
        db.execSQL("CREATE TABLE "+TRACE_TABLE+" (" +
                "traceID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "username TEXT," +
                "menu TEXT," +
                "menutime INTEGER,"
        );
    }
    //Desde menu-clicks en orden
    //Tendra el formato "nombredeMenu"+"numero de clicks"
    //Tendra el formato "nombredeMenu"+"tiempo en ese menu"
    //Tiempo que el usuario ha estado logeado en total
    //Tiempo que el usuario ha invertido en la última sesión
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DELETE TABLE IF EXISTS "+USERS_TABLE);
        db.execSQL("DELETE TABLE IF EXISTS "+TRACE_TABLE);
        onCreate(db);
    }
}
