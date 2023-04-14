package com.abg.shitsugyokuizu;

import static com.abg.shitsugyokuizu.ConnexionActivity.SHARED_PREF_USER_ID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.Question;
import com.abg.shitsugyokuizu.data.model.Questionnaire;
import com.abg.shitsugyokuizu.data.model.QuestionnaireJoue;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class CreateQuiz extends AppCompatActivity {

    private EditText questionnaireText, questionText, resp1, resp2, resp3, resp4, bonneReponseText;

    private Button q1, q2, q3, q4, q5, q6, q7, q8;

    private Button createQuiz;

    private String question1, question2, question3, question4, question5, question6, question7, question8;

    private String reponse11, reponse12, reponse13, reponse14;

    private String reponse21, reponse22, reponse23, reponse24;

    private String reponse31, reponse32, reponse33, reponse34;

    private String reponse41, reponse42, reponse43, reponse44;

    private String reponse51, reponse52, reponse53, reponse54;

    private String reponse61, reponse62, reponse63, reponse64;

    private String reponse71, reponse72, reponse73, reponse74;

    private String reponse81, reponse82, reponse83, reponse84;

    private String bonneReponse1, bonneReponse2, bonneReponse3, bonneReponse4, bonneReponse5, bonneReponse6, bonneReponse7, bonneReponse8;

    private int nQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        questionnaireText = (EditText) findViewById(R.id.titreQuestionnaire_edittext);
        questionText = (EditText) findViewById(R.id.questionText_EditText);
        resp1 = (EditText) findViewById(R.id.reponse1_EditText);
        resp2 = (EditText) findViewById(R.id.reponse2_EditText);
        resp3 = (EditText) findViewById(R.id.reponse3_EditText);
        resp4 = (EditText) findViewById(R.id.reponse4_EditText);
        bonneReponseText = (EditText) findViewById(R.id.bonneReponse_EditText);

        createQuiz = (Button) findViewById(R.id.createQuiz_button);

        q1 = (Button) findViewById(R.id.question1_button);
        q2 = (Button) findViewById(R.id.question2_button);
        q3 = (Button) findViewById(R.id.question3_button);
        q4 = (Button) findViewById(R.id.question4_button);
        q5 = (Button) findViewById(R.id.question5_button);
        q6 = (Button) findViewById(R.id.question6_button);
        q7 = (Button) findViewById(R.id.question7_button);
        q8 = (Button) findViewById(R.id.question8_button);

        RequestQueue queue = Volley.newRequestQueue(this);

        nQuestion = 1;

        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestion(nQuestion);
                nQuestion = 1;
                recoverQuestion(nQuestion);
            }
        });

        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestion(nQuestion);
                nQuestion = 2;
                recoverQuestion(nQuestion);
            }
        });

        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestion(nQuestion);
                nQuestion = 3;
                recoverQuestion(nQuestion);
            }
        });

        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestion(nQuestion);
                nQuestion = 4;
                recoverQuestion(nQuestion);
            }
        });

        q5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestion(nQuestion);
                nQuestion = 5;
                recoverQuestion(nQuestion);
            }
        });

        q6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestion(nQuestion);
                nQuestion = 6;
                recoverQuestion(nQuestion);
            }
        });

        q7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestion(nQuestion);
                nQuestion = 7;
                recoverQuestion(nQuestion);
            }
        });

        q8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestion(nQuestion);
                nQuestion = 8;
                recoverQuestion(nQuestion);
            }
        });

        createQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences spref = getSharedPreferences(SHARED_PREF_USER_ID, MODE_PRIVATE);
                Map<String, Integer> s = (Map<String, Integer>) spref.getAll();

                int userId = s.get("id");

                ArrayList<Question> questions = createQuestionnaire();

                for(Question q : questions) {
                    String url = "http://192.168.56.1/insert_question.php";
                    StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println(response);
                            if (response.contains("done")) {
                                Toast.makeText(CreateQuiz.this, "Quiz créer avec succès", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CreateQuiz.this, MyQuiz.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                    }, new com.android.volley.Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // method to handle errors.
                                Toast.makeText(CreateQuiz.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                // below line we are creating a map for
                                // storing our values in key and value pair.
                                Map<String, String> params = new HashMap<String, String>();

                                params.put("titreQuestionnaire", questionnaireText.getText().toString());
                                params.put("intituleQuestion", q.getIntitule());
                                params.put("idUser", String.valueOf(userId));
                                params.put("reponse1", q.getReponse1());
                                params.put("reponse2", q.getReponse2());
                                params.put("reponse3", q.getReponse3());
                                params.put("reponse4", q.getReponse4());
                                params.put("bonneReponse", String.valueOf(q.getnReponse()));

                                // at last we are
                                // returning our params.
                                return params;
                            }
                        };

                    queue.add(request);
                    }
                };
            });
        }

    public void saveQuestion(int nQuestion) {
        switch (nQuestion) {
            case 1:
                question1 = questionText.getText().toString();
                reponse11 = resp1.getText().toString();
                reponse12 = resp2.getText().toString();
                reponse13 = resp3.getText().toString();
                reponse14 = resp4.getText().toString();
                bonneReponse1 = bonneReponseText.getText().toString();
                break;

            case 2:
                question2 = questionText.getText().toString();
                reponse21 = resp1.getText().toString();
                reponse22 = resp2.getText().toString();
                reponse23 = resp3.getText().toString();
                reponse24 = resp4.getText().toString();
                bonneReponse2 = bonneReponseText.getText().toString();
                break;

            case 3:
                question3 = questionText.getText().toString();
                reponse31 = resp1.getText().toString();
                reponse32 = resp2.getText().toString();
                reponse33 = resp3.getText().toString();
                reponse34 = resp4.getText().toString();
                bonneReponse3 = bonneReponseText.getText().toString();
                break;

            case 4:
                question4 = questionText.getText().toString();
                reponse41 = resp1.getText().toString();
                reponse42 = resp2.getText().toString();
                reponse43 = resp3.getText().toString();
                reponse44 = resp4.getText().toString();
                bonneReponse4 = bonneReponseText.getText().toString();
                break;

            case 5:
                question5 = questionText.getText().toString();
                reponse51 = resp1.getText().toString();
                reponse52 = resp2.getText().toString();
                reponse53 = resp3.getText().toString();
                reponse54 = resp4.getText().toString();
                bonneReponse5 = bonneReponseText.getText().toString();
                break;

            case 6:
                question6 = questionText.getText().toString();
                reponse61 = resp1.getText().toString();
                reponse62 = resp2.getText().toString();
                reponse63 = resp3.getText().toString();
                reponse64 = resp4.getText().toString();
                bonneReponse6 = bonneReponseText.getText().toString();
                break;

            case 7:
                question7 = questionText.getText().toString();
                reponse71 = resp1.getText().toString();
                reponse72 = resp2.getText().toString();
                reponse73 = resp3.getText().toString();
                reponse74 = resp4.getText().toString();
                bonneReponse7 = bonneReponseText.getText().toString();
                break;

            case 8:
                question8 = questionText.getText().toString();
                reponse81 = resp1.getText().toString();
                reponse82 = resp2.getText().toString();
                reponse83 = resp3.getText().toString();
                reponse84 = resp4.getText().toString();
                bonneReponse8 = bonneReponseText.getText().toString();
                break;
        }
    }

    public void recoverQuestion(int nQuestion) {
        switch (nQuestion) {
            case 1:
                questionText.setText(question1);
                resp1.setText(reponse11);
                resp2.setText(reponse12);
                resp3.setText(reponse13);
                resp4.setText(reponse14);
                bonneReponseText.setText(bonneReponse1);
                break;

            case 2:
                questionText.setText(question2);
                resp1.setText(reponse21);
                resp2.setText(reponse22);
                resp3.setText(reponse23);
                resp4.setText(reponse24);
                bonneReponseText.setText(bonneReponse2);
                break;

            case 3:
                questionText.setText(question3);
                resp1.setText(reponse31);
                resp2.setText(reponse32);
                resp3.setText(reponse33);
                resp4.setText(reponse34);
                bonneReponseText.setText(bonneReponse3);
                break;

            case 4:
                questionText.setText(question4);
                resp1.setText(reponse41);
                resp2.setText(reponse42);
                resp3.setText(reponse43);
                resp4.setText(reponse44);
                bonneReponseText.setText(bonneReponse4);
                break;

            case 5:
                questionText.setText(question5);
                resp1.setText(reponse51);
                resp2.setText(reponse52);
                resp3.setText(reponse53);
                resp4.setText(reponse54);
                bonneReponseText.setText(bonneReponse5);
                break;

            case 6:
                questionText.setText(question6);
                resp1.setText(reponse61);
                resp2.setText(reponse62);
                resp3.setText(reponse63);
                resp4.setText(reponse64);
                bonneReponseText.setText(bonneReponse6);
                break;

            case 7:
                questionText.setText(question7);
                resp1.setText(reponse71);
                resp2.setText(reponse72);
                resp3.setText(reponse73);
                resp4.setText(reponse74);
                bonneReponseText.setText(bonneReponse7);
                break;

            case 8:
                questionText.setText(question8);
                resp1.setText(reponse81);
                resp2.setText(reponse82);
                resp3.setText(reponse83);
                resp4.setText(reponse84);
                bonneReponseText.setText(bonneReponse8);
                break;
        }
    }

    public ArrayList<Question> createQuestionnaire() {
        saveQuestion(nQuestion);

        ArrayList<Question> listeQuestions = new ArrayList<Question>();

                Question q1 = null;
                Question q2 = null;
                Question q3 = null;
                Question q4 = null;
                Question q5 = null;
                Question q6 = null;
                Question q7 = null;
                Question q8 = null;

                if(questionnaireText.getText().toString()!=null) {
                    if (question1 != null && reponse11 != null && reponse12 != null && reponse13 != null && reponse14 != null && bonneReponse1!=null)
                        q1 = new Question(1, question1, reponse11, reponse12, reponse13, reponse14, Integer.valueOf(bonneReponse1));

                    if (question2 != null && reponse11 != null && reponse12 != null && reponse13 != null && reponse14 != null && bonneReponse2!=null)
                        q2 = new Question(2, question2, reponse21, reponse22, reponse23, reponse24, Integer.valueOf(bonneReponse2));

                    if (question3 != null && reponse31 != null && reponse32 != null && reponse33 != null && reponse34 != null && bonneReponse3!=null)
                        q3 = new Question(3, question3, reponse31, reponse32, reponse33, reponse34, Integer.parseInt(bonneReponse3));

                    if (question4 != null && reponse41 != null && reponse42 != null && reponse43 != null && reponse44 != null && bonneReponse4!=null)
                        q4 = new Question(4, question4, reponse41, reponse42, reponse43, reponse44, Integer.parseInt(bonneReponse4));

                    if (question5 != null && reponse51 != null && reponse52 != null && reponse53 != null && reponse54 != null && bonneReponse5!=null)
                        q5 = new Question(5, question5, reponse51, reponse52, reponse53, reponse54, Integer.parseInt(bonneReponse5));

                    if (question6 != null && reponse61 != null && reponse62 != null && reponse63 != null && reponse64 != null && bonneReponse6!=null)
                        q6 = new Question(6, question6, reponse61, reponse62, reponse63, reponse64, Integer.parseInt(bonneReponse6));

                    if (question7 != null && reponse71 != null && reponse72 != null && reponse73 != null && reponse74 != null && bonneReponse7!=null)
                        q7 = new Question(7, question7, reponse71, reponse72, reponse73, reponse74, Integer.parseInt(bonneReponse7));

                    if (question8 != null && reponse81 != null && reponse82 != null && reponse83 != null && reponse84 != null && bonneReponse8!=null)
                        q8 = new Question(8, question8, reponse81, reponse82, reponse83, reponse84, Integer.parseInt(bonneReponse8));
                }


                if(q1!=null)
                    listeQuestions.add(q1);

                if(q2!=null)
                    listeQuestions.add(q2);

                if(q3!=null)
                    listeQuestions.add(q3);

                if(q4!=null)
                    listeQuestions.add(q4);

                if(q5!=null)
                    listeQuestions.add(q5);

                if(q6!=null)
                    listeQuestions.add(q6);

                if(q7!=null)
                    listeQuestions.add(q7);

                if(q8!=null)
                    listeQuestions.add(q8);

                return listeQuestions;

            }

    }
