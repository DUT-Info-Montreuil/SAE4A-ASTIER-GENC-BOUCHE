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
import com.abg.shitsugyokuizu.data.model.DatabaseHelper;
import com.abg.shitsugyokuizu.data.model.Question;
import com.abg.shitsugyokuizu.data.model.Questionnaire;
import com.abg.shitsugyokuizu.data.model.QuestionnaireJoue;

import java.text.ParseException;
import java.util.ArrayList;
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

        plusButton = (ImageButton) findViewById(R.id.plusAccueil_button);
        interroButton = findViewById(R.id.interroAccueil_button);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, MyQuiz.class);
                startActivity(intent);
                finish();
            }
        });

        interroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, AllQuizz.class);
                startActivity(intent);
                finish();
            }
        });

        SharedPreferences spref = getSharedPreferences("SHARED_PREF_USER_ID", Context.MODE_PRIVATE);
        int currentId = spref.getInt("id", 0);


        API api = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<List<QuestionnaireJoue>> getQuest = api.getQuestionnaire(currentId);

        getQuest.enqueue(new Callback<List<QuestionnaireJoue>>() {
            @Override
            public void onResponse(Call<List<QuestionnaireJoue>> call, Response<List<QuestionnaireJoue>> response) {
                List<QuestionnaireJoue> questionnaires = response.body();
                try {
                    lastQuiz1.setText(questionnaires.get(0).getIntitule());
                }catch (Exception e) {
                    lastQuiz1.setVisibility(View.GONE);
                }

                try {
                    lastQuiz2.setText(questionnaires.get(1).getIntitule());
                }catch (Exception e) {
                    lastQuiz2.setVisibility(View.GONE);
                }

                try {
                    lastQuiz3.setText(questionnaires.get(2).getIntitule());
                }catch (Exception e) {
                    lastQuiz3.setVisibility(View.GONE);
                }

                try {
                    lastQuiz4.setText(questionnaires.get(3).getIntitule());
                }catch (Exception e) {
                    lastQuiz4.setVisibility(View.GONE);
                }

                lastQuiz1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnaires.get(0).getIdQuestionnaire());
                        startActivity(intent);
                    }
                });

                lastQuiz2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnaires.get(1).getIdQuestionnaire());
                        startActivity(intent);
                    }
                });
                lastQuiz3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnaires.get(2).getIdQuestionnaire());
                        startActivity(intent);
                    }
                });
                lastQuiz4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnaires.get(3).getIdQuestionnaire());
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
        getQuestDuMois.enqueue(new Callback<List<QuestionnaireJoue>>() {
            @Override
            public void onResponse(Call<List<QuestionnaireJoue>> call, Response<List<QuestionnaireJoue>> response) {
                List<QuestionnaireJoue> questionnairesDuMois = response.body();

                try {
                    monthQuiz1.setText(questionnairesDuMois.get(0).getIntitule());
                } catch (Exception e) {
                    monthQuiz1.setVisibility(View.GONE);
                }

                try {
                    monthQuiz2.setText(questionnairesDuMois.get(1).getIntitule());
                } catch (Exception e) {
                    monthQuiz2.setVisibility(View.GONE);
                }

                try {
                    monthQuiz3.setText(questionnairesDuMois.get(2).getIntitule());
                } catch (Exception e) {
                    monthQuiz3.setVisibility(View.GONE);
                }

                try {
                    monthQuiz4.setText(questionnairesDuMois.get(3).getIntitule());
                } catch (Exception e) {
                    monthQuiz4.setVisibility(View.GONE);
                }

                monthQuiz1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnairesDuMois.get(0).getIdQuestionnaire());
                        startActivity(intent);
                    }
                });

                monthQuiz2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnairesDuMois.get(1).getIdQuestionnaire());
                        startActivity(intent);
                    }
                });
                monthQuiz3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnairesDuMois.get(2).getIdQuestionnaire());
                        startActivity(intent);
                    }
                });
                monthQuiz4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AccueilActivity.this, QuizActivity.class);
                        intent.putExtra("id", questionnairesDuMois.get(3).getIdQuestionnaire());
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