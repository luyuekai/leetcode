/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeArray;

import java.util.HashMap;
import java.util.Map;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-8-23
 *
 */
public class Solution621 {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < tasks.length; i++) {
            char task = tasks[i];
            if (map.containsKey(task)) {
                int tmp = map.get(task);
                map.put(task, tmp + 1);
            } else {
                map.put(task, 1);
            }

        }

        return -1;

    }

}
