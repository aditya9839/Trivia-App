package com.example.triviaapp.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.triviaapp.R;
import com.example.triviaapp.activities.HistoryActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment {

    private TextView nameTextView,bestCricketerTextView,nationalColorsTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        Button historyButton = view.findViewById(R.id.history_btn);
        nameTextView = view.findViewById(R.id.name_text_view);
        bestCricketerTextView = view.findViewById(R.id.best_cricketer_text_view);
        nationalColorsTextView = view.findViewById(R.id.national_colors_text_view);
        final String username = getArguments().getString("username");
        final String bestCricketer = getArguments().getString("bestCricketer");
        final String nationalColors = getArguments().getString("nationalColors");

        nameTextView.setText("Hi! " + username);
        bestCricketerTextView.setText(bestCricketer);
        nationalColorsTextView.setText(nationalColors);

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

}
