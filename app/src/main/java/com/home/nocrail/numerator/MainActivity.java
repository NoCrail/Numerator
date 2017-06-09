package com.home.nocrail.numerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public static boolean color = false;
    public static boolean hide = false;
    public static boolean rotate = false;
    public static int lines  = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CheckBox colorcheck = (CheckBox)findViewById(R.id.ColorCheck);
        final CheckBox hidecheck = (CheckBox)findViewById(R.id.HideCheck);

        Button start = (Button)findViewById(R.id.start);
        Button about = (Button)findViewById(R.id.about);

        final Spinner spin = (Spinner)findViewById(R.id.spinner);


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(MainActivity.this, About.class);

                startActivity(about);

            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(MainActivity.this, Game.class);
                hide = hidecheck.isChecked();
                color = colorcheck.isChecked();
                String t = spin.getSelectedItem().toString();
                lines = Integer.parseInt(t);
                startActivity(start);

            }
        });
    }

}
