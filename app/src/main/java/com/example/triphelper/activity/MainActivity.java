package com.example.triphelper.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.triphelper.R;
import com.example.triphelper.handler.SystemFunctions;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static FragmentTransaction fragmentTransaction;
    public static Context context;
    public static String CITY;
    public static String HOTEl;
    static public int WIDTH, HEIGHT;
    public static final String MY_SETTINGS = "my_settings";
    public static SharedPreferences sp;
    MainActivity mainActivity = this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WIDTH = getWindowManager().getDefaultDisplay().getWidth();
        HEIGHT = getWindowManager().getDefaultDisplay().getHeight();
      //  getSupportActionBar().hide();
        context = this;
        fragmentManager = getSupportFragmentManager();
        sp = getSharedPreferences(MY_SETTINGS,
                Context.MODE_PRIVATE);
        SystemFunctions.launch();
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() == 0){
            SystemFunctions.exitApllication(mainActivity);
        }else fragmentManager.popBackStack();
    }
}

