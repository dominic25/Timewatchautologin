package com.itaim.timewatchautologin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle extras = getIntent().getExtras();
        final String op = extras.getString("op");
        final String comp = extras.getString("comp");
        final String id = extras.getString("id");
        final String pass = extras.getString("pass");
        final String js = "javascript:let companyElem = document.getElementById('compKeyboard'); companyElem.value = '"+comp+"'; let usernameElem = document.getElementById('nameKeyboard'); usernameElem.value = '"+id+"'; let passwordElem = document.getElementById('pwKeyboard'); passwordElem.value = '"+pass+"'; var form = document.querySelector('#cpick'); form.submit()";
        WebView webView = (WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://checkin.timewatch.co.il/punch/punch.php");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                view.loadUrl(js);
            }
        });


    }
}
