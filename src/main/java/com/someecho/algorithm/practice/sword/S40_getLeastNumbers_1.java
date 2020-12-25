package com.someecho.algorithm.practice.sword;

import com.someecho.algorithm.practice.PrintUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.sword
 * @Description: 剑指 Offer 40. 最小的k个数
 * @date Date : 2020年12月22日 1:30 PM
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 *
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 **/
public class S40_getLeastNumbers_1 {
    
    
    public static void main(String[] args) {
          int[] arr = {3,2,1};
//          int[] arr = {0,1,2,1};
          PrintUtil.printArray(new S40_getLeastNumbers_1().getLeastNumbers(arr,2));
    }
    
    //排序后取topk
    //Arrays.sort(arr)
    //range[0,k]
    /**
     * 方法一: 排序后取top k
     * 时间复杂度： O(nlg(n))
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return  Arrays.copyOf(arr,k);
//        return System.arraycopy();
    }
    
    /**
     * 方法二: 优先级队列
     *
     * 1. 先维护一个大小为k的大顶堆，放入k个元素,则top元素是当前堆最大的元素
     * 2. if(newElement <= top) =>  poll(top),and offer(newElement)
     * 3. poll(top) -> heap to array
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int [k];
        if (k == 0) { // 排除 0 的情况
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (s1,s2) -> (s2 - s1));
        
        for (int i = 0 ; i < k ; i++) {
            queue.offer(arr[i]);
        }
        
        for (int j = k; j < arr.length; j++) {
            if(arr[j] <= queue.peek()) {
                queue.poll();
                queue.offer(arr[j]);
            }
        }
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll();
        }
    
        return res;
    }
    
    /**
     * 方法三: 快速排序
     *
     *
     *
     * 1. 递归:
     *     getLeastNumbers(arr,k,l,r)
     *     1.1 只需要寻找k的位置，如果一次拆分后，j > k, getLeastNumbers(arr,k,0,j-1)
     *     1.2 如果j < k, getLeastNumbers(arr,k,j+1,r)
     *     1.3 如果j > k, getLeastNumbers(arr,k,j+1,r)
     *     1.4 终止条件 j == k
     * 2. partition: 不变的逻辑
     * 3. 取arr[0~k]
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        getLeastNumbersSelect(arr,k,0,arr.length-1);
        return  Arrays.copyOf(arr,k);
    }
    
    private void getLeastNumbersSelect(int[] arr, int k,int l ,int r){
             int  j =  partition(arr,l,r);
             if( j == k ){
                 return;
             }else if(j > k){
                 getLeastNumbersSelect(arr,k,l,j-1);
             }else{
                 getLeastNumbersSelect(arr,k,j+1,r);
             }
    }
    
    
    //以右边为基准点
    //从左到右遍历,如果发现arr[i] < arr[r],swap(i,j)
    //最后swap(j+1,r)
    private int partition(int[] arr,int l ,int r){
        int privot = arr[r];
        int j = l-1;
        for (int i = l; i <= r -1; i++) {
            if(arr[i] < privot){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,j+1,r);
        return j+1;
    }
    
    //快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    //双指针遍历,i,j
    //在左边找一个数大于privot，在右边找一个数小于于privot
    //然后交换这2个数
    private int partition1(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l, j = r + 1;
        while (true) {
            while (++i <= r && arr[i] < v){
            }
            while (--j >= l && arr[j] > v){
            }
            if (i >= j) {
                break;
            }
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
        arr[l] = arr[j];
        arr[j] = v;
        return j;
    }
    
    
    private void swap(int[] arr, int l ,int r){
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }
    
    
}
