package edu.alb77681ucmo.amyborgstadta2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by alb77 on 3/19/2018.
 */

public class FragmentWebView Fragment {

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSavedInstanceState(outState);
        outState.putString("currentURL", mURL);
    }

    public void setURLContent(String URL) {
        mURL = URL;
    }

    public void updateURLContent(String URL) {
        mURL = URL;
        WebView myWebView = (WebView) getView().findViewById(R.id.pageInfo);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.loadUrl(mURL.trim());
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }

}

