package com.abg.shitsugyokuizu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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
            }
        });

        interroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyQuiz.this, AllQuizz.class);
                startActivity(intent);
            }
        });

//        trophyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MyQuiz.this, trophies.class);
//                startActivity(intent);
//            }
//        });
    }
}