package com.example.triviaapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.triviaapp.database.AppDatabase;
import com.example.triviaapp.database.AppExecutors;
import com.example.triviaapp.R;
import com.example.triviaapp.model.Result;

public class NationFlagColorsFragment extends Fragment {

    private Button nextButton;
    private RadioButton option1,option2,option3,option4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_nation_flag_colors, container, false);
        nextButton = view.findViewById(R.id.next_btn_fragment);
        option1 = view.findViewById(R.id.option1);
        option2 = view.findViewById(R.id.option2);
        option3 = view.findViewById(R.id.option3);
        option4 = view.findViewById(R.id.option4);

        final String username = getArguments().getString("username");
        final String bestCricketer = getArguments().getString("bestCricketer");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = false;
                String nationalColors = "";
                if (option1.isChecked()){
                    nationalColors = option1.getText().toString().trim();
                    isChecked = true;
                }
                if (option2.isChecked()){
                    nationalColors = nationalColors + ", " + option2.getText().toString().trim();
                    isChecked = true;

                }
                if (option3.isChecked()){
                    nationalColors = nationalColors + ", " + option3.getText().toString().trim();
                    isChecked = true;

                }
                if (option4.isChecked()){
                    nationalColors = nationalColors + ", " + option4.getText().toString().trim();
                    isChecked = true;
                }
                if (isChecked) {
                    Log.d("Hello","halo");
                    final Result result = new Result(username,bestCricketer,nationalColors);

                    final AppDatabase mDb = AppDatabase.getInstance(view.getContext());

                    AppExecutors.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            mDb.resultDao().insertResult(result);
                        }
                    });

                    final Bundle args = new Bundle();
                    args.putString("username",username);
                    args.putString("bestCricketer",bestCricketer);
                    args.putString("nationalColors",nationalColors);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new SummaryFragment();
                    fragment.setArguments(args);
                    fragmentTransaction.add(R.id.frag_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}
