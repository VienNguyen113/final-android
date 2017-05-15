package com.hoangddt.duoihinhbatchu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hoangddt.duoihinhbatchu.R;
import com.hoangddt.duoihinhbatchu.entity.Question;
import com.hoangddt.duoihinhbatchu.util.FileUtils;

import java.util.List;

public class ListGamePlayAdapter extends RecyclerView.Adapter<ListGamePlayAdapter.ViewHolder> {

    private List<Question> questions;
    private Context context;

    public ListGamePlayAdapter(List<Question> questionList, Context c) {
        this.questions = questionList;
        this.context = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_gameplay, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imvQuestion.setImageDrawable(FileUtils.getInstance(context).getDrawable(questions.get(position).getImageName()));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvQuestion;

        public ViewHolder(View v) {
            super(v);
            imvQuestion = (ImageView) v.findViewById(R.id.imvQuestion);
        }
    }
}
