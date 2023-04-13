package com.abg.shitsugyokuizu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.Question;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class QuizActivity extends AppCompatActivity {

    public static final String RESULT_SCORE = "RESULT_SCORE";
    private static final String BUNDLE_STATE_SCORE = "BUNDLE_STATE_SCORE";
    private static final String BUNDLE_STATE_QUESTION_COUNT = "BUNDLE_STATE_QUESTION_COUNT";
    private static final String BUNDLE_STATE_QUESTION_BANK = "BUNDLE_STATE_QUESTION_BANK";

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";

    private static final int INITIAL_QUESTION_COUNT = 4;
    private TextView mTextViewQuestion;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;
    public static int score = 0;
    public static int curseur = 0;

    //private Questionnaire questionnaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTextViewQuestion = findViewById(R.id.textView);
        mAnswerButton1 = findViewById(R.id.button);
        mAnswerButton2 = findViewById(R.id.button2);
        mAnswerButton3 = findViewById(R.id.button3);
        mAnswerButton4 = findViewById(R.id.button4);

        Intent i = getIntent();
        int id = i.getIntExtra("id", -1);
        System.out.println(id);
        if (id!=-1) {
            Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();

            int idQuest = id;
            API api = RetrofitClientInstance.getRetrofitInstance().create(API.class);
            Call <List<Question>> call = api.getQuestionDuQuesionnaire(id);
            call.enqueue(new Callback<List<Question>>() {
                @Override
                public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {

                    if (response.isSuccessful()){

                        List<Question> questions = response.body();
                        if (curseur < questions.size() ){
                            chargementQuestion(questions.get(curseur));
                            Toast.makeText(QuizActivity.this, questions.size()+"", Toast.LENGTH_SHORT).show();

                            mAnswerButton1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                                    Toast.makeText(QuizActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                    if (questions.get(curseur).getnReponse() == 1){
                                        Toast.makeText(QuizActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                        score+=1;
                                    }
                                    intent.putExtra("id",id);
                                    curseur +=1;
                                    startActivity(intent);

                                }
                            });
                            mAnswerButton2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                                    Toast.makeText(QuizActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                    if (questions.get(curseur).getnReponse() == 2){
                                        Toast.makeText(QuizActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                        score+=1;
                                    }
                                    intent.putExtra("id",id);
                                    curseur +=1;
                                    startActivity(intent);
                                }
                            });
                            mAnswerButton3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                                    Toast.makeText(QuizActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                    if (questions.get(curseur).getnReponse() == 3){
                                        Toast.makeText(QuizActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                        score+=1;
                                    }
                                    intent.putExtra("id",id);
                                    curseur +=1;
                                    startActivity(intent);
                                }
                            });
                            mAnswerButton4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                                    Toast.makeText(QuizActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                    if (questions.get(curseur).getnReponse() == 4){
                                        Toast.makeText(QuizActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                        score+=1;
                                    }
                                    intent.putExtra("id",id);
                                    curseur +=1;
                                    startActivity(intent);
                                }
                            });

                        }
                        else {

                            RequestQueue queue = Volley.newRequestQueue(QuizActivity.this);

                            String url = "http://192.168.56.1/insert_questionnaireJoue.php";
                            StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // on below line we are displaying a success toast message.
                                    Toast.makeText(QuizActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(QuizActivity.this,AccueilActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }, new com.android.volley.Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    // method to handle errors.
                                    Toast.makeText(QuizActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                                }
                            }) {
                                @Override
                                protected Map<String, String> getParams() {
                                    // below line we are creating a map for
                                    // storing our values in key and value pair.
                                    Map<String, String> params = new HashMap<String, String>();

                                    SharedPreferences spref = getSharedPreferences("SHARED_PREF_USER_ID", Context.MODE_PRIVATE);
                                    int currentId = spref.getInt("id", 0);

                                    params.put("idUtilisateur", String.valueOf(currentId));
                                    params.put("idQuestionnaire", String.valueOf(idQuest));

                                    // at last we are
                                    // returning our params.
                                    return params;
                                }
                            };
                            queue.add(request);
                        }
                    }
                    System.out.println(response.body());
                }

                @Override
                public void onFailure(Call<List<Question>> call, Throwable t) {
                    Toast.makeText(QuizActivity.this, "Erreur lors de l'insertion de questionnaireJoue", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //displayQuestion(questionnaire);
    }

    public void chargementQuestion(Question question){
        mTextViewQuestion.setText(question.getIntitule());
        mAnswerButton1.setText(question.getReponse1());
        mAnswerButton2.setText(question.getReponse2());
        mAnswerButton3.setText(question.getReponse3());
        mAnswerButton4.setText(question.getReponse4());
    }


}