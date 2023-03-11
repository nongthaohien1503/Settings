package com.example.shared_references;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  String sharedPrefFile = "com.example.android.hellosharedprefs";
    //SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
    SharedPreferences sharedPreferences;
    TextView text; int colornum = 0;
    //Button black, blue, red, yellow, count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
//        black = findViewById(R.id.bt_black);
//        blue = findViewById(R.id.bt_blue);
//        yellow = findViewById(R.id.bt_yellow);
//        red = findViewById(R.id.bt_red);
//        count = findViewById(R.id.bt_count);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String count = sharedPreferences.getString("displayNumber", "0");
        String color = sharedPreferences.getString("displayColor", "#FFFFFFF");

//       black.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                text.setBackgroundColor(Color.BLACK);
//                colornum = Color.BLACK;
//            }
//       });
//       blue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                text.setBackgroundColor(Color.BLUE);
//                colornum = Color.BLUE;
//            }
//        });
//        yellow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                text.setBackgroundColor(Color.YELLOW);
//                colornum = Color.YELLOW;
//            }
//        });
//        red.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                text.setBackgroundColor(Color.RED);
//                colornum = Color.RED;
//            }
//        });
//        count.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                count0++;
//                text.setText((String.valueOf(count0)));
//            }
//        });


        colornum = Color.parseColor(color);

        text.setText(count);
        text.setBackgroundColor(colornum);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume()
        {
            super.onResume();

            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

            String count = sharedPreferences.getString("displayNumber", "0");
            String color = sharedPreferences.getString("displayColor", "#FFFFFFF");

            colornum = Color.parseColor(color);

            text.setText(count);
            text.setBackgroundColor(colornum);

        }
}