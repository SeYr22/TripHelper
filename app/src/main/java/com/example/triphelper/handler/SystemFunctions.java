package com.example.triphelper.handler;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.triphelper.activity.MainActivity;
import com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment;
import com.example.triphelper.fragment.StartFragments.FirstStartFragment;
import com.example.triphelper.mvp.core.FragmentByName;

public class SystemFunctions {
    public static void launch(){
        boolean firstLaunch = MainActivity.sp.getBoolean("firstLaunch", false);
        if(!firstLaunch){
            FragmentController.changeNextFragment(new FirstStartFragment(), FragmentByName.FIRST_START_FRAGMENT);
            SharedPreferences.Editor e = MainActivity.sp.edit();
            e.putBoolean("firstLaunch", true);
            e.commit();
        }else{
            FragmentController.changeNextFragment(new ListOfPlacesFragment(), FragmentByName.LIST_OF_PLACES_FRAGMENT);
        }
    }
    public static void makeAnErrorToast(String text){
        Toast.makeText(MainActivity.context, text, Toast.LENGTH_SHORT).show();
    }
    public static void exitApllication(Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.context);
        builder.setTitle("Вы уверены,что хотите закрыть приложение?")
                .setPositiveButton("Да",
                        (dialog, id) -> activity.finish())
                .setNegativeButton("Нет",
                        (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}
