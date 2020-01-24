package com.example.triviaapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.triviaapp.database.AppDatabase;
import com.example.triviaapp.database.AppExecutors;
import com.example.triviaapp.adapter.HistoryAdapter;
import com.example.triviaapp.R;
import com.example.triviaapp.model.Result;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private HistoryAdapter mAdapter;
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //database instance of singleton class
        mDb = AppDatabase.getInstance(getApplicationContext());

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter and attach it to the RecyclerView
        mAdapter = new HistoryAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

//retrieve data from database
    private void retrieveTasks() {
        //AppExecutors are use to retrieve data in different thread
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Result> results = mDb.resultDao().loadAllResults();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.setTasks(results);
                    }
                });
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveTasks();
    }
}
