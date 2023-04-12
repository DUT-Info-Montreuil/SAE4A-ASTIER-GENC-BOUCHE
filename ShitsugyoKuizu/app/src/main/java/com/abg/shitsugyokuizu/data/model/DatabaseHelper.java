package com.abg.shitsugyokuizu.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MaBaseDeDonnees.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase bd;

    // Requête SQL pour créer la table
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE allQuiz (" +
                    "idQuestionnaire INTEGER PRIMARY KEY," +
                    "idUtilisateur INTEGER," +
                    "intitule TEXT, " +
                    "dateDeCreation datetime" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        bd = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Écrire le code pour la mise à jour de la base de données
    }

    public void insertQuiz(Questionnaire quiz) {
        //SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("idQuestionnaire", quiz.getIdQuestionnaire());
        values.put("idUtilisateur", quiz.getIdUtilisateur());
        values.put("intitule", quiz.getIntitule());
        //values.put("dateDeCreation", quiz.getDateDeCreation().toString());

        bd.insert("allQuiz", null, values);
        bd.close();
    }

    public ArrayList<Questionnaire> getAllQuiz() throws ParseException {
        ArrayList<Questionnaire> allQuiz = new ArrayList<Questionnaire>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM allQuiz", null);

        if (cursor.moveToFirst()) {
            do {
                Questionnaire quest = new Questionnaire();

                quest.setIdQuestionnaire(Integer.parseInt(cursor.getString(0)));
                quest.setIdUtilisateur(Integer.parseInt(cursor.getString(1)));
                quest.setIntitule(cursor.getString(2));
                SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                Date date = (Date) s.parse(cursor.getString(3));
                //quest.setDateDeCreation(date);

                allQuiz.add(quest);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        if(allQuiz.isEmpty())
            System.out.println("Quiz vide");
        return allQuiz;
    }
}