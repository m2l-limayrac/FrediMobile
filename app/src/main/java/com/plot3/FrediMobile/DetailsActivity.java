package com.plot3.FrediMobile;
//
// Top 14 client
//
// Détails du club
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    Intent myIntent;
    TextView myViewId;
    TextView myViewTrajet;
    TextView myViewDate;
    TextView myViewKm;
    TextView myViewCoutPeage;
    TextView myViewCoutHebergement;
    TextView myViewAnnee;
    TextView myViewCoutRepas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Récupère les données à afficher
        myIntent = getIntent();
        String myData[] = myIntent.getStringArrayExtra(MyAsyncTask.EXTRA_MESSAGE);
        Log.d("detail", myData.toString());
        // Affiche les données dans le layout
        myViewId = (TextView) findViewById(R.id.tv_id);
        myViewId.setText("ID : " + myData[0]);

        myViewTrajet = (TextView) findViewById(R.id.tv_trajet);
        myViewTrajet.setText(myData[6]);

        myViewDate = (TextView) findViewById(R.id.tv_date);
        myViewDate.setText("Date : " + myData[1]);

        myViewKm = (TextView) findViewById(R.id.tv_km);
        myViewKm.setText("Km : " + myData[2]);

        myViewCoutPeage = (TextView) findViewById(R.id.tv_coutPeage);
        myViewCoutPeage.setText("Coût Péage : " + myData[3]);

        myViewCoutHebergement = (TextView) findViewById(R.id.tv_coutHebergement);
        myViewCoutHebergement.setText("Coût Hebergement : " + myData[4]);

        myViewCoutRepas = (TextView) findViewById(R.id.tv_coutRepas);
        myViewCoutRepas.setText("Coût Repas : " + myData[4]);

        myViewAnnee = (TextView) findViewById(R.id.tv_Annee);
        myViewAnnee.setText("Coût Annee : " + myData[4]);

    }
}
