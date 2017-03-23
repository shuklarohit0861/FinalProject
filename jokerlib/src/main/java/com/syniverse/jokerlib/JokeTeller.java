package com.syniverse.jokerlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeTeller extends AppCompatActivity {

     private TextView jokes;
    String jokeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_teller);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent joke = getIntent();
        Bundle b = joke.getExtras();
        jokes =(TextView) findViewById(R.id.textViewJoker);
        if(b != null)
        {
            jokeString = b.getString("com.joker.is.funny");
            jokes.setText(jokeString);
        }


    }
}
