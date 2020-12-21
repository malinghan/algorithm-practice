package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 70. 爬楼梯
 * @date Date : 2020年12月14日 12:58 PM
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 思路: 寻找最近重复子问题
 **/
public class L70ClimbStairs_1 {
    
    public static void main(String[] args) {
        System.out.println(new L70ClimbStairs_1().climbStairs1(8));
        System.out.println(new L70ClimbStairs_1().climbStairs(8));
    }
    
    //算法复杂度: O(n)
    public int climbStairs1(int n) {
        int f1 = 1,f2 = 2, f3 = 3;
        if(n <= 2){
            return n;
        }
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    
    //算法复杂度: O(n!)
    //递归一般是无法保留中间过程的，但是把结果通过返回值可以向上传递
    //一般需要在大脑中构建一个递归树
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
