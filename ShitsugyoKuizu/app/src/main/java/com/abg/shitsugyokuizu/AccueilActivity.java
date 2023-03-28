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
    private Button plusButton, interroButton, trophyButton;
    private ImageButton profilButton;

    public final String urlApi ="http://127.0.0.1/recupQuizAccueil_app.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


        lastQuiz1.findViewById(R.id.dernierQuizUn_button);
        lastQuiz2.findViewById(R.id.dernierQuizDeux_button);
        lastQuiz3.findViewById(R.id.dernierQuizTrois_button);
        lastQuiz4.findViewById(R.id.dernierQuizQuatre_button);

        monthQuiz1.findViewById(R.id.quizDuMoisUn_button);
        monthQuiz2.findViewById(R.id.quizDuMoisDeux_button);
        monthQuiz3.findViewById(R.id.quizDuMoisTrois_button);
        monthQuiz4.findViewById(R.id.quizDuMoisQuatre_button);

        plusButton.findViewById(R.id.plus_button);
        interroButton.findViewById(R.id.interro_button);
        trophyButton.findViewById(R.id.trophy_button);
        profilButton.findViewById(R.id.account_button);

        RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest(Request.Method.POST, urlApi, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(AccueilActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }

            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> parametres = new HashMap<>();
                    return parametres;
                }
            };

            queue.add(request);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, MyQuiz.class);
                startActivity(intent);
            }
        });

        interroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, AllQuizz.class);
                startActivity(intent);
            }
        });

//        trophyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(AccueilActivity.this, trophies.class);
//                startActivity(intent);
//            }
//        });
    }
}