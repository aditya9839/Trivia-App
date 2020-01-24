package com.example.triviaapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.triviaapp.fragments.BestCricketerFragment;
import com.example.triviaapp.R;

//app starts from here
public class MainActivity extends AppCompatActivity {

    Button nextButton,historyButton;
    EditText nameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.next_btn);
        historyButton = findViewById(R.id.history_btn);
        nameEditText = findViewById(R.id.name_edit_text);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameEditText.getText().toString().equals("")){
                    nameEditText.setError("Please Enter Name");
                }
                else{
                    //bundle used to send data
                    Bundle args = new Bundle();
                    args.putString("username", ""+nameEditText.getText().toString());

                    //basic fragment transaction
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new BestCricketerFragment();
                    fragment.setArguments(args);
                    fragmentTransaction.add(R.id.container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            //intent used to call another activity
            @Override
            public void onClick(View view) {
               Intent i =  new Intent(MainActivity.this, HistoryActivity.class);
               startActivity(i);
            }
        });
    }
}
