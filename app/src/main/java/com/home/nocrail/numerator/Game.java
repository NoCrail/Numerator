package com.home.nocrail.numerator;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.colorBackground;
import static android.R.attr.contextClickable;
import static android.R.attr.id;
import static android.R.attr.prompt;
import static com.home.nocrail.numerator.MainActivity.color;
import static com.home.nocrail.numerator.MainActivity.hide;
import static com.home.nocrail.numerator.MainActivity.lines;
import static com.home.nocrail.numerator.MainActivity.hint;
import static com.home.nocrail.numerator.MainActivity.htime;


public class Game extends AppCompatActivity {

    public int a = 1;
    public long time;
    public long timeb = 0;
    final Context context = this;
    public SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        lines = lines * 5 ;
        final Button btn[] = {(Button)findViewById(R.id.but1), (Button)findViewById(R.id.but2),
                findViewById(R.id.but3), findViewById(R.id.but4),
                findViewById(R.id.but5), findViewById(R.id.but6),
                findViewById(R.id.but7), findViewById(R.id.but8),
                findViewById(R.id.but9), findViewById(R.id.but10),
                findViewById(R.id.but11), findViewById(R.id.but12),
                findViewById(R.id.but13), findViewById(R.id.but14),
                findViewById(R.id.but15), findViewById(R.id.but16),
                findViewById(R.id.but18), findViewById(R.id.but19),
                findViewById(R.id.but20), findViewById(R.id.but21),
                findViewById(R.id.but22), findViewById(R.id.but23),
                findViewById(R.id.but24), findViewById(R.id.but25),
                findViewById(R.id.but26), findViewById(R.id.but27),
                findViewById(R.id.but28), findViewById(R.id.but29),
                findViewById(R.id.but30), findViewById(R.id.but31),
                findViewById(R.id.but32), findViewById(R.id.but33),
                findViewById(R.id.but34), findViewById(R.id.but35),
                findViewById(R.id.but36), findViewById(R.id.but37),
                findViewById(R.id.but38), findViewById(R.id.but39),
                findViewById(R.id.but40), findViewById(R.id.but41),
        };

        for (int i = lines; i<btn.length; i++){
          btn[i].setVisibility(View.INVISIBLE);

        };


        final Chronometer chrono = (Chronometer)findViewById(R.id.chrono);

        chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapsedMillis = SystemClock.elapsedRealtime() - chrono.getBase();


                time = elapsedMillis / 1000;
                if (hint) {
                    if (time - timeb == htime) {
                        for (int i = 0; i < lines; i++) {
                            String txt = btn[i].getText().toString();
                            if (Integer.parseInt(txt) == a) {
                                light(btn[i]);
                            }
                        }
                        ;

                    }
                }
                ;
            }
        });
        chrono.start();


        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeb = time;
                String ili = ((Button) v).getText().toString();
                if(Integer.parseInt(ili)==a){
                    if(hide){
                        v.setVisibility(View.INVISIBLE);
                    } else {
                        v.setEnabled(false);
                    }

                    a++;
                }

                if(a>lines){
                    chrono.stop();
                    LayoutInflater li = LayoutInflater.from(context);
                    View promptsView = li.inflate(R.layout.prompt, null);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setView(promptsView);
                    final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);
                    builder.setTitle(R.string.end);

                    builder.setMessage("Время " + String.valueOf(time));
                    builder.setCancelable(false);
                    builder.setPositiveButton("Записать", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setNegativeButton("Пропустить", new DialogInterface.OnClickListener() {
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








        ArrayList<Byte> kek = new ArrayList<>();
        for(Byte i = 1; i<=lines; i++){
            kek.add(i-1, i);

        };
        for(Byte i = 0; i<btn.length; i++){
            btn[i].setOnClickListener(click);
        };
        Random rand = new Random();
        for(Byte i = 0; i<lines; i++){
            if (color){
                btn[i].setTextColor(Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            }
            int r = rand.nextInt(kek.size());
            btn[i].setText(String.valueOf(kek.get(r)));
            kek.remove(r);
        }







    }
    public void light (View v) {

        v.setBackgroundColor(Color.YELLOW);


    };


}

