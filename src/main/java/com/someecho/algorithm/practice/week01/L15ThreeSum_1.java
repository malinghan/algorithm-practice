package com.someecho.algorithm.practice.week01;

import base.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 15. 三数之和
 * @date Date : 2020年12月14日 1:07 PM
 * @link https://leetcode.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 **/
public class L15ThreeSum_1 {
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new L15ThreeSum_1().threeSum2(nums);
        System.out.println(JsonUtil.toJson(res));
    }
    
    //方法1. 三重循环
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 0; a < n-2; a++) {
            for (int b = a+1; b < n-1; b++) {
                for (int c = b+1; c < n; c++) {
                    if(nums[a]+nums[b]+ nums[c] == 0){
                        List<Integer> newList = new ArrayList<>(3);
                        newList.add(nums[a]);
                        newList.add(nums[b]);
                        newList.add(nums[c]);
                        Collections.sort(newList);
                        if(!res.contains(newList)) {
                            res.add(newList);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    
    //方法3 一重循环+排序+左右双指针
    
    /**
     * sort
     * for i
     * l= i+1 ,r = len -1;
     * sum = num[l] + num[r]+num[i]
     * if(i >0  && num[i] == num[i-1]) continue;
     * if(sum == 0)
     *    nums[L] = nums[L+1] L++;
     *    nums[R] = nums[R-1] R--;
     * if(sum <0)
     *    L++;
     * is(sum >0)
     *    R--;
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           int l = i+1;
           int r = n -1;
           if( i > 0 && nums[i] == nums[i-1]){
               continue;
           }
           while(l < r){
               int sum = nums[l] + nums[r] + nums[i];
               if(sum == 0){
                   List<Integer> t = new ArrayList<>();
                   t.add(nums[l]);
                   t.add(nums[r]);
                   t.add(nums[i]);
                   res.add(t);
                   while(l < r && nums[l] == nums[l+1]){
                        l++;
                   }
                   while(l < r &&  nums[r] == nums[r-1]){
                       r--;
                   }
                   l++;
                   r--;
               }else if(sum > 0){
                   r--;
               }else {
                  l++;
               }
           }
           
        }
        return res;
    }
}
