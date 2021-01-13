package com.someecho.algorithm.practice.week01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2021年01月13日 9:29 下午
 **/
class Solution {
    private static List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited = new int[nums.length];
        backtrack(nums,0,new LinkedList<>(),visited);
        return res;
    }
    
    private void backtrack(int[] nums, int level, LinkedList<Integer> temp,int[] visited){
        //terminal
        if(level == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            //当需要pull down时进行判断
            //1. 当前层没有被访问过，但是上个节点等于当前节点,且上个节点没有被访问！！！
            //2. 当前层被访问过
            //都不能进行pull down
            if(visited[i] == 1 || ( i>0 && nums[i] == nums[i-1]  && visited[i-1] == 0)){
                continue;
            }
            visited[i] = 1;
            temp.addLast(nums[i]);
            backtrack(nums,level+1,temp,visited);
            visited[i] = 0;
            temp.removeLast();
        }
        
    }
}
