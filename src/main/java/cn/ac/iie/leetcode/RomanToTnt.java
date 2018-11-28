package cn.ac.iie.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Description:
 *
 * @author naichun
 * @date 2018/11/19 下午10:57
 */
public class RomanToTnt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (null == s || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return map.get(s.charAt(0)).intValue();
        }else{
            int current = map.get(s.charAt(0)).intValue();
            int num = 0;
            char[] stringChars = s.toCharArray();
            for(int i = 1;i<stringChars.length;i++){
                int next = map.get(stringChars[i]).intValue();
                if(next > current){
                    num = num - current;
                }else {
                    num = num + current;
                }
                current = next;
            }
            return num + current;
        }
    }
}
