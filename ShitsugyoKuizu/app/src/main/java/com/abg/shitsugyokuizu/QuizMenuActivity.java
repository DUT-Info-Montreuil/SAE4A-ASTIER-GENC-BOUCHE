package com.abg.shitsugyokuizu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.QuestionnaireJoue;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizMenuActivity extends AppCompatActivity {

        private Button lastQuiz1, lastQuiz2, lastQuiz3, lastQuiz4;
        private Button monthQuiz1, monthQuiz2, monthQuiz3, monthQuiz4;

        private TextView texte;

        private ImageButton profilButton, plusButton, interroButton, trophyButton;


        @Override
        protected void onCreate(Bundle savedInstanceState){
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

        }

}
