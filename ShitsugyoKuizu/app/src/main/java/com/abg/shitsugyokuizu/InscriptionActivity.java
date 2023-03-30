package com.abg.shitsugyokuizu;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;

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

public class InscriptionActivity extends AppCompatActivity {

    private EditText pseudo;
    private EditText email;
    private EditText mdp;
    private EditText confirmMdp;
    private Button inscription;

    public final String urlApi ="http://127.0.0.1/inscription_app.php";

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
               if(confirmMdp.getText().toString().equals(mdp.getText().toString())) {
                    String pseudoi = pseudo.getText().toString();
                    String emaili = email.getText().toString();
                    String password = mdp.getText().toString();
                    String url = "http://192.168.56.1/inscription_app.php"; //A modifier selon les machines
                    String type = "login";
                    BackgroundWorker backgroundWorker = new BackgroundWorker(InscriptionActivity.this);
                    backgroundWorker.execute(url,type,pseudoi,emaili,password);
                } else {
                    Toast.makeText(InscriptionActivity.this,
                            "Les mots de passes ne correspondent pas",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}