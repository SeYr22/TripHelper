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
import com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment;
import com.example.triphelper.handler.FragmentController;
import com.example.triphelper.handler.SystemFunctions;
import com.example.triphelper.mvp.core.FragmentByName;
import java.util.ArrayList;
import java.util.List;

public class ThirdStartFragment extends Fragment implements View.OnClickListener {
    Button nextFragmentBtn;
    AutoCompleteTextView hotel;
    List<String> hotels;
    RadioButton firstStepBtn, secondStepBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.third_start_fragment, container, false);
        nextFragmentBtn = (Button) rootView.findViewById(R.id.nextFragmentBtn);
        hotel =  (AutoCompleteTextView) rootView.findViewById(R.id.hotelTxt);
        firstStepBtn = (RadioButton) rootView.findViewById(R.id.firstStepBtn);
        secondStepBtn = (RadioButton) rootView.findViewById(R.id.secondStepBtn);
        firstStepBtn.setOnClickListener(this);
        secondStepBtn.setOnClickListener(this);
        nextFragmentBtn.setOnClickListener(this);
        fillListHotels();
        uploadAutoTxtViewHotels();
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.nextFragmentBtn:
                String hotelName = hotel.getText().toString();
                if(!hotelName.isEmpty()) {
                    MainActivity.HOTEl = hotelName;
                    FragmentController.changeNextFragment(new ListOfPlacesFragment(), FragmentByName.LIST_OF_PLACES_FRAGMENT);
                }else{
                    SystemFunctions.makeAnErrorToast("Отель не найден!");
                }
                break;
            case R.id.firstStepBtn:
                FragmentController.returnToPreviousFragment(FragmentByName.FIRST_START_FRAGMENT);
                break;
            case R.id.secondStepBtn:
                FragmentController.returnToPreviousFragment(FragmentByName.SECOND_START_FRAGMENT);
                break;
        }
    }

    void fillListHotels() {
        hotels = new ArrayList<>();
        hotels.add("Мадрид");
        hotels.add("Махачкала");
        hotels.add("Мельбурн");
        hotels.add("Манхен");
        hotels.add("Магадан");
    }


    void uploadAutoTxtViewHotels() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                hotels);
        hotel.setAdapter(adapter);
    }
}
