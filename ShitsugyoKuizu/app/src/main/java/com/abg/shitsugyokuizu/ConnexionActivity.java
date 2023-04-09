package com.abg.shitsugyokuizu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.Utilisateur;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;

public class ConnexionActivity extends AppCompatActivity {
    private EditText pseudo;
    private EditText mdp;
    private Button connexion;
    private Button inscription;

    private static final String SHARED_PREF_USER_ID = "SHARED_PREF_USER_ID";

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

                String url = "http://192.168.56.1/connexion_app.php?pseudo=" + pseudo.getText().toString() + "&mdp=" + mdp.getText().toString();
                StringRequest request = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(ConnexionActivity.this, response, Toast.LENGTH_SHORT).show();
                        if(response.contains("Connecte")) {
                            recupId();
                            Intent intent = new Intent(ConnexionActivity.this, AccueilActivity.class);
                            startActivity(intent);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Erreur connexion");
                    }

                });
                
                queue.add(request);
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

    public void recupId(){
        API api = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<Utilisateur> uti = api.getUtilisateur(pseudo.getText().toString());
        uti.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, retrofit2.Response<Utilisateur> response) {
                Utilisateur user = response.body();
                SharedPreferences spref = getSharedPreferences(SHARED_PREF_USER_ID, MODE_PRIVATE);
                SharedPreferences.Editor edit = spref.edit();
                edit.clear();
                edit.putInt("id", user.getId());
                edit.apply();
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                Toast.makeText(ConnexionActivity.this, "Bruh", Toast.LENGTH_SHORT).show();
            }
        });
    }


}