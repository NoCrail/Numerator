package com.home.nocrail.numerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    public static boolean color = false;
    public static boolean hide = false;
    public static boolean rotate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CheckBox colorcheck = (CheckBox)findViewById(R.id.ColorCheck);
        final CheckBox hidecheck = (CheckBox)findViewById(R.id.HideCheck);

        Button start = (Button)findViewById(R.id.start);
        Button about = (Button)findViewById(R.id.about);


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

                startActivity(start);

            }
        });
    }

}
