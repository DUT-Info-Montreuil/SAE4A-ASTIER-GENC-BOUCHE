package com.abg.shitsugyokuizu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private boolean mEnableTouchEvents;

    private int mScore;
    private int mRemainingQuestionCount;
    private int selectedID;
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

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mRemainingQuestionCount = savedInstanceState.getInt(BUNDLE_STATE_QUESTION_COUNT);
            //questionnaire = SELECT * IN questionnaire where id = selectedID;
        }
        Intent i = getIntent();
        int id = i.getIntExtra("id", -1);
        System.out.println(id);
        if (id!=-1) {
            Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();

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
                            Intent intent = new Intent(QuizActivity.this,AccueilActivity.class);
                            startActivity(intent);
                            finish();
                        }


                    }


                    System.out.println(response.body());
                }

                @Override
                public void onFailure(Call<List<Question>> call, Throwable t) {
                    Toast.makeText(QuizActivity.this, "babaje", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //displayQuestion(questionnaire);
    }

    public void onClick(View v) {
        int index;

        if (v == mAnswerButton1) {
            index = 0;
        } else if (v == mAnswerButton2) {
            index = 1;
        } else if (v == mAnswerButton3) {
            index = 2;
        } else if (v == mAnswerButton4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }

        /*if (index == mQuestionBank.getCurrentQuestion().getAnswerIndex()) { A adapter avec l'API
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }*/

        mEnableTouchEvents = false;

        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;

                mRemainingQuestionCount--;

                /*if (mRemainingQuestionCount <= 0) { IDEM
                    endGame();
                } else {
                    displayQuestion(mQuestionBank.getNextQuestion());
                }*/
            }
        }, 2_000);
    }

    /*private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
        int questionId = SELECT id from question where questionnaireID = selectedID;

        ArrayList<String> answers = SELECT intulé from réponse where ID = questionId
        mTextViewQuestion.setText(SELECT intitulé from question where questionID = questionId);
        mAnswerButton1.setText(answers.get(0));
        mAnswerButton2.setText(answers.get(1));
        mAnswerButton3.setText(answers.get(2));
        mAnswerButton4.setText(answers.get(3));
    }*/

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION_COUNT, mRemainingQuestionCount);
        //outState.putSerializable(BUNDLE_STATE_QUESTION_BANK, Questionnaire);
    }

    private void endGame() {
        // No question left, end the game
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }
                })
                .create()
                .show();
    }
    public void chargementQuestion(Question question){
        mTextViewQuestion.setText(question.getIntitule());
        mAnswerButton1.setText(question.getReponse1());
        mAnswerButton2.setText(question.getReponse2());
        mAnswerButton3.setText(question.getReponse3());
        mAnswerButton4.setText(question.getReponse4());
    }


}