package com.example.textgradle;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String packageName = getApplication().getPackageName();
        Log.d("xx", "packageName: " + packageName);

        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo != null) {
            String version = packageInfo.versionName;
            Log.d("xx", "versionName: " + version);
            int versionCode = packageInfo.versionCode;
            Log.d("xx", "versionCode: " + versionCode);
        }

        boolean isforeign = BuildConfig.isforeign;
        Log.d("xx", "buildConfigField: isforeign" + isforeign);

        String string = getString(R.string.text_res_value);
        Log.d("xx", "resvalue " + string);
    }
}
