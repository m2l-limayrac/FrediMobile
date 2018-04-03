package com.plot3.FrediMobile;
//
// Top 14 client
//
// Tâche asynchrone lancée depuis ListActivity
// NOTA : on est obligé de lancer une tâche asynchrone car la connexion Internet peut prendre
// un certain temps, ce qui bloquerait ListActivity

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask<Void, Void, String> {

    public static final String EXTRA_MESSAGE = "com.plot3.FrediMobile.MESSAGE";

    // http://localhost/projets/top14server/clubs.php?user=jef&password=jefjef
    String MyURL = "http://192.168.150.68:80/Fredy/API/login.php"; //changer l'ip par mon ip locale
    String MyUser = "";
    String MyPassword = "";
    ListView myListView;
    Context myContext;
    ArrayList<LigneDeFrais> myLignes = new ArrayList<>();
    ArrayList<String> myArrayList = new ArrayList<>();
    Activity myActivity;

    /**
     * Constructeur
     *
     * @param listView la listView qui va recevoir le contenu
     */
    public MyAsyncTask(ListView listView, Activity activity,String user,String mdp) {
        super();
        myListView = listView;
        myContext = listView.getContext();
        myActivity = activity;
        MyUser = user;
        MyPassword = mdp;
    }

    /**
     * Quand on lance la tâche asynchrone (.execute() dans ListActivity)
     *
     * @param voids rien
     * @return Chaîne JSON
     */
    @Override
    protected String doInBackground(Void... voids) {
        String url = MyURL + "?user=" + MyUser + "&password=" + MyPassword;
        Log.d(MainActivity.LOG_TAG, "URL=" + url);
        // Accède à Internet, consomme un service Web en RESTful et renvoie un contenu JSON
        return NetworkUtils.request(url);
    }

    /**
     * Quand la tâche asynchrone est terminée
     *
     * @param jsonString le contenu JSON renvoyé par la méthode doInBackground()
     */
    @Override
    protected void onPostExecute(String jsonString) {
        Log.d("JESUIS", jsonString);
        super.onPostExecute(jsonString);

        // Interprète le contenu JSON pour récupérer le token
        if (jsonString != null) {
            try {
                // Récupère le contenu du fichier JSON
                JSONObject jsonObject = new JSONObject(jsonString);
                // Récupère la liste des clubs
                JSONArray lignesArray = jsonObject.getJSONArray("lesLignes");
                // Boucle de lecture des clubs
                for (int i = 0; i < lignesArray.length(); i++) {
                    JSONObject LDFJsonObject = lignesArray.getJSONObject(i);
                    LigneDeFrais LDF = new LigneDeFrais(LDFJsonObject);
                    myLignes.add(LDF);
                    myArrayList.add(LDF.Trajet);
                }

            } catch (Exception e) {
                Log.d(MainActivity.LOG_TAG, "Erreur lors de la lecture du fichier JSON");
                e.printStackTrace();
            }
        } else {
            Log.d(MainActivity.LOG_TAG, "Erreur : le fichier JSON est vide !");
        }

        // Remplit la listView
        // Crée l'adaptateur
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<>(myContext, android.R.layout.simple_list_item_1, myArrayList);

        // Associe l'adapteur à la listView
        myListView.setAdapter(myAdapter);

        // Ajoute un gestionnaire d'événement sous la forme d'une classe anonyme
        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        LigneDeFrais myLigne = myLignes.get(position);
                        String myData[] = myLigne.toArray();
                        Intent myIntent = new Intent(myContext, DetailsActivity.class);
                        myIntent.putExtra(EXTRA_MESSAGE, myData);
                        myActivity.startActivity(myIntent);
                        // test
                        String chaine = myAdapter.getItem(position);
                        Log.d(MainActivity.LOG_TAG, "Clic sur" + chaine);
                    }
                }
        );

    }
}
