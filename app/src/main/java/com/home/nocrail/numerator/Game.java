package com.home.nocrail.numerator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class Game extends AppCompatActivity {

    public int a = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

         View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ili = ((Button) v).getText().toString();
                if(Integer.parseInt(ili)==a){
                    v.setEnabled(false);
                    a++;
                }
            }
        };

            Button btn[] = {(Button)findViewById(R.id.but1), (Button)findViewById(R.id.but2),
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
            };

        //btn[0].setEnabled(false);
        ArrayList<Byte> kek = new ArrayList<>();
        for(Byte i = 1; i<=btn.length; i++){
            kek.add(i-1, i);

        };
        for(Byte i = 0; i<btn.length; i++){
            btn[i].setOnClickListener(click);
        };
        Random rand = new Random();
        for(Byte i = 0; i<btn.length; i++){
            int r = rand.nextInt(kek.size());
            btn[i].setText(String.valueOf(kek.get(r)));
            kek.remove(r);
        }


        //Toast.makeText(this, "Kek", Toast.LENGTH_SHORT).show();




    }



}

