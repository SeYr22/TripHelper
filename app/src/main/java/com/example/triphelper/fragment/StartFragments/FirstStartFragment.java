package com.example.triphelper.fragment.StartFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.triphelper.R;
import com.example.triphelper.handler.FragmentController;
import com.example.triphelper.mvp.core.FragmentByName;

public class FirstStartFragment extends Fragment implements View.OnClickListener {
    Button nextFragmentBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.first_start_fragment, container, false);
        nextFragmentBtn = (Button) rootView.findViewById(R.id.nextFragmentBtn);
        nextFragmentBtn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.nextFragmentBtn:
                FragmentController.changeNextFragment(new SecondStartFragment(), FragmentByName.SECOND_START_FRAGMENT);
                break;
        }
    }
}
