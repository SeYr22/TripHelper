package com.example.triphelper.fragment.StartFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.triphelper.R;
import com.example.triphelper.activity.MainActivity;
import com.example.triphelper.handler.FragmentController;
import com.example.triphelper.handler.SystemFunctions;
import com.example.triphelper.mvp.core.FragmentByName;

import java.util.ArrayList;
import java.util.List;

public class SecondStartFragment extends Fragment implements View.OnClickListener {
    Button nextFragmentBtn;
    AutoCompleteTextView city;
    String cityName;
    boolean success;
    List<String> cities;
    RadioButton firstStepBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.second_start_fragment, container, false);
        nextFragmentBtn = (Button) rootView.findViewById(R.id.nextFragmentBtn);
        city =  (AutoCompleteTextView) rootView.findViewById(R.id.cityTxt);
        firstStepBtn = (RadioButton) rootView.findViewById(R.id.firstStepBtn);
        firstStepBtn.setOnClickListener(this);
        nextFragmentBtn.setOnClickListener(this);
        fillListCities();
        uploadAutoTxtViewCities();
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.nextFragmentBtn:
                String cityName = city.getText().toString();
                if(!cityName.isEmpty()) {
                    MainActivity.CITY = cityName;
                    FragmentController.changeNextFragment(new ThirdStartFragment(), FragmentByName.THIRD_START_FRAGMENT);
                }else{
                    SystemFunctions.makeAnErrorToast("Город не найден!");
                }
                break;
            case R.id.firstStepBtn:
                FragmentController.returnToPreviousFragment(FragmentByName.FIRST_START_FRAGMENT);
                break;
        }
    }

    void fillListCities() {
        cities = new ArrayList<>();
        cities.add("Мадрид");
        cities.add("Махачкала");
        cities.add("Мельбурн");
        cities.add("Манхен");
        cities.add("Магадан");
    }

    void uploadAutoTxtViewCities() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                cities);
        city.setAdapter(adapter);
    }

}
