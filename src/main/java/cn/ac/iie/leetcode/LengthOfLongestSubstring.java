package cn.ac.iie.leetcode;

import java.util.HashMap;

/**
 * Description:
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 *      请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 * @author naichun
 * @date 2018/10/23 下午10:43
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int current = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        HashMap<Character, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if (!map.containsKey(c)) {
                current ++;
            }else {
                if (current > max) {
                    max = current;
                }
                int newStart = map.get(c) + 1;
                for (int j = start; j < newStart ; j++) {
                    map.remove(chars[j]);
                }
                start = newStart;
                current = i - start + 1;
            }
            map.put(c, i);
        }
        if (current > max) {
            max = current;
        }
        return max;
    }
}
