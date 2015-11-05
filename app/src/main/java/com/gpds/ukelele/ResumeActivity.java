package com.gpds.ukelele;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class ResumeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        insertData();
    }

    public void insertData() {
        TextView usernameText = (TextView) findViewById(R.id.userField);
        usernameText.setText(((Global) this.getApplication()).getUsu());
    }

}
