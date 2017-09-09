package com.example.nathaniel.myfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int mStrikesCount, mBallsCount, mOutsCount;
    private static final String BALL_INDEX = "ball_index";
    private static final String STRIKE_INDEX = "strike_index";
    private static final String OUT_INDEX = "out_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button mResetButton;
        Button mAboutButton;
        Button mBallsButton;
        Button mStrikesButton;

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAboutButton = (Button) findViewById(R.id.menu_about_button);
       /* mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });
        */

        if (savedInstanceState != null) {
            mBallsCount = savedInstanceState.getInt(BALL_INDEX);
            mStrikesCount = savedInstanceState.getInt(STRIKE_INDEX);
            mOutsCount = savedInstanceState.getInt(OUT_INDEX);
            TextView Ballid = (TextView)findViewById(R.id.Ballid);
            Ballid.setText(String.valueOf(mStrikesCount));
            TextView Strikeid = (TextView)findViewById(R.id.Strikeid);
            Strikeid.setText(String.valueOf(mBallsCount));
            TextView OutsId = (TextView) findViewById(R.id.Out_Count);
            OutsId.setText(String.valueOf(mOutsCount));
        }

      /*  mResetButton = (Button) findViewById(R.id.menu_reset_button);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrikeCount(1);
                BallCount(1);

            }
        }); */

       //setDialogs();
        mBallsButton = (Button) findViewById(R.id.Balls);
        mBallsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BallCount(0);
                if (mBallsCount >= 4) {
                    WalkDialog().show();
                    StrikeCount(1);
                    BallCount(1);
                }
            }
        });
        mStrikesButton = (Button) findViewById(R.id.Strikes);
        mStrikesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrikeCount(0);
                if (mStrikesCount >= 3) {
                    OutDialog().show();
                    StrikeCount(1);
                    BallCount(1);
                    OutCount(0);
                }
            }
        });


    }

    public AlertDialog WalkDialog() {
        AlertDialog.Builder WalkDialog = new AlertDialog.Builder(MainActivity.this);
        WalkDialog.setMessage(R.string.Walk);
        WalkDialog.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicks OK
            }
        });
        return WalkDialog.create();
    }

    public AlertDialog OutDialog() {
        AlertDialog.Builder OutDialog = new AlertDialog.Builder(MainActivity.this);
        OutDialog.setMessage(R.string.Out);
        OutDialog.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicks OK
            }
        });
        return OutDialog.create();
    }

    /*
    Parameters: int
    Note: if val == 0, then count increments by 1, else count is reset to 0.
     */
    public void BallCount(int val) {
        if (val == 0)
        {
            mBallsCount++;
        }
        else{
            mBallsCount = 0;
        }
        TextView Strikeid = (TextView)findViewById(R.id.Strikeid);
        Strikeid.setText(String.valueOf(mBallsCount));
    }

    public void OutCount(int val) {
        if (val == 0) {
            mOutsCount++;
        }
        else {
            mOutsCount = 0;
        }
        TextView OutsId = (TextView) findViewById(R.id.Out_Count);
        OutsId.setText(String.valueOf(mOutsCount));
    }

    /*
    Parameters: int val
    Note: if val == 0, then count increments by 1, else count is reset to 0.
     */
    public void StrikeCount(int val) {
        if (val == 0)
        {
            mStrikesCount++;
        }
        else{
            mStrikesCount = 0;
        }
        TextView Ballid = (TextView)findViewById(R.id.Ballid);
        Ballid.setText(String.valueOf(mStrikesCount));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(BALL_INDEX, mBallsCount);
        savedInstanceState.putInt(STRIKE_INDEX, mStrikesCount);
        savedInstanceState.putInt(OUT_INDEX, mOutsCount);
    }

}
