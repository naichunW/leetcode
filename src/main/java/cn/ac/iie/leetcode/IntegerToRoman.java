package cn.ac.iie.leetcode;

import java.util.HashMap;

/**
 * Description:
 *
 * @author naichun
 * @date 2018/10/29 下午10:38
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        char[] chars = {'I','V','X','L','C','D','M'};
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 6; i >= 0; i=i-2) {
            int aNum = nums[i];
            int bNum = num / aNum;
            if (bNum != 0) {
                num = num % aNum;
                switch (bNum){
                    case 4:
                        stringBuilder.append(chars[i]);
                        stringBuilder.append(chars[i + 1]);
                        break;
                    case 5:
                        stringBuilder.append(chars[i + 1]);
                        break;
                    case 9:
                        stringBuilder.append(chars[i]);
                        stringBuilder.append(chars[i+2]);
                        break;
                    default:
                        if(bNum >5) {
                            stringBuilder.append(chars[i + 1]);
                            bNum = bNum - 5;
                        }
                        for (int j = 1; j <= bNum; j++) {
                            stringBuilder.append(chars[i]);
                        }
                        break;
                }
            }

        }
        return stringBuilder.toString();
    }
}
