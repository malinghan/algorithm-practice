package com.someecho.algorithm.practice.backtrack;

import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice
 * @Description:
 * @date Date : 2021年01月08日 2:38 上午
 **/
public class Demo {
    
    
    //题目：:
    //  给定一个nums,进行排列组合,不可重复
    public void backtrack(int[] nums){
        backtrack(nums,0,new Stack<Integer>());
    }
    
    /**
     *
     * @param nums
     * @param index
     * @param temp
     */
//    List<List<String>>
   public void backtrack(int[] nums, int index, Stack<Integer> temp){
//       if(index == nums.length -1){
//           return;
//       }
       if(temp.size() == 3){
           System.out.println(temp);
       }
       for (int i = index; i < nums.length; i++) {
           temp.push(nums[i]);
           backtrack(nums,i+1,temp);
           temp.pop();
       }
   }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        new Demo().backtrack(nums);
    }
}
