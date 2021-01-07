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
public class L70ClimbStairs_2 {
    
    public static void main(String[] args) {
        System.out.println(new L70ClimbStairs_2().climbStairs1(8));
        System.out.println(new L70ClimbStairs_2().climbStairs(8));
        System.out.println(new L70ClimbStairs_2().climbStairs2(8));
    }
    
    
    /**
     * 非递归的动态规划
     * 数学归纳法
     * @param n
     * @return
     */
    public int climbStairs(int n){
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        if(n < 3){
            return n;
        }
        for(int i = 3; i <= n; i++){
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    
    /**
     * 递归解析:
     *  1. 传参:  level就是n,每次递归是不断递减的过程，不需要param
     *  2. 终止:  当n为1或2时，递归终止
     *  3. process: 这里就是一个递推公式 doClimbStairs1(n-1)+doClimbStairs1(n-2)
     * @param n
     * @return
     */
    public int climbStairs1(int n){
        //terminal
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        //process current level
        
        //drill down
        return climbStairs1(n-1)+climbStairs1(n-2);
        //restore status
    }
    
    /**
     * 尾部递归优化
     * @param n
     * @return
     */
    public int climbStairs2(int n){
       return doClimbStairs2(n,1,1);
    }
    
    /**
     * 尾部递归算法
     * @param n
     * @param a
     * @param b
     * @return
     */
    int doClimbStairs2(int n,int a, int b){
        //terminal
        if(n <= 1){
            return b;
        }
        //drill down
        return doClimbStairs2(n-1,b,a+b);
    }
    
}
