package com.someecho.algorithm.practice.week01;

import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 84. 柱状图中最大的矩形
 * @date Date : 2020年12月20日 10:48 PM
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 **/
public class L84_largestRectangleArea_1 {
    
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new L84_largestRectangleArea_1().largestRectangleArea(heights));
        System.out.println(new L84_largestRectangleArea_1().largestRectangleArea1(heights));
        System.out.println(new L84_largestRectangleArea_1().largestRectangleArea2(heights));
    }
    
    //方法一：暴力解法
    /**
     * for循环2遍
     * 求出以每个index的high的最大矩形面积
     * 求出所以矩形的最大值
     *
     * 时间复杂度： O(n^2)
     * 空间复杂度： O(1)
     */
    public int largestRectangleArea(int[] heights) {
       int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while(left >0 && heights[left-1] >= heights[i]) {
                left--;
            }
            while(right < heights.length-1  && heights[right+1] >= heights[i]) {
                right++;
            }
            max = Math.max(max, heights[i] * (right - left + 1));
        }
        return max;
    }
    
    
    //方法二：以空间换时间，用到的数据结构是栈
    /**
     * 优化:
     * 1. 对于一个高度，如果能得到向左和向右的边界
     * 2. 那么就能对每个高度求一次面积
     * 3. 遍历所有高度，即可得出最大面积
     * 4. 使用单调栈，在出栈操作时得到前后边界并计算面积
     *
     * 我们每遍历到当前柱体 i 时：
     * 上述写法中，我们需要再嵌套一层 while 循环来向左找到第一个比柱体 i 高度小的柱体，这个过程是 O(N) 的；
     * 那么我们可以 O(1) 的获取柱体 i 左边第一个比它小的柱体吗？
     * 答案就是单调增栈，因为对于栈中的柱体来说，栈中下一个柱体就是左边第一个高度小于自身的柱体。
     *
     *
     */
    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        
        int[] new_heights = new int[heights.length+2];
        
        System.arraycopy(heights,0,new_heights,1,heights.length);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < new_heights.length; i++) {
            // 2,1,5,6,2,3
            // ->  6 5 1 |  这个是单调递增栈
            while(!stack.isEmpty() && new_heights[i] <= new_heights[stack.peek()]){
                 int curr = stack.pop();
                 if(!stack.isEmpty()) {
                     max = Math.max(max, new_heights[curr] * (i - stack.peek() - 1));
                 }
            }
            stack.push(i);
        }
        return max;
    }
    
    /**
     * 不使用哨兵
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int max = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            // 2,1,5,6,2,3
            // ->  6 5 1 |  这个是单调递增栈
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                int curr = stack.pop();
                while (!stack.isEmpty() && heights[curr] == heights[stack.peek()]){
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    max = Math.max(max, heights[curr] * (i - stack.peek() - 1));
                }else {
                    max = Math.max(max, heights[curr] * (i));
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int curr = stack.pop();
            while (!stack.isEmpty() && heights[curr] == heights[stack.peek()]){
                curr = stack.pop();
            }
            if(!stack.isEmpty()) {
                max = Math.max(max, heights[curr] * (heights.length - stack.peek() - 1));
            }else {
                max = Math.max(max, heights[curr] * (heights.length));
            }
        }
        return max;
    }
}
