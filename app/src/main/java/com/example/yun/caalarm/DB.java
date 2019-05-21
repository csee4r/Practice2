package com.example.yun.caalarm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DB {
    static int id = -1;

    public static void createDb(Context context) {
        // DB 생성
        SQLiteDatabase db = null;
        if (db == null) {
            db = context.openOrCreateDatabase("sqlist_test.db", Context.MODE_PRIVATE, null);
        }

        db.execSQL("CREATE TABLE IF NOT EXISTS subject("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title TEXT not null,"
                + "professor TEXT not null,"
                + "place TEXT not null,"
                + "isAlarm INTEGER not null,"
                + "startTime INTEGER not null,"
                + "day INTEGER not null,"
                + "period INTEGER not null,"
                + "red INTEGER not null,"
                + "green INTEGER not null,"
                + "blue INTEGER not null" + ");"
        );

        db.close();
    }

    /*** 데이터 읽어오기 **/
    public static void selectDb(Context context){
        SQLiteDatabase db = null;
        if (db == null) {
            db = context.openOrCreateDatabase("sqlist_test.db", Context.MODE_PRIVATE, null);
        }

        //검색
        Cursor c = db.rawQuery("SELECT * FROM subject", null);
        Log.d("DB", "count : " + c.getCount());
        c.moveToFirst();

        while(c.isAfterLast() == false){
            Log.d("DB","id: " + c.getString(0) + "title: " + c.getString(1) + " professor: " + c.getString(2) + " place: " + c.getString(3) + " isAlarm: " + c.getString(4)+ " startTime: " + c.getString(5)+ " day: " + c.getString(6)+ " period: " + c.getString(7)+ " red: " + c.getString(8)+ " green: " + c.getString(9)+ " blue: " + c.getString(10));
            c.moveToNext();
        }

        c.close();
        db.close();
    }

    /**데이터 추가**/
    public static void insertDb(Context context, String title, String professor, String place, int isAlarm, int startTime, int day, int period, int red, int green, int blue){
        SQLiteDatabase db = null;
        if (db == null) {
            db = context.openOrCreateDatabase("sqlist_test.db", Context.MODE_PRIVATE, null);
        }

        String sql = "INSERT INTO subject (title, professor, place, isAlarm, startTime, day, period, red, green, blue) VALUES ('" + title + "', '" + professor + "', '" + place + "', '" + isAlarm + "', '" + startTime + "', '" + day + "', '" + period + "', '" + red + "', '" + green + "', '" + blue + "')";

        db.execSQL(sql);
        db.close();
    }

    /**데이터 삭제**/
    public static void deleteDb(Context context){
        SQLiteDatabase db = null;
        if (db == null) {
            db = context.openOrCreateDatabase("sqlist_test.db", Context.MODE_PRIVATE, null);
        }

        String sql = "DELETE FROM subject WHERE _id = 1";

        db.execSQL(sql);
        db.close();
    }

    /**데이터 수정**/
    public static void update(Context context, String title, String professor, String place, int isAlarm, int startTime, int day, int period, int red, int green, int blue){
        SQLiteDatabase db = null;
        if (db == null) {
            db = context.openOrCreateDatabase("sqlist_test.db", Context.MODE_PRIVATE, null);
        }

        String sql = "UPDATE subject SET  title = '" + title + "', professor = '" + professor + "', place = '" + place + "', isAlarm = '" + isAlarm + "', startTime = '" + startTime + "', day = '" + day + "', period = '" + period + "', red = '" + red + "', green = '" + green + "', blue = '" + blue;

        db.execSQL(sql);
        db.close();
    }

}
