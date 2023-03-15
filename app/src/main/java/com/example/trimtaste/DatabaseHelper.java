package com.example.trimtaste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{
    final static String DATABASE_NAME = "FoodData.db";
    final static int DATABASE_VERSION = 1;

    final static String TABLE1_NAME ="Customer_Table";
    final static String T1COL_1 = "CustomerId";
    final static String T1COL_2 = "Address";
    final static String T1COL_3 = "Email";
    final static String T1COL_4 = "phoneNumber";
    final static String T1COL_5 = "Username";
    final static String T1COL_6 = "Password";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creating Customer Table
        String query = "CREATE TABLE " + TABLE1_NAME + "(" + T1COL_1 +
                " INTEGER PRIMARY KEY, " + T1COL_2 + " TEXT, " + T1COL_3 + " TEXT," +
                T1COL_4 + " TEXT, " + T1COL_5 + " TEXT," + T1COL_6 + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addData(String address, String email, String phoneNum,
                           String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_2, address);
        values.put(T1COL_3, email);
        values.put(T1COL_4, phoneNum);
        values.put(T1COL_5, username);
        values.put(T1COL_6, password);

        long l = sqLiteDatabase.insert(TABLE1_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;

    }
}
