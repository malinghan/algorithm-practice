package com.someecho.algorithm.practice.week01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 求解滑动窗口的最大值
 * @date Date : 2020年12月21日 2:30 AM
 *
 * 给你一个zheng's数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。

    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    输出：[3,3,5,5,6,7]
    解释：
    滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7

    输入：nums = [1], k = 1
    输出：[1]

 *
 * 方法1: 双端队列
 *
 * 1.
 * 方法2: 双指针遍历
 **/
public class L239_SlideWindowMaxium_1 {
    
    //方法1: 双端队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
      //1.  定义一个Deque,始终保证左边的是最大的
      //2.  同时保证左边的在滑动窗口的范围内
      //3.  对于入队的新元素,判断队尾元素是否大于它
      //    如果比新元素小，尾部出队丢弃，然后将新元素入队
      //    else 丢弃新元素
      Deque<Integer> queue  = new ArrayDeque<>();
        int[] res =new int[nums.length - k + 1];
        queue.offerFirst(0);
        int m = 0;
        //[i-k+1 i]
        for (int i = 1; i < nums.length; i++) {
                //remove out of rang
                while(!queue.isEmpty() && i - k + 1 > queue.peek()) {
                    queue.poll();
                }
                //remove useless node
                while(!queue.isEmpty() &&  nums[i] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                //push one至少有一个备胎？
                queue.offer(i);
                if(i - k + 1 >= 0){
                    res[m] = nums[queue.peekFirst()];
                    m++;
                }
        }
        return res;
    }
    
    //https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
    //方法三: 动态规划
    //直觉
    //
    //这是另一个 O(N) 的算法。本算法的优点是不需要使用 数组 / 列表 之外的任何数据结构。
    //
    //算法的思想是将输入数组分割成有 k 个元素的块。
    //若 n % k != 0，则最后一块的元素个数可能更少。
   
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0){
            return new int[0];
        }
        if (k == 1){
            return nums;
        }
        
        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0){
                left[i] = nums[i];  // block_start
            }else{
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            
            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0){
                right[j] = nums[j];  // block_end
            }else{
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        
        return output;
    }
}
