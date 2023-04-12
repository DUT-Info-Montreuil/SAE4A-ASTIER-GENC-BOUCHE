package com.abg.shitsugyokuizu;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.Questionnaire;
import com.abg.shitsugyokuizu.data.model.QuestionnaireJoue;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccueilActivity extends AppCompatActivity {

    private Button lastQuiz1, lastQuiz2, lastQuiz3, lastQuiz4;
    private Button monthQuiz1, monthQuiz2, monthQuiz3, monthQuiz4;

    private TextView texte;

    private ImageButton profilButton, plusButton, interroButton, trophyButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        texte = findViewById(R.id.dernierQuiz_textview);

        lastQuiz1 = (Button) findViewById(R.id.dernierQuizUn_button);
        lastQuiz2 = (Button) findViewById(R.id.dernierQuizDeux_button);
        lastQuiz3 = (Button) findViewById(R.id.dernierQuizTrois_button);
        lastQuiz4 = (Button) findViewById(R.id.dernierQuizQuatre_button);

        monthQuiz1 = (Button) findViewById(R.id.quizDuMoisUn_button);
        monthQuiz2 = (Button) findViewById(R.id.quizDuMoisDeux_button);
        monthQuiz3 = (Button) findViewById(R.id.quizDuMoisTrois_button);
        monthQuiz4 = (Button) findViewById(R.id.quizDuMoisQuatre_button);

        SharedPreferences spref = getSharedPreferences("SHARED_PREF_USER_ID", Context.MODE_PRIVATE);
        int currentId = spref.getInt("id", 0);


        API api = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<List<QuestionnaireJoue>> getQuest = api.getQuestionnaire(currentId);



        getQuest.enqueue(new Callback<List<QuestionnaireJoue>>() {
            @Override
            public void onResponse(Call<List<QuestionnaireJoue>> call, Response<List<QuestionnaireJoue>> response) {
                List<QuestionnaireJoue> questionnaires = response.body();
                lastQuiz1.setText(questionnaires.get(0).getIntitule());
                lastQuiz2.setText(questionnaires.get(1).getIntitule());
                lastQuiz3.setText(questionnaires.get(2).getIntitule());
                lastQuiz4.setText(questionnaires.get(3).getIntitule());
                lastQuiz1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnaires.get(0).getIdUtilisteur());
                        startActivity(intent);
                    }
                });
                lastQuiz2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnaires.get(1).getIdUtilisteur());
                        startActivity(intent);
                    }
                });
                lastQuiz3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnaires.get(2).getIdUtilisteur());
                        startActivity(intent);
                    }
                });
                lastQuiz4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnaires.get(3).getIdUtilisteur());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<QuestionnaireJoue>> call, Throwable t) {

            }
        });


        API apiQuestionnaireDuMois = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<List<QuestionnaireJoue>> getQuestDuMois = apiQuestionnaireDuMois.getQuestionnaireDuMois();
        List<QuestionnaireJoue> questionnairesDuMois;
        getQuestDuMois.enqueue(new Callback<List<QuestionnaireJoue>>() {
            @Override
            public void onResponse(Call<List<QuestionnaireJoue>> call, Response<List<QuestionnaireJoue>> response) {
                List<QuestionnaireJoue> questionnairesDuMois = response.body();
                monthQuiz1.setText(questionnairesDuMois.get(0).getIntitule());
                monthQuiz2.setText(questionnairesDuMois.get(1).getIntitule());
                monthQuiz3.setText(questionnairesDuMois.get(2).getIntitule());
                monthQuiz4.setText(questionnairesDuMois.get(3).getIntitule());


                monthQuiz1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnairesDuMois.get(0).getIdUtilisteur());
                        startActivity(intent);
                    }
                });

                monthQuiz2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnairesDuMois.get(1).getIdUtilisteur());
                        startActivity(intent);
                    }
                });
                monthQuiz3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnairesDuMois.get(2).getIdUtilisteur());
                        startActivity(intent);
                    }
                });
                monthQuiz4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnairesDuMois.get(3).getIdUtilisteur());
                        startActivity(intent);
                    }
                });
            }


            @Override
            public void onFailure(Call<List<QuestionnaireJoue>> call, Throwable t) {
                Toast.makeText(AccueilActivity.this, "Bruh", Toast.LENGTH_SHORT).show();
            }
        });





    }
}