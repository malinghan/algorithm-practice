package com.someecho.algorithm.practice.week01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 78. 子集 和L77类似
 * @date Date : 2021年01月13日 10:37 下午
 *
 * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
 **/
public class L78_subsets_1 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new L78_subsets_1().subsets(nums));
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        int[] visited = new int[nums.length];
        backtrack(nums,0,new LinkedList<>(),visited);
        return res;
    }
    
    private List<List<Integer>> res = new ArrayList<>();
    
    private  void backtrack(int[] nums, int level, LinkedList<Integer> temp,int[] visited ){
        if(!res.contains(temp)) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = level; i < nums.length; i++) {
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            temp.addLast(nums[i]);
            backtrack(nums,i+1,temp,visited);
            visited[i] = 0;
            temp.removeLast();
        }
    }
}
