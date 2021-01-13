package com.someecho.algorithm.practice.week01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2021年01月13日 8:52 下午
 *
 * 要解决重复问题，我们只要设定一个规则，
 * 保证在填第 idx 个数的时候重复数字只会被填入一次即可。
 * 而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，
 * 然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」，即如下的判断条件：
 *
 *  if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
 *     continue;
 * }
 *
 * 这个判断条件保证了对于重复数的集合，一定是从左往右逐个填入的。
 *
 * 假设我们有 3 个重复数排完序后相邻，
 * 那么我们一定保证每次都是拿从左往右第一个未被填过的数字，
 * 即整个数组的状态其实是保证了 [未填入，未填入，未填入] 到 [填入，未填入，未填入]，
 * 再到 [填入，填入，未填入]，最后到 [填入，填入，填入] 的过程的，
 * 因此可以达到去重的目标。
 
 
 **/
public class L47_permuteUnique_1 {
    
    private static List<List<Integer>> res = new ArrayList<>();
    
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res =  new L47_permuteUnique_1().permuteUnique(nums);
        System.out.println(res);
    }
    
    
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
            if(visited[i] == 1 || ( i>0 && nums[i] == nums[i-1]  && visited[i-1] == 1)){
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
