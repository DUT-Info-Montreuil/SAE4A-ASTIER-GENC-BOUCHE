package com.abg.shitsugyokuizu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ResponseDelivery;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ConnexionActivity extends AppCompatActivity {
    private EditText pseudo;
    private EditText mdp;
    private Button connexion;
    private Button inscription;

    public final String urlApi ="http://192.168.56.1/connexion_app.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        pseudo = findViewById(R.id.login_Edit_Text);
        mdp = findViewById(R.id.mdp_Edit_Text);
        connexion = findViewById(R.id.Connexion_Button);
        inscription = findViewById(R.id.Inscription_Button);
        RequestQueue queue = Volley.newRequestQueue(this);


        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringRequest request = new StringRequest(Request.Method.POST, urlApi,
                        new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ConnexionActivity.this, response, Toast.LENGTH_SHORT).show();
                        if(response.equals("true")) {
                            Intent intent = new Intent(ConnexionActivity.this, AccueilActivity.class);
                            startActivity(intent);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        
                    }

                }){
                    @Override
                    protected Map<String, String> getParams(){
                        Map<String, String> parametres = new HashMap<>();
                        parametres.put("pseudo", pseudo.getText().toString());
                        parametres.put("mdp", mdp.getText().toString());
                        return parametres;
                    }
                };
                
                queue.add(request);
                queue.start();
            }

        });

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInscription = new Intent(ConnexionActivity.this, InscriptionActivity.class);
                startActivity(intentInscription);
            }
        });


    }


}