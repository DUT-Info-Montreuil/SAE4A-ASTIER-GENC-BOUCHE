package com.abg.shitsugyokuizu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.QuestionnaireJoue;
import com.abg.shitsugyokuizu.data.model.Utilisateur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    TextView profilename;
    API apiprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilename = findViewById(R.id.textView2);
        apiprofile = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<Utilisateur> response = apiprofile.getCurrUtilisateur();
        apiprofile.getCurrUtilisateur().enqueue(new Callback<Utilisateur>() {


            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                Utilisateur user = response.body();
                if (response.body() != null){
                    System.out.println("Utilisateur trouvé");
                }

                profilename.setText(response.body().getPseudo());
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {

            }
        });
    }
}