package com.gpds.ukelele.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Haritz on 04/11/2015.
 */
public class DBManager {

    private DBContext dbContext = null;

    public DBManager(Context context){
        this.dbContext = new DBContext(context);
    }

    /**
     * Creates and saves a user in the database
     * @param user
     */
    public void createUser(User user){
        SQLiteDatabase db = dbContext.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", user.getUsername());
        values.put("password", user.getPassword());

        db.insert(DBContext.USERS_TABLE, null, values);
        db.close();
    }

    /**
     * Given an example user with its username, by query for example, return the user the database user information
     * @param userMock A user with its username
     * @return The username and password if exists, or null in other cases
     */
    public User retrieveUser(User userMock){
        // Get a db reader
        SQLiteDatabase db = this.dbContext.getReadableDatabase();
        // Create and execute query
        Cursor cursor = db.query(
                DBContext.USERS_TABLE,
                new String[]{"username", "password"},
                "username LIKE ?",
                new String[]{userMock.getUsername()},
                null,
                null,
                "username DESC"
        );
        // Move to the first result the cursor if exists
        if(cursor==null || cursor.getCount()<=0){
            return null;
        }
        cursor.moveToFirst();
        // Retrieve username and password
        String username;
        String password;
        try{
            username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
            password = cursor.getString(cursor.getColumnIndexOrThrow("password"));
        } catch(IllegalArgumentException e){
            cursor.close();
            db.close();
            return null;
        }
        cursor.close();
        db.close();
        // Return the user
        return new User(username, password);
    }

}
