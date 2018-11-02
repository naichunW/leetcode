package cn.ac.iie.leetcode;

/**
 * Description:
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * @author naichun
 * @date 2018/10/24 下午10:51
 */
public class ReverseInt {
    public int reverse(int x) {
        if(x==0){
            return 0;
        } else {
            int s =0;
            long j =0L;
            s= x;
            while(s !=0){
                j = j*10+s%10;//取出最低位上的数字 ,依次得到反转的数字
                s=s/10;; //降位
            }
            if (j > 0) {
                return j > Integer.MAX_VALUE ? 0 : (int) j;
            }else {
                return j < Integer.MIN_VALUE ? 0 : (int) j;
            }
        }
    }
}
