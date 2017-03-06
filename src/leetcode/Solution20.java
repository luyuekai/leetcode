/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author 卢跃凯
 */
public class Solution20 {

    public boolean isValid(String s) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("(", ")");
        hashMap.put("[", "]");
        hashMap.put("{", "}");
        if (s.length() % 2 != 0) {
            return false;
        }

//        StringBuffer sb = new StringBuffer(s);
        Stack st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            boolean flag = tmp.toString().equals("(") || tmp.toString().equals("[") || tmp.toString().equals("{");
//            if (i==0 && flag==false ) {
//                return false;
//            }

            if (flag == true) {
                st.push(tmp);
            } else {
                try {

                    String stackTop = (String) st.pop().toString();

                    if (tmp.toString().equals(hashMap.get(stackTop))) {
                        continue;
                    } else {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }

            }
        }
        if (st.empty()) {
              return true;
        }
        return false;
      
    }

}
