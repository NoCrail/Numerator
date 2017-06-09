package com.home.nocrail.numerator;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.id;
import static com.home.nocrail.numerator.MainActivity.color;
import static com.home.nocrail.numerator.MainActivity.hide;


public class Game extends AppCompatActivity {

    public int a = 1;
    public long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final Button btn[] = {(Button)findViewById(R.id.but1), (Button)findViewById(R.id.but2),
                (Button)findViewById(R.id.but3), (Button)findViewById(R.id.but4),
                (Button)findViewById(R.id.but5), (Button)findViewById(R.id.but6),
                (Button)findViewById(R.id.but7), (Button)findViewById(R.id.but8),
                (Button)findViewById(R.id.but9), (Button)findViewById(R.id.but10),
                (Button)findViewById(R.id.but11), (Button)findViewById(R.id.but12),
                (Button)findViewById(R.id.but13), (Button)findViewById(R.id.but14),
                (Button)findViewById(R.id.but15), (Button)findViewById(R.id.but16),
                (Button)findViewById(R.id.but18), (Button)findViewById(R.id.but19),
                (Button)findViewById(R.id.but20), (Button)findViewById(R.id.but21),
                (Button)findViewById(R.id.but22), (Button)findViewById(R.id.but23),
                (Button)findViewById(R.id.but24), (Button)findViewById(R.id.but25),
                (Button)findViewById(R.id.but26), (Button)findViewById(R.id.but27),
                (Button)findViewById(R.id.but28), (Button)findViewById(R.id.but29),
                (Button)findViewById(R.id.but30), (Button)findViewById(R.id.but31),
                (Button)findViewById(R.id.but32), (Button)findViewById(R.id.but33),
                (Button)findViewById(R.id.but34), (Button)findViewById(R.id.but35),
                (Button)findViewById(R.id.but36), (Button)findViewById(R.id.but37),
                (Button)findViewById(R.id.but38), (Button)findViewById(R.id.but39),
                (Button)findViewById(R.id.but40), (Button)findViewById(R.id.but41),
        };

        final Chronometer chrono = (Chronometer)findViewById(R.id.chrono);

        chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapsedMillis = SystemClock.elapsedRealtime()-chrono.getBase();
                time = elapsedMillis/1000;
            }
        });
        chrono.start();


        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ili = ((Button) v).getText().toString();
                if(Integer.parseInt(ili)==a){
                    if(hide){
                        v.setVisibility(View.INVISIBLE);
                    } else {
                        v.setEnabled(false);
                    }

                    a++;
                }

                if(a>30){
                    chrono.stop();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                    builder.setTitle(R.string.end);

                    builder.setMessage(String.valueOf(time));
                    builder.setCancelable(false);
                    builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        };



       Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = 30;
            }
        });


        ArrayList<Byte> kek = new ArrayList<>();
        for(Byte i = 1; i<=btn.length; i++){
            kek.add(i-1, i);

        };
        for(Byte i = 0; i<btn.length; i++){
            btn[i].setOnClickListener(click);
        };
        Random rand = new Random();
        for(Byte i = 0; i<btn.length; i++){
            if (color){
                btn[i].setTextColor(Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            }
            int r = rand.nextInt(kek.size());
            btn[i].setText(String.valueOf(kek.get(r)));
            kek.remove(r);
        }







    }



}

