package cn.ac.iie.leetcode;

import java.util.ArrayList;

/**
 * Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * @author naichun
 * @date 2018/10/23 下午10:50
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        int max =0;
        int maxStart =0;
        int maxEnd =0;
        char[] chars= s.toCharArray();
        int length = chars.length;
        ArrayList<Integer> a =new ArrayList<Integer>(1000);
        ArrayList<Integer> b =new ArrayList<Integer>(1000);
        for(int index=0;index<length-2;index++) {
            char c = chars[index];
            if(c==chars[index+1]) {
                a.add(index);
            }
            if(c==chars[index+2]) {
                b.add(index);
            }

        }
        if(chars[length-2]==chars[length-1]) {
            a.add(length-2);
        }
        for(int a1:a) {
            int start = a1;
            int end = a1+1;
            while(start-1>=0 && end+1<length && chars[start-1] == chars[end+1]) {
                start--;
                end++;
            }
            if(end-start+1 > max) {
                max=end-start+1;
                maxStart=start;
                maxEnd =end;
            }
        }
        for(int b1:b) {
            int start = b1;
            int end = b1+2;
            while(start-1>=0 && end+1<length && chars[start-1] == chars[end+1]) {
                start--;
                end++;
            }
            if(end-start+1 > max) {
                max=end-start+1;
                maxStart=start;
                maxEnd =end;
            }
        }

        return s.substring(maxStart, maxEnd+1);
    }
}
