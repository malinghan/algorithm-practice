package com.someecho.algorithm.practice.geek;

import base.JsonUtil;

import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.geek
 * @Description: 4. 每日在线用户量
 * @date Date : 2020年12月15日 12:01 PM
 *
 * 请根据 x 公司的每日在线用户数量列表，重新生成一个列表。
 * 新列表中对应位置的输出为：距离下次出现比当前更多的在线用户数所需要等待的天数。
 * 如果每日用户在这之后都不会再升高，请用 0 来替代。
 *
 * [13, 14, 15, 11, 9, 12, 16, 13]
 *
 * [1, 1, 4, 2, 1, 1, 0, 0]
 *
 *
 * 提示：
 * 在线用户数量列表的范围是 [1, 30000]
 * 在线用户的量单位是万，具体是 [1, 100] 的整数。
 **/
public class G4DailyTempture_1 {
    
    public static void main(String[] args) {
        int[] T = {13, 14, 15, 11, 9, 12, 16, 13};
        int[] res = new G4DailyTempture_1().dailyTemperatures(T);
        int[] res1 = new G4DailyTempture_1().dailyTemperatures1(T);
    }
    
    /**
     * 使用双重循环
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        
        for(int i = 0;i < T.length-1;i++ ){
            int j = i;
            int len = 0;
            while(j < T.length-1){
                j++;
                len++;
                if(T[i] < T[j]){
                    break;
                }
            }
            if((j == T.length-1) && (T[T.length-1] < T[i])){
                res[i] = 0;
            }else{
                res[i] = len;
            }
        }
        res[T.length-1] = 0;
        return res;
    }
    
    /**
     * 使用栈优化:
     *   单调递减栈: 压入新元素e前，把所有大于e的都弹出去
     * 1. 定义一个栈,
     *      while: 每次取栈顶的下标, i - p
     *
     * 13, 14, 15, 11, 9, 12, 16, 13
     *
     * -> 9 11 15 |
     * @param T
     * @return
     */
    public int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        //定义一个单调栈:从栈顶到栈底是递增的
        Stack<Integer> stack = new Stack<>();
        //循环
        for (int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                //
                int last = stack.pop();
                res[last] = i - last;
            }
            //push
            stack.push(i);
        }
        return res;
    }
    
    }
    