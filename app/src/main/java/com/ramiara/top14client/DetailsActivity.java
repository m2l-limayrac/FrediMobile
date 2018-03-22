package com.ramiara.top14client;
//
// Top 14 client
//
// Détails du club
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    Intent myIntent;
    TextView myViewId;
    TextView myViewNom;
    TextView myViewCouleurs;
    TextView myViewStade;
    TextView myViewEcusson;
    TextView myViewClassement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Récupère les données à afficher
        myIntent = getIntent();
        String myData[] = myIntent.getStringArrayExtra(MyAsyncTask.EXTRA_MESSAGE);

        // Affiche les données dans le layout
        myViewId = (TextView) findViewById(R.id.tv_id);
        myViewId.setText("ID : " + myData[0]);

        myViewNom = (TextView) findViewById(R.id.tv_nom);
        myViewNom.setText(myData[1]);

        myViewCouleurs = (TextView) findViewById(R.id.tv_couleurs);
        myViewCouleurs.setText("Couleurs : " + myData[2]);

        myViewStade = (TextView) findViewById(R.id.tv_stade);
        myViewStade.setText("Stade : " + myData[3]);

        myViewEcusson = (TextView) findViewById(R.id.tv_ecusson);
        myViewEcusson.setText("Ecusson : " + myData[4]);

        myViewClassement = (TextView) findViewById(R.id.tv_classement);
        myViewClassement.setText("Classement : " + myData[5]);

    }
}
