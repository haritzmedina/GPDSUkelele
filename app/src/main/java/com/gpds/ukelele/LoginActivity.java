package com.gpds.ukelele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gpds.ukelele.db.DBManager;
import com.gpds.ukelele.db.User;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chords, menu);
        return true;
    }

    public void login(View view){
        // Retrieve textboxes
        EditText usernameText = (EditText) findViewById(R.id.usernameTextbox);
        EditText passwordText = (EditText) findViewById(R.id.passwordTextbox);
        // Retrieve value from textboxes
        String loginUsername = usernameText.getText().toString();
        String loginPassword = passwordText.getText().toString();
        // Create mock user
        User loginUser = new User(loginUsername, loginPassword);

        // Create the database manager
        DBManager dbManager = new DBManager(this.getApplicationContext());

        // Retrieve from database the username and password
        User dbUser = dbManager.retrieveUser(loginUser);

        // If username and password match, login correct
        if(loginUser.equals(dbUser)){
            // TODO Save current logged username

            // Open main activity
            Intent i = new Intent("com.gpds.ukelele.MainActivity");
            startActivity(i);
        }
        else{
            // Prompt username or pass error
            Toast.makeText(this.getApplicationContext(), "Bad username or password.", Toast.LENGTH_SHORT).show();
            passwordText.clearComposingText();

        }
    }

    public void singup(View view){
        // Retrieve textboxes
        EditText usernameText = (EditText) findViewById(R.id.usernameTextbox);
        EditText passwordText = (EditText) findViewById(R.id.passwordTextbox);
        // Retrieve value from textboxes
        String loginUsername = usernameText.getText().toString();
        String loginPassword = passwordText.getText().toString();
        // Create mock user
        User signUpUser = new User(loginUsername, loginPassword);

        // Create the database manager
        DBManager dbManager = new DBManager(this.getApplicationContext());

        // Retrieve from database the username and password
        dbManager.createUser(signUpUser);

        // Prompt user created
        Toast.makeText(this.getApplicationContext(), "User created, please log in.", Toast.LENGTH_SHORT).show();
    }
}
