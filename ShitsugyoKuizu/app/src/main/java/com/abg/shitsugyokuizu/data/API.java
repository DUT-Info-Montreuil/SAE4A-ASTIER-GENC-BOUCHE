package com.abg.shitsugyokuizu.data;

import com.abg.shitsugyokuizu.data.model.Question;
import com.abg.shitsugyokuizu.data.model.Questionnaire;
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

    @GET("getQuestionnaireDuMois.php")
    Call<List<QuestionnaireJoue>> getQuestionnaireDuMois();

    @GET("dernier_quiz_cree.php")
    Call<List<Questionnaire>> getDernierQuestionnaireCree(@Query("idUser")int id);

    @GET("vos_quiz_plus_joues.php")
    Call<List<Questionnaire>> getVosQuizPlusJoues(@Query("idUser")int id);

    @GET("getUser.php")
    Call<Utilisateur> getUtilisateur(@Query("nom") String nom);

    @GET("getAllQuiz.php")
    Call<List<Questionnaire>> getAllQuestionnaires();

    @GET("getIdQuestionnaireDuMois.php")
    Call<List<Question>> getQuestionDuQuesionnaire(@Query("idQuestionnaire")int id);

    @GET("getMaxid.php")
    Call<Integer> getMaxId();

    @GET("getCurrUser.php")
    Call<Utilisateur> getCurrUtilisateur();

    @GET("insert_question.php")
    Call<Question> insertQuestion(@Query("titreQuestionnaire") String titreQuestionnaire,
                                  @Query("intituleQuestion") String titreQuestion,
                                  @Query("reponse1") String reponse1,
                                  @Query("reponse2") String reponse2,
                                  @Query("reponse3") String reponse3,
                                  @Query("reponse4") String reponse4,
                                  @Query("bonneReponse") int iBonneReponse);

    @GET("getQuestJoueur.php")
    Call<List<Questionnaire>> getQuestJoueur();

}
