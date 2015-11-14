package com.blue.sky.html.engine.test.x5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caoli on 15/11/14.
 */
public class TestData {

    public static List<Map<String,String>>  getListMap(){

        List<Map<String,String>> list = new ArrayList<Map<String,String>>();

        Map<String,String> map = new HashMap<String,String>();
        map.put("name","carl");
        map.put("age","28");

        list.add(map);

        Map<String,String> map2 = new HashMap<String,String>();
        map2.put("name","sky");
        map2.put("age","25");

        list.add(map2);


        return list;

    }


}
