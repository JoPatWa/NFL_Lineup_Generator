package com.example.administrator.nfl1;

/**
 * Created by jw76577 on 6/10/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;

public class NFLActivity extends AppCompatActivity implements android.view.View.OnClickListener,Serializable
{

    private Button mGenerateButton;
    private ProgressBar  mProgressBar;
    NFLPlayer player;
    NFLLab nflLab;
    TableLayout table;
    SharedPreferences pref;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfl);
        pref = getApplicationContext().getSharedPreferences("NFL", MODE_PRIVATE);
        editor = pref.edit();
        mGenerateButton = (Button) findViewById(R.id.generate_button);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        table = (TableLayout) findViewById(R.id.table);
        mGenerateButton.setOnClickListener(this);

        if(!isInsertedToDB()) {

            mGenerateButton.setVisibility(View.INVISIBLE);
            new MakingDatabse().execute();
        }

    }

    @Override
    public void onClick(View v) {

        Intent i=new Intent(this,PlayerActivity.class);

         startActivity(i);

    }




    class MakingDatabse extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);

        }


        @Override
        protected String doInBackground(String... pra) {
            readCVS();
            return null;
        }


        @Override
        protected void onPostExecute(String file_url) {

            mProgressBar.setVisibility(View.GONE);
            mGenerateButton.setVisibility(View.VISIBLE);
            setInsertedToDB();


        }
    }


    private void readCVS() {

        BufferedReader reader = null;
        nflLab = NFLLab.get(this);


        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("cheatsheet.csv"), "UTF-8"));

            String line = "";
            while ((line = reader.readLine()) != null) {

                String[] str = line.split(",");
                String mName = str[3];
                String mPos = str[2];
                String mTeam = str[1];
                String mAFP = str[4];
                String mPFP = str[5];
                String mMINFP = str[10];
                String mMAXFP = str[11];
                String mAVG = str[12];
                String mSalary = str[16];

                if (!mName.equals("full_name")) {
                    player = new NFLPlayer(mName, mPos, mTeam, Double.parseDouble(mAFP), Double.parseDouble(mPFP), Double.parseDouble(mMINFP), Double.parseDouble(mMAXFP), Double.parseDouble(mAVG), Integer.parseInt(mSalary));
                  
                    nflLab.addPlayer(player);
                }
            }

        } catch (Exception e) {

        }


    }

    public void setInsertedToDB(){

        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("insert", true);
        editor.commit();
    }

    public boolean isInsertedToDB(){

       return pref.getBoolean("insert", false);

    }

}