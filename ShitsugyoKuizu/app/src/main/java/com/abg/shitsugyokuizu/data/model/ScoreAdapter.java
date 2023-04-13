package com.abg.shitsugyokuizu.data.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.abg.shitsugyokuizu.R;

import java.util.List;

public class ScoreAdapter extends ArrayAdapter<Questionnaire> {

    public ScoreAdapter(Context context, List<Questionnaire> objects){
        super(context,0,objects);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Questionnaire questionnaire = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.score_cell, parent, false);

        TextView intitule = convertView.findViewById(R.id.textViewIntitule);
        TextView score = convertView.findViewById(R.id.textViewScore);

        intitule.setText(questionnaire.getIntitule());
        score.setText(questionnaire.getScore());

        return convertView;
    }

}
