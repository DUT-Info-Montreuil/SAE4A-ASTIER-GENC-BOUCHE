package com.abg.shitsugyokuizu.data.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abg.shitsugyokuizu.R;

import java.util.List;

public class QuestionnaireAdapter extends RecyclerView.Adapter<QuestionnaireAdapter.ViewHolder> {
    private List<Questionnaire> mQuestionnaires;
    private List<Questionnaire> mQuestionnairesFull;

    public QuestionnaireAdapter(List<Questionnaire> items) {
        this.mQuestionnaires = items;
        this.mQuestionnairesFull = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_questionnaire, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Questionnaire item = mQuestionnaires.get(position);
        holder.button.setText(item.getIntitule());
    }

    @Override
    public int getItemCount() {
        return mQuestionnaires.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.textview_menu_item);
        }
    }

    //Permettait de rechercher dans la liste de quiz, mais ne marchait pas
//    public boolean filter(String text) {
//        boolean texteVide = false;
//        mQuestionnaires.clear();
//        if(text.equals("")){
//            this.mQuestionnaires.addAll(this.mQuestionnairesFull);
//            texteVide = true;
//        } else{
//            text = text.toLowerCase();
//            for(Questionnaire item: mQuestionnairesFull){
//                if(item.getIntitule().toLowerCase().contains(text)){
//                    mQuestionnaires.add(item);
//                }
//            }
//        }
//        notifyDataSetChanged();
//        return texteVide;
//    }

}
