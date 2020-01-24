package com.example.triviaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaapp.R;
import com.example.triviaapp.database.AppDatabase;
import com.example.triviaapp.model.Result;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    //adapter class to get previous results

    private Context context;
    private List<Result> mResultList;

    public void setTasks(List<Result> personList) {
        mResultList = personList;
        notifyDataSetChanged();
    }

    public List<Result> getTasks() {

        return mResultList;
    }


    public HistoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {
        holder.name.setText(mResultList.get(position).getName());
        holder.bestCricketer.setText(mResultList.get(position).getBestCricketer());
        holder.flagColors.setText(mResultList.get(position).getNationalColors());
    }

    @Override
    public int getItemCount() {
        if (mResultList == null) {
            return 0;
        }
        return mResultList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, bestCricketer,flagColors;
        AppDatabase mDb;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            mDb = AppDatabase.getInstance(context);
            name = itemView.findViewById(R.id.person_name);
            bestCricketer = itemView.findViewById(R.id.best_cricketer_result_text_view);
            flagColors = itemView.findViewById(R.id.flag_colors_result);
        }
    }
}
