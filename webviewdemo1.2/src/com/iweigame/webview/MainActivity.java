package com.iweigame.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	
	  WebView myWebView ;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUserAgent(0);
        webSettings.setBuiltInZoomControls(true); //显示放大缩小 controler
        webSettings.setSupportZoom(true); //可以缩放
//        webSettings.setDefaultZoom(ZoomDensity.CLOSE);//默认缩放模式 是 ZoomDensity.MEDIUM
        myWebView.loadUrl("http://www.csdn.net");
       
    }
    
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
        	Log.v("tag", ">>>>>>>url is :"+ url);
            if (Uri.parse(url).getHost().equals("blog.csdn.net")) {
                // This is my web site, so do not override; let my WebView load the page
                return false;
            }
            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
    
    public void goForward(View view) {
        // Check if the key event was the Back button and if there's history
        if (myWebView.canGoForward()) {
            myWebView.goForward();
            
        }
    }
    public void goBack(View view) {
        // Check if the key event was the Back button and if there's history
        if (myWebView.canGoBack()) {
            myWebView.goBack();
           
        }
    
    }
}