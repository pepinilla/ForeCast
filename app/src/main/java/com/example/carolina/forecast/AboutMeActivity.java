package com.example.carolina.forecast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 13/06/17.
 */

public class AboutMeActivity extends AppCompatActivity {
    @Bind(R.id.wbAboutMe)
    WebView wbAboutMe;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);
        ButterKnife.bind(this);

        wbAboutMe.setWebViewClient(new WebViewClient());

        wbAboutMe.loadUrl("http://www.gooogle.com");


    }
}
