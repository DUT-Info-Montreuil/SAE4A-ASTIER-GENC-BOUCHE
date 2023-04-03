package com.abg.shitsugyokuizu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AccueilActivity extends AppCompatActivity {

    private Button lastQuiz1, lastQuiz2, lastQuiz3, lastQuiz4;
    private Button monthQuiz1, monthQuiz2, monthQuiz3, monthQuiz4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

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