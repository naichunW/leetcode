package cn.ac.iie.leetcode;

/**
 * Description:
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * 实现一个将字符串进行指定行数变换的函数:
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * @author naichun
 * @date 2018/10/23 下午10:52
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if(numRows==1){
            return s;
        }
        if (length < 3) {
            return s;
        }
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int size = numRows * 2 - 2;
        int start = 0;
        int end = 0;
        while (start < length) {
            end = start + size;
            for (int i = 0; i < numRows; i++) {
                StringBuilder stringBuilder = builders[i];
                int first = start + i;
                int last = end - i;
                if (first == last && first < length) {
                    stringBuilder.append(chars[first]);
                }else {
                    if (first >= start && first < length) {
                        stringBuilder.append(chars[first]);
                    }
                    if (last < end && last < length) {
                        stringBuilder.append(chars[last]);
                    }
                }
            }
            start = end;
        }

        for (int i = 1; i < numRows; i++) {
            builders[0].append(builders[i]);
        }
        return builders[0].toString();
    }
}
