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
    private Button plusButton, interroButton, trophyButton;
    private ImageButton profilButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_quiz);

        quizPlusJoue1.findViewById(R.id.quizPlusJouesUn_button);
        quizPlusJoue2.findViewById(R.id.quizPlusJouesDeux_button);
        quizPlusJoue3.findViewById(R.id.quizPlusJouesTrois_button);
        quizPlusJoue4.findViewById(R.id.quizPlusJouesQuatre_button);

        dernierQuizCree1.findViewById(R.id.dernierQuizCreeUn_button);
        dernierQuizCree2.findViewById(R.id.dernierQuizCreeDeux_button);
        dernierQuizCree3.findViewById(R.id.dernierQuizCreeTrois_button);
        dernierQuizCree4.findViewById(R.id.dernierQuizCreeQuatre_button);

        plusButton.findViewById(R.id.plusMyQuiz_button);
        interroButton.findViewById(R.id.interroMyQuiz_button);
        trophyButton.findViewById(R.id.trophyMyQuiz_button);
        profilButton.findViewById(R.id.accountMyQuiz_button);

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