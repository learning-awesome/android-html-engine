package com.blue.sky.html.engine;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;
import com.x5.template.Chunk;
import com.x5.template.Theme;
import com.x5.template.providers.AndroidTemplates;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        String themesPath = "/path/to/my/templates";
//        String layerNames = "";   // no layers
//
//        Theme theme1 = new Theme(themesPath, layerNames);
//
//        // Load up the main template in /path/to/my/templates/my_template.chtml
//        Chunk html = theme1.makeChunk("my_template");
//
//        Theme theme2 = new Theme();


        AndroidTemplates loader = new AndroidTemplates(getBaseContext(), "x5");
        Theme theme = new Theme(loader);
        Chunk chunk = theme.makeChunk("index#test");
        Toast.makeText(this, chunk.toString(), Toast.LENGTH_SHORT).show();


        // how to use a string of HTML as the source of a WebView
        String html2 = chunk.toString();
        String mime = "text/html";
        String encoding = "utf-8";

        WebView myWebView = (WebView)this.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        // If you want to reference images from your assets folder,
        // use baseURL = "file:///android_res/raw/" instead of null here.
        String baseURL = null;
        myWebView.loadDataWithBaseURL(baseURL, html2, mime, encoding, null);
    }
}
