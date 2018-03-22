package com.ramiara.top14client;
//
// Top 14 client
//
// Authentification
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    // Récupère les views
    EditText myViewUser;
    EditText myViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Récupère les views
        myViewUser = (EditText) findViewById(R.id.et_user);
        myViewPassword = (EditText) findViewById(R.id.et_password);

    }


    /**
     * Quand on clique sur le bouton "Connecter"
     * @param view
     * TODO : ajouter le user et le mot de passe dans l'intent pour l'authentification
     */
    public void connecter(View view) {
        Intent myIntent = new Intent(this, ListActivity.class);
        startActivity(myIntent);
    }


}
