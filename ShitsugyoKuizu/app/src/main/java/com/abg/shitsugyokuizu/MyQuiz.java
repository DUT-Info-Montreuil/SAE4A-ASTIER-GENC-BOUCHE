package com.abg.shitsugyokuizu;

import static com.abg.shitsugyokuizu.ConnexionActivity.SHARED_PREF_USER_ID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.Questionnaire;
import com.abg.shitsugyokuizu.data.model.QuestionnaireJoue;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyQuiz extends AppCompatActivity {

    private Button creerQuiz, allQuiz;
    private Button quizPlusJoue1, quizPlusJoue2, quizPlusJoue3, quizPlusJoue4;
    private Button dernierQuizCree1, dernierQuizCree2, dernierQuizCree3, dernierQuizCree4;
    private ImageButton plusButton, interroButton, trophyButton;
    private ImageButton profilButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_quiz);

        creerQuiz = (Button) findViewById(R.id.creerQuiz_button);
        allQuiz = (Button) findViewById(R.id.tousVosQuizz_button);

        quizPlusJoue1 = (Button) findViewById(R.id.quizPlusJouesUn_button);
        quizPlusJoue2 = (Button) findViewById(R.id.quizPlusJouesDeux_button);
        quizPlusJoue3 = (Button) findViewById(R.id.quizPlusJouesTrois_button);
        quizPlusJoue4 = (Button) findViewById(R.id.quizPlusJouesQuatre_button);

        dernierQuizCree1 = (Button) findViewById(R.id.dernierQuizCreeUn_button);
        dernierQuizCree2 = (Button) findViewById(R.id.dernierQuizCreeDeux_button);
        dernierQuizCree3 = (Button) findViewById(R.id.dernierQuizCreeTrois_button);
        dernierQuizCree4 = (Button) findViewById(R.id.dernierQuizCreeQuatre_button);

        plusButton = (ImageButton) findViewById(R.id.plusMyQuiz_button);
        interroButton = (ImageButton) findViewById(R.id.interroMyQuiz_button);
        trophyButton = (ImageButton) findViewById(R.id.trophyMyQuiz_button);
        profilButton = (ImageButton) findViewById(R.id.accountMyQuiz_button);

        creerQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyQuiz.this, CreateQuiz.class);
                startActivity(intent);
                finish();
            }
        });

        interroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyQuiz.this, AllQuizz.class);
                startActivity(intent);
                finish();
            }
        });

        trophyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyQuiz.this, TrophyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        SharedPreferences spref = getSharedPreferences(SHARED_PREF_USER_ID, MODE_PRIVATE);
        Map<String, Integer> s = (Map<String, Integer>) spref.getAll();

        int userId = s.get("id");

        API apiVosQuizPlusJoues = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<List<Questionnaire>> getVosQuizPlusJoues = apiVosQuizPlusJoues.getDernierQuestionnaireCree(userId);
        getVosQuizPlusJoues.enqueue(new Callback<List<Questionnaire>>() {
            @Override
            public void onResponse(Call<List<Questionnaire>> call, Response<List<Questionnaire>> response) {
                List<Questionnaire> dernierQuestCree = response.body();
                System.out.println(response.body());
                if(!response.body().isEmpty() && response.body()!=null) {
                    try {
                        quizPlusJoue1.setText(dernierQuestCree.get(0).getIntitule());
                    } catch(Exception e) {
                        quizPlusJoue1.setVisibility(View.GONE);
                    }

                    try {
                        quizPlusJoue2.setText(dernierQuestCree.get(0).getIntitule());
                    } catch(Exception e) {
                        quizPlusJoue2.setVisibility(View.GONE);
                    }

                    try {
                        quizPlusJoue3.setText(dernierQuestCree.get(0).getIntitule());
                    } catch(Exception e) {
                        quizPlusJoue3.setVisibility(View.GONE);
                    }

                    try {
                        quizPlusJoue4.setText(dernierQuestCree.get(0).getIntitule());
                    } catch(Exception e) {
                        quizPlusJoue4.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Questionnaire>> call, Throwable t) {
                Toast.makeText(MyQuiz.this, "Bruh", Toast.LENGTH_SHORT).show();
            }
        });

        API apiDernierQuestionnaireCree = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<List<Questionnaire>> getDernierQuestCree = apiDernierQuestionnaireCree.getDernierQuestionnaireCree(userId);
        getDernierQuestCree.enqueue(new Callback<List<Questionnaire>>() {
            @Override
            public void onResponse(Call<List<Questionnaire>> call, Response<List<Questionnaire>> response) {
                List<Questionnaire> dernierQuestCree = response.body();
                System.out.println(response.body());
                if(!response.body().isEmpty() && response.body()!=null) {
                    try {
                        dernierQuizCree1.setText(dernierQuestCree.get(0).getIntitule());
                    } catch (Exception e) {
                        dernierQuizCree1.setVisibility(View.GONE);
                    }
                    try {
                        dernierQuizCree2.setText(dernierQuestCree.get(0).getIntitule());
                    } catch (Exception e) {
                        dernierQuizCree2.setVisibility(View.GONE);
                    }

                    try {
                        dernierQuizCree3.setText(dernierQuestCree.get(0).getIntitule());
                    } catch (Exception e) {
                        dernierQuizCree3.setVisibility(View.GONE);
                    }

                    try {
                        dernierQuizCree4.setText(dernierQuestCree.get(0).getIntitule());
                    } catch (Exception e) {
                        dernierQuizCree4.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Questionnaire>> call, Throwable t) {
                Toast.makeText(MyQuiz.this, "Bruh", Toast.LENGTH_SHORT).show();
            }
        });
    }
}