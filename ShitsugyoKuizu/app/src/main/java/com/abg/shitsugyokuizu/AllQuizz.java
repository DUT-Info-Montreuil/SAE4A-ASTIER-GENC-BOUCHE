package com.abg.shitsugyokuizu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.abg.shitsugyokuizu.data.API;
import com.abg.shitsugyokuizu.data.RetrofitClientInstance;
import com.abg.shitsugyokuizu.data.model.DatabaseHelper;
import com.abg.shitsugyokuizu.data.model.Questionnaire;
import com.abg.shitsugyokuizu.data.model.QuestionnaireAdapter;
import com.abg.shitsugyokuizu.data.model.QuestionnaireJoue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllQuizz extends AppCompatActivity {
    private SearchView searchBar;
    private RecyclerView recyclerViewMenu;
    ArrayList<Questionnaire> lesQuiz = new ArrayList<Questionnaire>();
    private QuestionnaireAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_quizz);

        API api = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        Call<List<Questionnaire>> getAllQuiz = api.getAllQuestionnaires();
        getAllQuiz.enqueue(new Callback<List<Questionnaire>>() {
            @Override
            public void onResponse(Call<List<Questionnaire>> call, Response<List<Questionnaire>> response) {
                List<Questionnaire> questionnaires = response.body();

                if(!response.body().isEmpty()) {
                    System.out.println("Quiz chargés");
                }

                for(Questionnaire q : questionnaires) {
                    lesQuiz.add(q);
                }
            }

            @Override
            public void onFailure(Call<List<Questionnaire>> call, Throwable t) {

            }
        });

        menuAdapter = new QuestionnaireAdapter(lesQuiz);

        // Création d'un LinearLayoutManager pour afficher les éléments en liste déroulante
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // Configuration du RecyclerView avec l'adapter et le layout manager
        recyclerViewMenu = findViewById(R.id.recyclerview_menu);
        recyclerViewMenu.setAdapter(menuAdapter);
        recyclerViewMenu.setLayoutManager(layoutManager);

//        searchBar = (SearchView) findViewById(R.id.quiz_searchbar);
//        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//                menuAdapter.filter(s);
//                System.out.println(menuAdapter.getItemCount());
//                return false;
//            }
//        });

    }

}