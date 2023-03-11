package com.example.shared_references;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.os.Bundle;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context appContext = getApplicationContext();

        setContentView(R.layout.activity_settings);
        getSupportFragmentManager().beginTransaction() .replace(android.R.id.content, new MySettingFragment(appContext)).commit();
        PreferenceManager.setDefaultValues(this, R.xml.preference, false);

    }
}