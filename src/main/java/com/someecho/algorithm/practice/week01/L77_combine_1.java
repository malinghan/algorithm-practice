package com.someecho.algorithm.practice.week01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 77. 组合
 * @date Date : 2021年01月08日 1:53 上午
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * C(4,2)
 *
 **/
public class L77_combine_1 {
    public static void main(String[] args) {
        new L77_combine_1().combine(4,2);
        System.out.println(res);
    }
    
    /**
     * 思路:和括号生成和类似，递归后剪枝
     * 1. terminal:终止条件，k => 0
     * 2. process_current: 存储结果，剪枝
     * 3. drill down: 1种结构而已
     * 4. return res;
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        _combine(n,k,1,new ArrayList<>());
        return res;
    }
    
    public static List<List<Integer>> res = new ArrayList<>();
    
    public void _combine(int n, int k, int level, ArrayList<Integer> temp) {
        if( temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
//        for (int i = level; i <= n ; i++) {
//            temp.add(i);
//            _combine(n, k,i+1,temp);
//            //回溯，撤销处理结果
//            temp.remove(temp.size() - 1);
//        }
        //事实上，如果 n = 7, k = 4，从 5 开始搜索就已经没有意义了
        for (int i = level; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            _combine(n, k,i+1,temp);
            //回溯，撤销处理结果
            temp.remove(temp.size() - 1);
        }
    }
    
    public void _combine1(int n, int k, int level, ArrayList<Integer> temp) {
        //
        if(k == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        // 基础版本的递归终止条件
        if(level > n - k +1){
            return;
        }
        _combine1(n, k,level+1,temp);
        
        temp.add(level);
        
        _combine1(n, k-1,level,temp);
        
        temp.remove(temp.size()-1);
    }
    
    
    //[[1, 1, 2, 3, 4, 2, 1, 2, 3, 4, 3, 1, 2, 3, 4, 4, 1, 2, 3, 4]
}
