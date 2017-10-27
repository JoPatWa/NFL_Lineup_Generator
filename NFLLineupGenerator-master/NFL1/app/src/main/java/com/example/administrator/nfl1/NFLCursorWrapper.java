package com.example.administrator.nfl1;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by jw76577 on 6/9/2016.
 */
public class NFLCursorWrapper extends CursorWrapper {

    public NFLCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public NFLPlayer getPlayer() {
      //  String uuidString = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.UUID));
        String name = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.FULLNAME));
        String position = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.POS));
        String team = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.TEAM));
        String projectedFP = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.PFP));
        String averageFP = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.AVERAGEFP));
        String minFP = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.MINFP));
        String maxFP = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.MAXFP));
        String actualFP = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.ACTUALFP));
        String salary = getString(getColumnIndex(NFLDbSchema.NFLTable.Cols.SALARY));


        NFLPlayer player=null;

 player = new NFLPlayer(name, position, team, Double.parseDouble(actualFP), Double.parseDouble(projectedFP), Double.parseDouble(minFP), Double.parseDouble(maxFP), Double.parseDouble(averageFP), Integer.parseInt(salary));



        return player;


    }
}
