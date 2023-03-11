package com.example.shared_references;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;


public class MySettingFragment extends PreferenceFragmentCompat {

    String[] colorValues;

    public MySettingFragment(Context appContext) {

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference, rootKey);

        colorValues = getResources().getStringArray(R.array.ListValue);
        ListPreference displayedColor = (ListPreference) findPreference("displayedColor");
        if (displayedColor != null) {
            displayedColor.setEntryValues(colorValues);
        }
    }
}
