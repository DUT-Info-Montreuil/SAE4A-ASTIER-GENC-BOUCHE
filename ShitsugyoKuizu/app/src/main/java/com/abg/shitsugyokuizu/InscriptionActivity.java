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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class InscriptionActivity extends AppCompatActivity{

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

//        inscription.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "http://192.168.1.34/inscription_app.php?pseudo="+ pseudo.getText().toString() + "&email=" + email.getText().toString() + "&mdp="+ mdp.getText().toString();
//                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        System.out.println(response);
//                        if(response.contains("Inscription done")) {
//                            Intent intent = new Intent(InscriptionActivity.this, AccueilActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        System.out.println("Erreur inscription");
//                    }
//                });
//
//                queue.add(request);
//            }
//        });

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String url = "http://192.168.56.1/inscription_app.php";
                    StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            // on below line we are displaying a success toast message.
                            Toast.makeText(InscriptionActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                            try {
                                // on below line we are parsing the response
                                // to json object to extract data from it.
                                JSONObject respObj = new JSONObject(response);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new com.android.volley.Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // method to handle errors.
                            Toast.makeText(InscriptionActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            // below line we are creating a map for
                            // storing our values in key and value pair.
                            Map<String, String> params = new HashMap<String, String>();

                            params.put("pseudo", pseudo.getText().toString());
                            params.put("email", email.getText().toString());
                            params.put("mdp", mdp.getText().toString());

                            // at last we are
                            // returning our params.
                            return params;
                        }
                    };

                    queue.add(request);
                }
        });
    }
}