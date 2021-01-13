package com.someecho.algorithm.practice.week01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 全排列
 * @date Date : 2021年01月13日 8:25 下午
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3]
 **/
public class L46_permute_1 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,7};
//        List<List<Integer>> res =  new L46_permute_1().permute(nums);
        List<List<Integer>> res =  new L46_permute_1().permute_2(nums);
        System.out.println(res);
    }
    
    public List<List<Integer>> permute(int[] nums) {
       //1. terminal
        //2. for 递归
        //3. remove
        int[] visited = new int[nums.length];
        trackback(nums,new LinkedList<>(),visited);
        return res;
    }
    
    private static List<List<Integer>> res = new ArrayList<>();
    
    /**
     * 回溯算法
     */
    private void trackback(int[] nums, LinkedList<Integer> temp,int[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
    
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == 1){
                //已存在
                continue;
            }
            visited[i] = 1;
            temp.addLast(nums[i]);
            trackback(nums,temp,visited);
            visited[i] = 0;
            temp.removeLast();
        }
    }
    
    
    public List<List<Integer>> permute_2(int[] nums) {
        //1. terminal
        //2. for 递归
        //3. remove
        int[] visited = new int[nums.length];
        trackback_2(nums,new LinkedList<>(),visited,0);
        return res;
    }
    
    
    /**
     * 回溯算法
     */
    private void trackback_2(int[] nums, LinkedList<Integer> temp,int[] visited,int level){
        if(level== nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == 1){
                //已存在
                continue;
            }
            visited[i] = 1;
            temp.addLast(nums[i]);
            trackback_2(nums,temp,visited,level+1);
            visited[i] = 0;
            temp.removeLast();
        }
    }
    
}
