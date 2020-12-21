package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @link https://leetcode-cn.com/problems/container-with-most-water/
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * [1,8,6,2,5,4,8,3,7]
 * @date Date : 2020年12月14日 4:10 AM
 **/
public class L11MaxArea_1 {
    
    public static void main(String[] args) {
        int[]  height = {1,8,6,2,5,4,8,3,7};
        int res = new L11MaxArea_1().maxArea(height);
        System.out.println(res);
    }
    
    //双指针都从左往右遍历
    //计算最大的面积
    public int maxArea(int[] height) {
        //a1 a2 .... an
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for(int j = i+1;j < height.length;j++){
                res = Math.max(res, (j - i) * (height[i] < height[j]?height[i] :height[j]));
            }
        }
        return res;
    }
    
    //左右边界向中间收敛
    //双指针都从左往右遍历
    //计算最大的面积
    //滑动窗口的正确性：
    public int maxArea1(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        //计算面积
        //比较大小
        //左移还是右移？？
        while(left < right){
            res = Math.max(res, (right - left) * (height[left] < height[right]?height[left] :height[right]));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
