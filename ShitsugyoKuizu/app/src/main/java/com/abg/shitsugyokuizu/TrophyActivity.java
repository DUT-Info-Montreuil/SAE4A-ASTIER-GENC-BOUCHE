package com.abg.shitsugyokuizu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.Questionnaire;
import com.abg.shitsugyokuizu.data.model.QuestionnaireAdapter;
import com.abg.shitsugyokuizu.data.model.ScoreAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrophyActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy);

        listview = findViewById(R.id.score_listview);

        ArrayList<Questionnaire> questJoueurs = new ArrayList<>();

        API api = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<List<Questionnaire>> getQuizzJoueur = api.getQuestJoueur();

        getQuizzJoueur.enqueue(new Callback<List<Questionnaire>>() {
            @Override
            public void onResponse(Call<List<Questionnaire>> call, Response<List<Questionnaire>> response) {
                List<Questionnaire> questionnaires = response.body();

                if(!response.body().isEmpty()) {
                    System.out.println("Quiz chargés");
                }

                for(Questionnaire q : questionnaires) {
                    questJoueurs.add(q);
                }
            }

            @Override
            public void onFailure(Call<List<Questionnaire>> call, Throwable t) {

            }
        });

        ScoreAdapter adapter = new ScoreAdapter(getApplicationContext(),questJoueurs);
        listview.setAdapter(adapter);
    }
}