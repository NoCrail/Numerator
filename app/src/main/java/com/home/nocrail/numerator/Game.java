package com.home.nocrail.numerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.Random;


public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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
        /*int[] num = new int[31];
        int r; int sum = 0; int i = 1;
        Random random = new Random();
        /*for (int i =0; i<30; i++ ){
            r = random.nextInt(30);

        }
        while (sum!=2247){
            r = random.nextInt(30);
            if (btn[r].getText()== "button"){
                btn[r].setText(i);
                sum+=i;
                i++;
            }
        }*/





    }

}
