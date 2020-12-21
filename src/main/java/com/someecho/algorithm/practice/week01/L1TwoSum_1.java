package com.someecho.algorithm.practice.week01;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 1. 两数之和
 * @date Date : 2020年12月14日 11:59 AM
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 时间复杂度：O(n)
 *
 * 背诵口决:
 *  1个hash,循环遍历
 *  key是nums[i],value是i
 *  如果target - nums[i]在其中,得出结论
 **/
public class L1TwoSum_1 {
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = new L1TwoSum_1().twoSum(nums,target);
        for (final int re : res) {
            System.out.println(re);
        }
    }
    
    //方法1: hashMap+循环遍历
    public int[] twoSum(int[] nums, int target) {
//        sort
        Arrays.sort(nums);
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for ( int i = 0 ; i < nums.length; ++i) {
            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
