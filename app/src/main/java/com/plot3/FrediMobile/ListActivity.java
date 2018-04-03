package com.plot3.FrediMobile;
//
// Top 14 client
//
// Liste des clubs

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView  myListView;
    ArrayList<String> myArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        // Récupère la listView
        myListView = findViewById(R.id.lv_liste);

        Intent intent = getIntent();
        String chaine = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);
        String[] data = chaine.split("/");
        String user = data[0];
        String mdp = data[1];
        Log.d("monTag", user + mdp);

        // Récupère des infos sur l'état de la connexion Internet
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // Si la connexion Internet est OK
        if (networkInfo != null && networkInfo.isConnected() ) {
            Toast.makeText(getApplicationContext(), "Connexion en cours ...", Toast.LENGTH_LONG).show();
            // Lance la tâche asynchrone
            new MyAsyncTask(myListView,this, user, mdp).execute();
        } else {
            // Message d'erreur général
            Toast.makeText(getApplicationContext(), "Erreur : pas de connexion Internet !", Toast.LENGTH_LONG).show();
        }

    }

}
