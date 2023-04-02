package com.abg.shitsugyokuizu;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class InscriptionActivity extends AppCompatActivity implements AsyncResponse{

    private EditText pseudo;
    private EditText email;
    private EditText mdp;
    private EditText confirmMdp;
    private Button inscription;
    private String result ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        pseudo = findViewById(R.id.login_Edit_Text);
        email = findViewById(R.id.email_Edit_Text);
        mdp = findViewById(R.id.mdp_Edit_Text);
        confirmMdp = findViewById(R.id.confirmMdp_Edit_Text);
        inscription = findViewById(R.id.inscription_Button);
        RequestQueue queue = Volley.newRequestQueue(this);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.56.1/inscription_app.php?pseudo="+ pseudo.getText().toString() + "&email=" + email.getText().toString() + "&mdp="+ mdp.getText().toString();
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.contains("Inscription réussie")) {
                            Intent intent = new Intent(InscriptionActivity.this, AccueilActivity.class);
                            startActivity(intent);
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Erreur inscription");                    }
                });

                queue.add(request);
            }
        });
    }

    @Override
    public void processFinish(String output) {
        this.result = output;
    }

}