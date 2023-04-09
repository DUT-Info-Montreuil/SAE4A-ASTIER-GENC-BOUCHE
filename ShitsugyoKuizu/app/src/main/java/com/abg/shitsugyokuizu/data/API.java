package com.abg.shitsugyokuizu.data;

import com.abg.shitsugyokuizu.data.model.QuestionnaireJoue;
import com.abg.shitsugyokuizu.data.model.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("dernier_quiz.php")
    Call<List<QuestionnaireJoue>> getQuestionnaire(@Query("id")int id);

    @GET("getUser.php")
    Call<Utilisateur> getUtilisateur(@Query("nom") String nom);

}
