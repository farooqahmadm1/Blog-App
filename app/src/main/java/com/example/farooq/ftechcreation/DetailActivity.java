package com.example.farooq.ftechcreation;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {
    ProgressBar progressBar;
    WebView webView;
    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        webView = (WebView) findViewById(R.id.detailView);
        progressBar=(ProgressBar)  findViewById(R.id.progerssBar);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        webView.setVisibility(View.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                webView.loadUrl("javascript:(function() {" + "document.getElementsByTagName('header')[0].style.display = 'none'; " + "})()");
                webView.loadUrl("javascript:(function() {" + "document.getElementsByClassName('page_body')[0].style.padding='0px'; })()");
            }
        });
        webView.loadUrl(getIntent().getStringExtra("url").toString());

    }
}