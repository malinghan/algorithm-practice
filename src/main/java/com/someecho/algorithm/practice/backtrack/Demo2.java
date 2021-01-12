package com.someecho.algorithm.practice.backtrack;

import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice
 * @Description:
 * @date Date : 2021年01月08日 2:38 上午
 **/
public class Demo2 {
    
    
    //题目：:
    //  给定一个nums,进行排列组合,可重复
    public void backtrack(int[] nums){
        backtrack(nums,new Stack<Integer>());
    }
    
    /**
     *
     * @param nums
     * @param temp
     */
//    List<List<String>>
   public void backtrack(int[] nums, Stack<Integer> temp){
       if(temp.size() >= 4){
           System.out.println(temp);
           return;
       }
       for (int i = 0; i < nums.length; i++) {
           temp.push(nums[i]);
           backtrack(nums,temp);
           temp.pop();
       }
   }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        new Demo2().backtrack(nums);
    }
}
