package com.robosh.augumentedreality

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Base64
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WebView.setWebContentsDebuggingEnabled(true);
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(WebAppInterface(this), "Android")

        val unencodedHtml = "<!doctype html>\n" +
                "<html lang=en >\n" +
                "<head>\n" +
                "<title>Rewolution With Dumping Circular Wawes</title>\n" +
                "<meta charset=utf-8 >\n" +
                "<meta name=viewport content=width=device-width,user-scalable=no,minimum-scale=1.0,maximum-scale=1.0 >\n" +
                "</head>\n" +
                "<body>\n" +
                "<input type=\"button\" value=\"Say hello\" onClick=\"showAndroidToast('Hello Android!')\" />\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "    let a = 0;\n" +
                " function putValue(value) {\n" +
                "  a = value;\n" +
                " }\n" +
                "    function showAndroidToast(toast) {\n" +
                "        Android.showToast(a);\n" +
                "    }\n" +
                "</script>" +
                "dasdas\n" +
                "\n" +
                "</body>\n" +
                "</html>"
        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)

        androidButton.setOnClickListener {
            webView.loadUrl("javascript:showAndroidToast('Hello Android!')")
        }
        putValueButton.setOnClickListener {
            webView.loadUrl("javascript:putValue(5)")
        }
        webView.loadData(encodedHtml, "text/html", "base64")
    }
}