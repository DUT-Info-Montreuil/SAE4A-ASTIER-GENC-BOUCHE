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

        mAnswerButton1.setOnClickListener((View.OnClickListener) this);
        mAnswerButton2.setOnClickListener((View.OnClickListener) this);
        mAnswerButton3.setOnClickListener((View.OnClickListener) this);
        mAnswerButton4.setOnClickListener((View.OnClickListener) this);


        Intent i = getIntent();
        int idQuizz = i.getIntExtra("id",-1);
        if (idQuizz!=-1){
            
        }

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mRemainingQuestionCount = savedInstanceState.getInt(BUNDLE_STATE_QUESTION_COUNT);
            //questionnaire = SELECT * IN questionnaire where id = selectedID;
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


}