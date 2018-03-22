package com.plot3.FrediMobile;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Classe métier d'un club
 * Décrit les données d'un club
 */
public class Club {

    /**
     * ID du club
     */
    public int id;
    /**
     * Nom du club
     */
    public String nom;
    /**
     * Couleurs du club
     */
    public String couleurs;
    /**
     * Stade du club
     */
    public String stade;
    /**
     * nom du fichier contenant une image de l'écusson
     */
    public String fichierEcusson;
    /**
     * Classement dans le TOP 14
     */
    public int classement;

    /**
     * Constructeur
     * Construit un objet à partir d'un JSONObject
     * @param jsonObject
     */
    public Club(JSONObject jsonObject) {
        try {
            id = jsonObject.getInt("id");
            nom = jsonObject.getString("nom");
            couleurs = jsonObject.getString("couleurs");
            stade = jsonObject.getString("stade");
            fichierEcusson = jsonObject.getString("ecusson");
            classement = jsonObject.getInt("classement");
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
                Integer.toString(id),
                nom,
                couleurs,
                stade,
                fichierEcusson,
                Integer.toString(classement)
        };
        return data;
    }

}
