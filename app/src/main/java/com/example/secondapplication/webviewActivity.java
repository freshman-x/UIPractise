package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webviewActivity extends AppCompatActivity {

    private WebView mwebviewmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        mwebviewmain=findViewById(R.id.wv);
        //加载本地url
        //mwebviewmain.loadUrl("file:///android_asset/test.html");

        //加载网络url
        //mwebviewmain.getSettings().setJavaScriptEnabled(true);//可省略？
        mwebviewmain.setWebViewClient(new MyWebViewClient());//防止调用自带的浏览器
        mwebviewmain.setWebChromeClient(new MyWebChromeClient());
        //mwebviewmain.addJavascriptInterface();//保持native和JavaScript通信的方法
        mwebviewmain.loadUrl("https://m.baidu.com");
    }

    class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {//（拦截调用外部浏览器请求，在当前webview中记载页面？）
            view.loadUrl(request.getUrl().toString());//???
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","onPageStarted");//在日志中显示？
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","onPageFinished");
            //mwebviewmain.loadUrl("javascript:alert('hello')");                                    //同样效果
            mwebviewmain.evaluateJavascript("javascript:alert('hello')",null);//同样效果
        }
    }

    class MyWebChromeClient extends WebChromeClient
    {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {//加载进度条
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {// String title 是网页的title
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//设置返回效果
        if(keyCode==KeyEvent.KEYCODE_BACK&&mwebviewmain.canGoBack())
        {
            mwebviewmain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
