package com.sameer.buttontest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button tester;
    Button tester2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tester = (Button) findViewById(R.id.button);
        tester.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v){
                                              Log.d("Sam", "Button Clicked");
                                              Intent i = new Intent(MainActivity.this, Main2Activity.class);
                                              EditText editText = (EditText) findViewById(R.id.edit);
                                              i.putExtra(editText.getText().toString(), true);
                                              startActivity(i);
                                          }
                                      }
        );
        tester2 = (Button) findViewById(R.id.button2);
        tester2.setOnClickListener(new View.OnClickListener()
                                       {
                                           @Override
                                           public void onClick (View v){
                                               Log.d("Sam", "Small Button Clicked");
                                           }
                                       }
        );
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        EditText editText = (EditText) findViewById(R.id.edit);
        outState.putString("text",editText.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        EditText editText = (EditText) findViewById(R.id.edit);
        editText.setText(savedInstanceState.getString("text"));
    }
}
