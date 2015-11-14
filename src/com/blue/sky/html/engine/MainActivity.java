package com.blue.sky.html.engine;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;
import com.blue.sky.html.engine.test.x5.TestData;
import com.blue.sky.html.engine.test.x5.Thing;
import com.blue.sky.html.engine.test.x5.ThingBean;
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

        chunk.set("list", new String[]{"apples", "bananas", "carrots", "durian"});

        // getListMap() might return an array/list of Map objects
        // or an array/list of objects that implement com.x5.util.DataCapsule
        // or an object that implements com.x5.util.TableData
        chunk.set("mapList", TestData.getListMap());

        //Object Attribute
        Thing thing = new Thing("Bob Roberts","Major","AB231323");
        // Bob is his own boss. Circular references don't tie up the interpreter.
        thing.setBoss(thing);
        chunk.set("obj", thing);


        ThingBean bean = new ThingBean();
        bean.setName("Bob Roberts");
        bean.setRank("Major");
        bean.setSerial("AB231323");
        bean.setActive(true);

        // Bob is his own boss. Circular references don't tie up the interpreter.
        bean.setBoss(bean);

        chunk.setToBean("bean", bean);

        //Toast.makeText(this, chunk.toString(), Toast.LENGTH_SHORT).show();


        // how to use a string of HTML as the source of a WebView
        String html2 = chunk.toString();
        String mime = "text/html";
        String encoding = "utf-8";

        WebView myWebView = (WebView) this.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        // If you want to reference images from your assets folder,
        // use baseURL = "file:///android_res/raw/" instead of null here.
        String baseURL = null;
        myWebView.loadDataWithBaseURL(baseURL, html2, mime, encoding, null);
    }
}
