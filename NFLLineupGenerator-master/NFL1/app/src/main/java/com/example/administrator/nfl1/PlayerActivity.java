package com.example.administrator.nfl1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jw76577 on 6/11/2016.
 */
public class PlayerActivity extends Activity {

    NFLPlayer player;
    NFLLab nflLab;
    List<NFLPlayer> p;
    TableLayout table;
    List<NFLPlayer> selectedPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.player_activity);
        table = (TableLayout) findViewById(R.id.table);
        nflLab = NFLLab.get(this);
        p = nflLab.getPlayers();
        selectedPlayer();
        table();


    }


    public void table() {

        String position[]={"QB","RB","WR","TE","K"};

        for (int j = 0; j < 5; j++)
        {
            for (int i = 0; i < selectedPlayer.size(); i++) {

                if (selectedPlayer.get(i).getPos().equals(position[j]))
                {
                TableRow row1 = new TableRow(this);
                row1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                TextView tv11 = new TextView(this);
                tv11.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv12 = new TextView(this);
                tv12.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv13 = new TextView(this);
                tv13.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv14 = new TextView(this);
                tv14.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv15 = new TextView(this);
                tv15.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv16 = new TextView(this);
                tv16.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv17 = new TextView(this);
                tv17.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv18 = new TextView(this);
                tv18.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv19 = new TextView(this);
                tv19.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));


                tv11.setPadding(5, 5, 5, 5);
                tv12.setPadding(5, 5, 5, 5);
                tv13.setPadding(5, 5, 5, 5);
                tv14.setPadding(5, 5, 5, 5);
                tv15.setPadding(5, 5, 5, 5);
                tv16.setPadding(5, 5, 5, 5);
                tv17.setPadding(5, 5, 5, 5);
                tv18.setPadding(5, 5, 5, 5);
                tv19.setPadding(5, 5, 5, 5);


                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);

                String avg = df.format(selectedPlayer.get(i).getAVG());
                tv11.setText(selectedPlayer.get(i).getName() + "");
                tv12.setText(selectedPlayer.get(i).getTeam() + "");
                tv13.setText(selectedPlayer.get(i).getPos() + "");
                tv14.setText(selectedPlayer.get(i).getAFP() + "");
                tv15.setText(avg);

                tv18.setText(selectedPlayer.get(i).getPFP() + "");
                tv19.setText(selectedPlayer.get(i).getSalary() + "");

                row1.addView(tv11);
                row1.addView(tv12);
                row1.addView(tv13);
                row1.addView(tv14);
                row1.addView(tv15);

                row1.addView(tv18);
                row1.addView(tv19);


                table.addView(row1);
            }}
        }

    }




    public void selectedPlayer()
    {
         selectedPlayer=new ArrayList<NFLPlayer>();

        int qb=0;
        int rb=0;
        int wr=0;
        int te=0;
        int k=0;
        int a=0;
        int sum=0;
        Random r=new Random();
        if(p.size()>0) {
             a = r.nextInt(p.size());
        }

        while(wr<3|rb<2|te<1|k<1|qb<1)
        {
            if(p.get(a).getPos().equals("RB")&&rb<2) {

                sum=sum+p.get(a).getSalary();
                if(sum<60000) {
                    rb++;
                    selectedPlayer.add(p.get(a));
                }
            }
            if(p.get(a).getPos().equals("WR")&&wr<3) {
                sum=sum+p.get(a).getSalary();
                if(sum<60000) {


                    wr++;
                    selectedPlayer.add(p.get(a));
                }
            }
            if(p.get(a).getPos().equals("TE")&&te<1) {
                sum=sum+p.get(a).getSalary();
                if(sum<60000) {
                    te++;
                    selectedPlayer.add(p.get(a));
                }
            }
            if(p.get(a).getPos().equals("K")&&k<1) {
                sum=sum+p.get(a).getSalary();
                if(sum<60000) {
                    k++;
                    selectedPlayer.add(p.get(a));
                }
            }
            if(p.get(a).getPos().equals("QB")&&qb<1) {
                sum=sum+p.get(a).getSalary();
                if(sum<60000) {
                    selectedPlayer.add(p.get(a));
                    qb++;
                }
            }
            a=r.nextInt(p.size());
        }


    }


}
