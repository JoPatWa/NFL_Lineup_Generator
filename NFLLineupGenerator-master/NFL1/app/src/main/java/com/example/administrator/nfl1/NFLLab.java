package com.example.administrator.nfl1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jw76577 on 6/8/2016.
 */
public class NFLLab {

    private static NFLLab sNFLLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static NFLLab get(Context context) {
        if(sNFLLab == null) {
            sNFLLab = new NFLLab(context);
        }
        return sNFLLab;
    }

    private  NFLLab(Context context) {
        mContext = context.getApplicationContext();
       mDatabase = new NFLDbHelper(mContext)
               .getWritableDatabase();
    }

    public void addPlayer(NFLPlayer player) {
        ContentValues values = getContentValues(player);

        mDatabase.insert(NFLDbSchema.NFLTable.NAME, null, values);

    }

    public NFLPlayer getPlayer(UUID id) {
        return null;
    }

    public void updatePlayer(NFLPlayer player) {
        String uuidString = player.getID().toString();
        ContentValues values = getContentValues(player);

        mDatabase.update(NFLDbSchema.NFLTable.NAME, values,
                NFLDbSchema.NFLTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    private static ContentValues getContentValues(NFLPlayer player) {
        ContentValues values = new ContentValues();
      //  values.put(NFLDbSchema.NFLTable.Cols.UUID, player.getID().toString());
        values.put(NFLDbSchema.NFLTable.Cols.FULLNAME, player.getName()+"");
        values.put(NFLDbSchema.NFLTable.Cols.POS, player.getPos()+"");
        values.put(NFLDbSchema.NFLTable.Cols.TEAM, player.getTeam()+"");
        values.put(NFLDbSchema.NFLTable.Cols.PFP, player.getPFP()+"");
        values.put(NFLDbSchema.NFLTable.Cols.AVERAGEFP, player.getAVG()+"");
        values.put(NFLDbSchema.NFLTable.Cols.MINFP, player.getMINFP()+"");
        values.put(NFLDbSchema.NFLTable.Cols.MAXFP, player.getMAXFP()+"");
        values.put(NFLDbSchema.NFLTable.Cols.ACTUALFP, player.getAFP()+"");
        values.put(NFLDbSchema.NFLTable.Cols.SALARY, player.getSalary()+"");

        return values;
    }

    private NFLCursorWrapper queryPlayers(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                NFLDbSchema.NFLTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );

        return new NFLCursorWrapper(cursor);
    }

    public List<NFLPlayer> getPlayers() {


        List<NFLPlayer> players =  new ArrayList<>();

        NFLCursorWrapper cursor = queryPlayers(null, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            players.add(cursor.getPlayer());
            cursor.moveToNext();
        }

        cursor.close();
        return players;
    }



}
