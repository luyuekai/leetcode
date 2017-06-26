/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacheModel;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-5-4
 *
 */
public class Test0504 {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");
        map.put("apple", "苹果2");
        map.put("peach#3", "桃子");
        map.put("watermelon", "西sdfg");
        map.put("apple", "苹果456");
        map.get("banana");
        map.put("apple", "苹果456");
        map.put("peach", "桃子");

//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        } 
        String key = map.entrySet().iterator().next().getKey();
        key = key.split("#")[0];
        System.out.println(""+ key);
        System.out.println(map.remove("123"));

//        System.out.println(map.entrySet().iterator().next().getValue() + " " + map.entrySet().iterator().next().getKey());
    }

}
