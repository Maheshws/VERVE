package com.mahesh.verve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;

/**
 * Created by Mahesh on 12/21/13.
 */
public class PreferencesActivity extends PreferenceActivity {
    Editor editor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference_layout_holder);
        addPreferencesFromResource(R.xml.preferences_activity);
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintResource(R.drawable.ab_bottom_solid_vtheme);

        SharedPreferences pref = getSharedPreferences("user_settings", 0); // 0 - for private mode
        editor = pref.edit();
        final CheckBoxPreference Notification = (CheckBoxPreference) getPreferenceManager().findPreference("Notification");
        Notification.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Log.d("MyApp", "Pref " + preference.getKey() + " changed to " + newValue.toString());
                editor.putBoolean("Notification", (Boolean) newValue);
                editor.commit();
                return true;
            }
        });

        Preference CurrentVersion = findPreference("CurrentVersion");
        try {
            String versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            CurrentVersion.setSummary("v" + versionName);
            CurrentVersion.setTitle("Application Version");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        Preference AboutApp = findPreference("AboutApp");
        AboutApp.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(PreferencesActivity.this, AboutVERVEActivity.class));
                return false;
            }
        });

        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        Preference PlayStore = findPreference("PlayStore");
        PlayStore.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                }
                return false;
            }
        });


        editor.commit();
    }
}
