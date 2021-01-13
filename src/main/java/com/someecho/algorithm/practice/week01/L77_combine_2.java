package com.someecho.algorithm.practice.week01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2021年01月13日 8:09 下午
 **/
public class L77_combine_2 {
    
    public static void main(String[] args) {
        new L77_combine_2().combine_2(4,2);
        System.out.println(res);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        _combine(n,k,1,new LinkedList<>());
        return res;
    }
    
    // 1~n
    // k
    public static List<List<Integer>> res = new ArrayList<>();
    private void _combine(int n, int k,int level, LinkedList<Integer> temp){
        //terminal
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            //如果不return的话，会继续递归，可能会抛出数组越界
            return;
        }
        //分支递归遍历
//        for(int i = level; i <= n;i++){
        //事实上，如果 n = 7, k = 4，从 5 开始搜索就已经没有意义了
        for(int i = level; i <= n - ( k - temp.size()) +1;i++){
            temp.addLast(i);
            _combine(n,k,i+1,temp);
            temp.removeLast();
        }
        //回溯
    }
    
    public List<List<Integer>> combine_2(int n, int k) {
        int[] visited = new int[n+1];
        _combine_2(n,k,visited,1,new LinkedList<>());
        return res;
    }
    
    private void _combine_2(int n, int k,int[] visited,int level,LinkedList<Integer> temp){
        //terminal
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            //如果不return的话，会继续递归，可能会抛出数组越界
            return;
        }
        //分支递归遍历
        //        for(int i = level; i <= n;i++){
        //事实上，如果 n = 7, k = 4，从 5 开始搜索就已经没有意义了
        for(int i = level; i <= n;i++){
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            temp.addLast(i);
            _combine_2(n,k,visited,i+1,temp);
            visited[i] = 0;
            temp.removeLast();
        }
        //回溯
    }
}
