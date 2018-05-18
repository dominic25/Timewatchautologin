package com.itaim.timewatchautologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String STRcomp;
    String STRid;
    String STRpass;
    EditText GETcomp;
    EditText GETid;
    EditText GETpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ETcomp = (EditText)findViewById(R.id.comp);
        EditText ETid = (EditText)findViewById(R.id.id);
        EditText ETpass = (EditText)findViewById(R.id.pass);

        GETcomp = ETcomp;
        GETid = ETid;
        GETpass = ETpass;
        //Button enter = (Button)findViewById(R.id.enter);
        //Button exit = (Button)findViewById(R.id.exit);

    }

    public void enter(View v)
    {
        STRcomp = GETcomp.getText().toString();
        STRid = GETid.getText().toString();
        STRpass = GETpass.getText().toString();

        Intent intent = new Intent(this, Login.class);
        intent.putExtra("op", "enter");
        intent.putExtra("comp", STRcomp);
        intent.putExtra("id", STRid);
        intent.putExtra("pass", STRpass);
        startActivity(intent);
    }

    public void exit(View v)
    {
        Intent intent = new Intent(this, Login.class);
        intent.putExtra("op", "exit");
        intent.putExtra("comp", STRcomp);
        intent.putExtra("id", STRid);
        intent.putExtra("pass", STRpass);
        startActivity(intent);
    }
}
