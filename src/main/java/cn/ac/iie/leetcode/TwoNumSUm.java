package cn.ac.iie.leetcode;

import java.util.HashMap;

/**
 * Description:
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author naichun
 * @date 2018/10/23 下午10:36
 */
public class TwoNumSUm {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int[] result = new int[2];
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>(size);
        for(int i = 0; i < size; i++){
            int b = target - nums[i];
            if(hashmap.containsKey(b)){
                result[0] = hashmap.get(b);
                result[1] = i;
                return result;
            }
            hashmap.put(nums[i],i);
        }
        return result;
    }
}
