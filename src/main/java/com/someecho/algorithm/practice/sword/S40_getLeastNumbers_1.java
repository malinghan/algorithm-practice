package com.someecho.algorithm.practice.sword;

import java.util.Arrays;

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
    
    //排序后取topk
    //Arrays.sort(arr)
    //range[0,k]
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
//        Arrays.copyOf(arr,0,)
        return null;
    }
}
