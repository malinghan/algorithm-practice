package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * @date Date : 2021年01月13日 9:31 下午
 **/
public class L50_myPow_1 {
    
    public static void main(String[] args) {
        System.out.println(new L50_myPow_1().myPow(3,-4));
    }
    
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == Integer.MIN_VALUE){
            n = n/2;
            x = x * x;
        }
        if( n < 0){
            x = 1/x;
            n = -n;
        }
        
        if(n % 2 == 0){
            return myPow(x * x, n/2);
        }else {
            return myPow(x*x,n/2) * x;
        }
    }
}
