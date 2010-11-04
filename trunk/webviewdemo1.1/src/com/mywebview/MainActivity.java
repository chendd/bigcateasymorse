package com.mywebview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private static final String LOG_TAG = "WebViewDemo";

    private WebView mWebView;

    String  jsonText = "{\"name\":\"vsp\",\"password\":\"vsp\"}";
    
    private Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        mWebView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);

        mWebView.setWebChromeClient(new MyWebChromeClient());  

        mWebView.addJavascriptInterface(new DemoJavaScriptInterface(), "demo");

        mWebView.loadUrl("file:///android_asset/demo.html");
    }

    final class DemoJavaScriptInterface {

        DemoJavaScriptInterface() {
        }

        /**
         * This is not called on the UI thread. Post a runnable to invoke
         * loadUrl on the UI thread.
         */
        public void clickOnAndroid() {
        	
            mHandler.post(new Runnable() {
                public void run() {
                    mWebView.loadUrl("javascript:wave("+jsonText+")");
                }
            });

        }
       
    }

    /** 
     * Provides a hook for calling "alert" from javascript. Useful for 
     * debugging your javascript. 
     */  
    final class MyWebChromeClient extends WebChromeClient {  
        @Override  
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {  
            Log.d(LOG_TAG, message);  
            result.confirm();  
            return true;  
        }  
          
    }  

    
    
}