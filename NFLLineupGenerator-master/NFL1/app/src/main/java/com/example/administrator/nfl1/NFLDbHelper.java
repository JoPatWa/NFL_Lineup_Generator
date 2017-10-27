package com.example.administrator.nfl1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jw76577 on 6/8/2016.
 */
public class NFLDbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "nfl.db";

    public NFLDbHelper(Context context)
    {
        super(context,DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {






        String query="create table IF NOT EXISTS  " + NFLDbSchema.NFLTable.NAME + "(" +
                " _id integer primary key autoincrement,  " +
                NFLDbSchema.NFLTable.Cols.FULLNAME + " TEXT, " +
                NFLDbSchema.NFLTable.Cols.POS + " TEXT, " +
                NFLDbSchema.NFLTable.Cols.TEAM + " TEXT, " +
                NFLDbSchema.NFLTable.Cols.PFP + " TEXT, " +
                NFLDbSchema.NFLTable.Cols.AVERAGEFP + " TEXT, " +
                NFLDbSchema.NFLTable.Cols.SALARY + " TEXT, " +
                NFLDbSchema.NFLTable.Cols.MINFP + " TEXT, " +
                NFLDbSchema.NFLTable.Cols.ACTUALFP + " TEXT, " +
                NFLDbSchema.NFLTable.Cols.MAXFP+ " TEXT "+");";

       db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+NFLDbSchema.NFLTable.NAME);
                onCreate(db);
    }




}
