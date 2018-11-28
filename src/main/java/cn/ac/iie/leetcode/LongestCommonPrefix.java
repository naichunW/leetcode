package cn.ac.iie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author naichun
 * @date 2018/11/20 上午12:29
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        if(null == strs || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        for (String str: strs) {
            if(str==null || str.isEmpty()){
                return "";
            }else{
                if (str.length() < minLength) {
                    minLength = str.length();
                }
            }
        }
        List<Character> chars = new ArrayList<Character>();
        for(int i = 0; i<minLength;i++){
            char first = strs[0].charAt(i);
            for(int j = 1; j<strs.length;j ++){
                char current = strs[j].charAt(i);
                if(current != first){
                    if (chars.isEmpty()) {
                        return "";
                    }else{
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Character c : chars) {
                            stringBuilder.append(c);
                        }
                        return stringBuilder.toString();
                    }
                }
            }
            chars.add(first);
        }
        if (chars.isEmpty()) {
            return "";
        }else{
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : chars) {
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }
    }
}
