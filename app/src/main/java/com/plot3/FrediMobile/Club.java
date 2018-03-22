package com.plot3.FrediMobile;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Classe métier d'un club
 * Décrit les données d'un club
 */
public class NoteDeFrais {

    /**
     * ID de la note de frais
     */
    public int Id_NoteDeFrais;
    /**
     * boolean de la note de frais
     */
    public boolean isValidate;
    /**
     * Collection des lignes de frais
     */
    public ArrayList<> lesLignes;

    /**
     * Constructeur
     * Construit un objet à partir d'un JSONObject
     * @param jsonObject
     */
    public NoteDeFrais(JSONObject jsonObject) {
        try {
            Id_NoteDeFrais = jsonObject.getInt("Id_NoteDeFrais");
            isValidate = jsonObject.getBoolean("isValidate");
            lesLignes = jsonObject.getJSONObject("lesLignes");
        } catch (JSONException e) {
            Log.d(MainActivity.LOG_TAG,"Erreur lors de la conversion de l'objet JSON en objet Club");
            e.printStackTrace();
        }
    }

    /**
     * Convertit l'objet courant en array
     * @return le tableau
     */
    public String[] toArray() {
        String data[] = {
                Integer.toString(Id_NoteDeFrais),
                Boolean.toString(isValidate)
        };
        return data;
    }

}
