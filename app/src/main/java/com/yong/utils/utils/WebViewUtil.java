package com.yong.utils.utils;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @Description: webView工具类
 * @Author: yong
 * @time 2020/6/28 14:06
 * @Version: 1.0
 */
public class WebViewUtil {

    /**
     * 支持H5
     *
     * @param mWebView
     * @param context
     */
    public static void supportH5(WebView mWebView, Context context) {
        //设置支持JS
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 设置支持本地存储
        mWebView.getSettings().setDatabaseEnabled(true);
        //取得缓存路径
        String path = context.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        //设置路径
        mWebView.getSettings().setDatabasePath(path);
        //设置支持DomStorage
        mWebView.getSettings().setDomStorageEnabled(true);
        //设置存储模式
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        //设置适应屏幕
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);
        //设置缓存
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.requestFocus();
        //下面三个各种监听
//        mWebView.setWebChromeClient(wcc);
//        mWebView.setDownloadListener(dl);
//        mWebView.setWebViewClient(wvc);
    }
}
