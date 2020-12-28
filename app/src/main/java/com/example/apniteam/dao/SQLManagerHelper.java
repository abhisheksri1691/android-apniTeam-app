package com.example.apniteam.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLManagerHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Match.db";
    // Table Name
    public static final String TABLE_NAME = "USER";
    public static final String TABLE_NAME_PLAYER = "PLAYER";

    // Table columns
    public static final String _ID = "id";
    public static final String NAME = "name";
    public static final String MATCH_ID = "matchId";
    public static final String USER_ID = "userId";
    public static final String PLAYER_ID = "playerId";
    public static final String SCORE = "score";
    public static final String IS_OUT = "isOut";
    public static final String STATUS = "status";
    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " + MATCH_ID + " INTEGER);";

    private static final String CREATE_TABLE_PLAYER = "create table " + TABLE_NAME_PLAYER + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_ID + " INTEGER, " + NAME + " TEXT NOT NULL, " + PLAYER_ID + " INTEGER, " + SCORE + " INTEGER DEFAULT 0, " + IS_OUT + " INTEGER DEFAULT 0, "+ STATUS + " TEXT NOT NULL );";
    public SQLManagerHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println(" DATABASE TBLE ON CREATE CALL");
        db.execSQL(CREATE_TABLE); // create user table
        db.execSQL(CREATE_TABLE_PLAYER); // create player table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
