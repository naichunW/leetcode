package cn.ac.iie.leetcode;

/**
 * Description:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 * @author naichun
 * @date 2018/10/23 下午10:46
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result= 0.0D;
        int length1 = nums1.length;
        int length2 = nums2.length;

        if(length1 == 0 || length2 == 0) {
            int[] nums = length1 == 0 ? nums2 :nums1;
            int length = nums.length;
            result = length%2==0?(nums[length/2-1]+nums[length/2])/2.0D:nums[length/2];
        }else {
            int length = length1 + length2;
            int index1=0;
            int index2=0;
            if(length%2==1) {
                int i = 1;
                while(i<=length/2+1) {
                    if(index1>=length1 || (index1<length1 && index2<length2 && nums1[index1]>=nums2[index2])) {
                        result = (double)nums2[index2];
                        index2++;
                    }else {
                        result = (double)nums1[index1];
                        index1++;
                    }
                    i++;
                }
            }else {
                int i = 1;
                int nextNum =0;
                while(i<=length/2) {
                    if(index1>=length1 || (index1<length1 && index2<length2 && nums1[index1]>=nums2[index2])) {
                        result = (double)nums2[index2];
                        index2++;
                    }else {
                        result = (double)nums1[index1];
                        index1++;
                    }
                    i++;
                }
                if(index1>=length1 || (index1<length1 && index2<length2 && nums1[index1]>=nums2[index2])) {
                    nextNum = nums2[index2];
                }else {
                    nextNum = nums1[index1];
                }
                result = (result+nextNum)/2.0D;
            }
        }
        return result;
    }
}
