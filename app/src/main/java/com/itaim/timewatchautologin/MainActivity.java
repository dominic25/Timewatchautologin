package com.itaim.timewatchautologin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String STRcomp;
    String STRid;
    String STRpass;
    EditText GETcomp;
    EditText GETid;
    EditText GETpass;
    CheckBox Gsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText ETcomp = (EditText)findViewById(R.id.comp);
        EditText ETid = (EditText)findViewById(R.id.id);
        EditText ETpass = (EditText)findViewById(R.id.pass);
        CheckBox save = (CheckBox)findViewById(R.id.savepass);

        SharedPreferences prefs = getSharedPreferences("save data", MODE_PRIVATE);
        String comp = prefs.getString("comp", "No comp defined");//"No name defined" is the default value.
        String id = prefs.getString("id", "No id defined");//"No name defined" is the default value.
        String pass = prefs.getString("pass", "No pass defined");//"No name defined" is the default value.
        ETcomp.setText(comp);
        ETid.setText(id);
        ETpass.setText(pass);

        GETcomp = ETcomp;
        GETid = ETid;
        GETpass = ETpass;
        Gsave = save;
    }

    public void enter(View v)
    {

        STRcomp = GETcomp.getText().toString();
        STRid = GETid.getText().toString();
        STRpass = GETpass.getText().toString();

        if(Gsave.isChecked()){
            SharedPreferences.Editor editor = getSharedPreferences("save data", MODE_PRIVATE).edit();
            editor.putString("comp", STRcomp);
            editor.putString("id", STRid);
            editor.putString("pass", STRpass);
            editor.apply();
        }
        Intent intent = new Intent(this, Login.class);
        intent.putExtra("op", "enter");
        intent.putExtra("comp", STRcomp);
        intent.putExtra("id", STRid);
        intent.putExtra("pass", STRpass);
        startActivity(intent);
    }

    public void exit(View v)
    {
        if(Gsave.isChecked()) {
            SharedPreferences.Editor editor = getSharedPreferences("save data", MODE_PRIVATE).edit();
            editor.putString("comp", STRcomp);
            editor.putString("id", STRid);
            editor.putString("pass", STRpass);
            editor.apply();
        }
        Intent intent = new Intent(this, Login.class);
        intent.putExtra("op", "exit");
        intent.putExtra("comp", STRcomp);
        intent.putExtra("id", STRid);
        intent.putExtra("pass", STRpass);
        startActivity(intent);
    }
}
