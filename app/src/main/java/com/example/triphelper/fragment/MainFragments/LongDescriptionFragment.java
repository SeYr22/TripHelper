package com.example.triphelper.fragment.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.triphelper.R;

import static com.example.triphelper.activity.MainActivity.HEIGHT;
import static com.example.triphelper.activity.MainActivity.WIDTH;
import static com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment.currIndexInListOfPlaces;
import static com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment.currNameInListOfPlaces;
import static com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment.listOfPlaces;
import static com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment.longListOfPlaces;

public class LongDescriptionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.long_description_fragment, container, false);
        for(int i = 0; i < listOfPlaces.get(currIndexInListOfPlaces).size(); i++){
            if(listOfPlaces.get(currIndexInListOfPlaces).get(i).getName().equals(currNameInListOfPlaces)){
                ((TextView)(rootView.findViewById(R.id.longName))).setText(currNameInListOfPlaces);
                ((TextView)(rootView.findViewById(R.id.longDescription))).setText(
                        longListOfPlaces.get(currIndexInListOfPlaces).get(i).getLongDescription());
                ((TextView)(rootView.findViewById(R.id.textAdress))).setText(
                        longListOfPlaces.get(currIndexInListOfPlaces).get(i).getAdress());
                int width = WIDTH;
                int height = HEIGHT / 10 * 3;
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width,height);
                ((rootView.findViewById(R.id.longImageID))).setLayoutParams(params);
                ((ImageView)(rootView.findViewById(R.id.longImageID))).setImageResource(
                        longListOfPlaces.get(currIndexInListOfPlaces).get(i).getImageID());
                width = HEIGHT / 20;
                params = new LinearLayout.LayoutParams(width,width);
                ((rootView.findViewById(R.id.iconAdress))).setLayoutParams(params);
                ((ImageView) rootView.findViewById(R.id.iconAdress))
                        .setImageResource(R.drawable.adress_icon);
            }
        }

        return rootView;
    }

}
