package com.example.apniteam.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.apniteam.model.PlayerModel;
import com.example.apniteam.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {

    private SQLManagerHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DataBaseManager(Context c) {
        context = c;
    }

    public DataBaseManager open() throws SQLException {
        dbHelper = new SQLManagerHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insertIntoPlayer(String name, String pid,String score,String isout,String userId,String status) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(SQLManagerHelper.PLAYER_ID, pid);
        contentValue.put(SQLManagerHelper.NAME, name);
        contentValue.put(SQLManagerHelper.SCORE, score);
        contentValue.put(SQLManagerHelper.IS_OUT, isout);
        contentValue.put(SQLManagerHelper.USER_ID, userId);
        contentValue.put(SQLManagerHelper.STATUS, status);
        database.insert(SQLManagerHelper.TABLE_NAME_PLAYER, null, contentValue);
    }

    public void insertIntoUser(String name, String mid) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(SQLManagerHelper.NAME, name);
        contentValue.put(SQLManagerHelper.MATCH_ID, mid);
        database.insert(SQLManagerHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetchUser() {
        String[] columns = new String[] { SQLManagerHelper._ID, SQLManagerHelper.NAME, SQLManagerHelper.MATCH_ID };
        Cursor cursor = database.query(SQLManagerHelper.TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
    }

    public Cursor fetchUser(String mid) {
        String[] columns = new String[] { SQLManagerHelper._ID, SQLManagerHelper.NAME, SQLManagerHelper.MATCH_ID };
        Cursor cursor = database.query(SQLManagerHelper.TABLE_NAME, columns, SQLManagerHelper.MATCH_ID + " = " + mid, null, null, null, null);
        return cursor;
    }

    public Cursor fetchPlayer() {
        String[] columns = new String[] { SQLManagerHelper._ID, SQLManagerHelper.USER_ID, SQLManagerHelper.NAME , SQLManagerHelper.IS_OUT,SQLManagerHelper.PLAYER_ID,SQLManagerHelper.SCORE};
        Cursor cursor = database.query(SQLManagerHelper.TABLE_NAME_PLAYER, columns, null, null, null, null, null);
        return cursor;
    }

    public List<PlayerModel> fetchPlayerList(int userId) {
        ArrayList<PlayerModel> pList = new ArrayList<>();
        String[] columns = new String[] { SQLManagerHelper._ID, SQLManagerHelper.USER_ID, SQLManagerHelper.NAME , SQLManagerHelper.IS_OUT,SQLManagerHelper.PLAYER_ID,SQLManagerHelper.SCORE,SQLManagerHelper.STATUS};
        Cursor cursor = database.query(SQLManagerHelper.TABLE_NAME_PLAYER, columns, SQLManagerHelper.USER_ID + "=" + userId, null, null, null, null);
        while (cursor.moveToNext())
        {
            PlayerModel player = new PlayerModel();
            player.setId(cursor.getInt(cursor.getColumnIndexOrThrow(SQLManagerHelper._ID)));
            player.setName(cursor.getString(cursor.getColumnIndexOrThrow(SQLManagerHelper.NAME)));
            player.setScore(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(SQLManagerHelper.SCORE))));
            player.setIsOut(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(SQLManagerHelper.IS_OUT))));
            player.setUserId(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(SQLManagerHelper.USER_ID))));
            player.setPlayerId(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(SQLManagerHelper.PLAYER_ID))));
            player.setStatus(cursor.getString(cursor.getColumnIndexOrThrow(SQLManagerHelper.STATUS)));
            System.out.println("player dtl::--->"+player.toString()) ; // get id
            pList.add(player);

        }
        return pList;
    }


    public int  fetchPlayerScoreByUser(int userId) {
        int score=0;
        String[] columns = new String[] { SQLManagerHelper._ID, SQLManagerHelper.USER_ID, SQLManagerHelper.NAME , SQLManagerHelper.IS_OUT,SQLManagerHelper.PLAYER_ID,SQLManagerHelper.SCORE};

        Cursor cursor = database.rawQuery("SELECT SUM(" + SQLManagerHelper.SCORE + ") as Total FROM " + SQLManagerHelper.TABLE_NAME_PLAYER+" where "+SQLManagerHelper.USER_ID+" = "+userId ,null);

       // Cursor cursor = database.query(SQLManagerHelper.TABLE_NAME_PLAYER, columns, userId+"", null, null, null, null);
        if (cursor.moveToNext())
        {
            score = cursor.getInt(cursor.getColumnIndex("Total"));
        }
        return score;
    }



    public int updatePlayerScore(int _id, String socre, String desc,String status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLManagerHelper.SCORE, socre);
        contentValues.put(SQLManagerHelper.IS_OUT, desc);
        contentValues.put(SQLManagerHelper.STATUS, status);
        int i = database.update(SQLManagerHelper.TABLE_NAME_PLAYER, contentValues, SQLManagerHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(SQLManagerHelper.TABLE_NAME, SQLManagerHelper._ID + "=" + _id, null);
    }
    public void deleteAllUser() {
        database.delete(SQLManagerHelper.TABLE_NAME, null,null);
    }
    public void deleteAllPlayer() {
        database.delete(SQLManagerHelper.TABLE_NAME_PLAYER, null,null);
    }

    public List<User> fetchUserList(String mid) {
        ArrayList<User> uList = new ArrayList<>();

        String[] columns = new String[] { SQLManagerHelper._ID, SQLManagerHelper.NAME, SQLManagerHelper.MATCH_ID };
        Cursor cursor = database.query(SQLManagerHelper.TABLE_NAME, columns, SQLManagerHelper.MATCH_ID + " = " + mid, null, null, null, null);
        while (cursor.moveToNext())
        {
            User userObj = new User();
            userObj.setId(cursor.getInt(cursor.getColumnIndexOrThrow(SQLManagerHelper._ID)));
            userObj.setName(cursor.getString(cursor.getColumnIndexOrThrow(SQLManagerHelper.NAME)));
            userObj.setMatchId(cursor.getString(cursor.getColumnIndexOrThrow(SQLManagerHelper.MATCH_ID)));
            System.out.println("user id::--->"+userObj.getId()) ; // get id
            System.out.println("user name ::--->"+userObj.getName()) ; // get id
            System.out.println("user match id ::--->"+userObj.getMatchId());
            uList.add(userObj);

        }
        return uList;
    }

}
