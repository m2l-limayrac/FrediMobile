package com.plot3.FrediMobile;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Classe métier d'un club
 * Décrit les données d'un club
 */
public class LigneDeFrais {

    /**
     * ID de la ligne de frais
     */
    public int id_Ligne;
    /**
     * Date de la ligne de frais
     */
    public String date;
    /**
     * nombres de km de la ligne
     */
    public int Km;
    /**
     * cout du peage de la ligne
     */
    public int CoutPeage;

    /**
     * cout du repas de la ligne
     */
    public int CoutRepas;

    /**
     * Cout Hebergement de la ligne
     */
    public int CoutHebergement;
    /**
     * trajet de la ligne
     */
    public String Trajet;
    /**
     * Annee de la ligne
     */
    public int Annee;
    /**
     * Motif de la ligne
     */
    public String Motif;


    /**
     * Constructeur
     * Construit un objet à partir d'un JSONObject
     * @param jsonObject
     */
    public LigneDeFrais(JSONObject jsonObject) {
        try {
            id_Ligne = jsonObject.getInt("id_Ligne");
            date = jsonObject.getString("Date");
            Km = jsonObject.getInt("Km");
            CoutPeage = jsonObject.getInt("CoutPeage");
            CoutHebergement = jsonObject.getInt("CoutHebergement");
            Trajet = jsonObject.getString("Trajet");
            Annee = jsonObject.getInt("Annee");
            Motif = jsonObject.getString("Motif");
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
                Integer.toString(id_Ligne),
                date,
                Integer.toString(Km),
                Integer.toString(CoutPeage),
                Integer.toString(CoutHebergement),
                Integer.toString(CoutRepas),
                Trajet,
                Integer.toString(Annee),
                Motif
        };
        return data;
    }

}
