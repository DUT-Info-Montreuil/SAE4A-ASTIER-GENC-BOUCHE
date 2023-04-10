package com.abg.shitsugyokuizu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.Question;
import com.abg.shitsugyokuizu.data.model.Questionnaire;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

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

                ArrayList<Question> questions = createQuestionnaire();

                for(Question q : questions) {
                    String url = "http://192.168.56.1/insert_question.php?titreQuestionnaire="
                            + q.getTitreQuestionnaire() + "&intituleQuestion=" + q.getTitleQues()
                            + "&reponse1=" + q.getReponse1() + "&reponse2=" + q.getReponse2()
                            + "&reponse3=" + q.getReponse3() + "&reponse4=" + q.getReponse4() +
                            "&bonneReponse=" +q.getnReponse();
                    StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println(response);
                            if(response.contains("done")) {
                                Toast.makeText(CreateQuiz.this, "Nice", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("Erreur inscription");                    }
                    });

                    queue.add(request);
                }
            }
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
        for (int i = 1; i<=8; i++) {
            saveQuestion(i);
        }

        Question q1 = new Question(questionnaireText.getText().toString(), question1, reponse11, reponse12, reponse13, reponse14, Integer.valueOf(bonneReponse1));
//        Question q2 = new Question(question2, reponse21, reponse22, reponse23, reponse24, Integer.parseInt(bonneReponse2));
//        Question q3 = new Question(question3, reponse31, reponse32, reponse33, reponse34, Integer.parseInt(bonneReponse3));
//        Question q4 = new Question(question4, reponse41, reponse42, reponse43, reponse44, Integer.parseInt(bonneReponse4));
//        Question q5 = new Question(question5, reponse51, reponse52, reponse53, reponse54, Integer.parseInt(bonneReponse5));
//        Question q6 = new Question(question6, reponse61, reponse62, reponse63, reponse64, Integer.parseInt(bonneReponse6));
//        Question q7 = new Question(question7, reponse71, reponse72, reponse73, reponse74, Integer.parseInt(bonneReponse7));
//        Question q8 = new Question(question8, reponse81, reponse82, reponse83, reponse84, Integer.parseInt(bonneReponse8));

        ArrayList<Question> listeQuestions = new ArrayList<Question>();

        listeQuestions.add(q1);
//        listeQuestions.add(q2);
//        listeQuestions.add(q3);
//        listeQuestions.add(q4);
//        listeQuestions.add(q5);
//        listeQuestions.add(q6);
//        listeQuestions.add(q7);
//        listeQuestions.add(q8);

        return listeQuestions;
    }
}