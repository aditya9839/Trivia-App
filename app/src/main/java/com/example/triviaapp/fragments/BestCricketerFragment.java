package com.example.triviaapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.triviaapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestCricketerFragment extends Fragment {

    private RadioButton option1,option2,option3,option4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_best_cricketer, container, false);
        // Inflate the layout for this fragment

        Button nextButton = view.findViewById(R.id.next_btn_fragment);
        option1 = view.findViewById(R.id.option1);
        option2 = view.findViewById(R.id.option2);
        option3 = view.findViewById(R.id.option3);
        option4 = view.findViewById(R.id.option4);

        String username = getArguments().getString("username");
        final Bundle args = new Bundle();
        args.putString("username",username);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = false;
                String bestCricketer = "";
                if (option1.isChecked()){
                    bestCricketer = option1.getText().toString().trim();
                    isChecked = true;
                }
                else if (option2.isChecked()){
                    bestCricketer = option2.getText().toString().trim();
                    isChecked = true;

                }
                else if (option3.isChecked()){
                    bestCricketer = option3.getText().toString().trim();
                    isChecked = true;

                }
                else if (option4.isChecked()){
                    bestCricketer = option4.getText().toString().trim();
                    isChecked = true;
                }
                if (isChecked) {
                    args.putString("bestCricketer",bestCricketer);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new NationFlagColorsFragment();
                    fragment.setArguments(args);
                    fragmentTransaction.add(R.id.frag_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
        return view;
    }

}
