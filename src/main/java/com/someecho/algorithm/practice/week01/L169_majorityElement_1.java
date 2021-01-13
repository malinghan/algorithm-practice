package com.someecho.algorithm.practice.week01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 众数
 * @date Date : 2021年01月13日 10:53 下午
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 **/
public class L169_majorityElement_1 {
    
    /**
     * 投票法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * 如果我们把众数记为 +1+1，把其他数记为 -1−1，
     * 将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     *
     *  投票算法证明：
     *
     * 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
     * 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (final int num : nums) {
            if(count == 0){
                res = num;
            }
            count = count +( (res == num) ? 1:-1 );
        }
        return res;
    }
    
    /**
     * 哈希法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * 先计数、然后遍历整个map
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Map<Integer,Integer> counter = new HashMap<Integer,Integer>();
        for (final int num : nums) {
            if (!counter.containsKey(num)) {
                counter.put(num, 1);
            } else {
                counter.put(num, counter.get(num) + 1);
            }
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
    
    /**
     * 定理法: 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为 n/2 的元素（下标从 0 开始）一定是众数。
     * 时间复杂度 O(nlogn)
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
       //先分治
        return _majorityElement2(nums,0,nums.length-1);
    }
    
    public int _majorityElement2(int[] nums,int l,int r) {
        //先分治
        //terminal
        if(l == r){
            return nums[l];
        }
        int mid = l + (r-l)/2;
        int left  = _majorityElement2(nums,l,mid);
        int right = _majorityElement2(nums,mid+1,r);
        if(left == right){
           return left;
        }
        int leftCount = countMajority(nums,left,l,mid);
        int rightCount = countMajority(nums,right,mid+1,r);
        return leftCount > rightCount ? left : right;
    }
    
    private int countMajority(int[] nums,int num,int l ,int r){
        int count = 0 ;
        for (int i = l; i <= r; i++) {
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }
    
    /**
     * 分治法:
     * 时间复杂度： O(nlogn)
     * 空间复杂度 O(nlogn)
     * 1. 把该数组拆成2半，则结果必存在于左右的众数之中
     * 2. 按此递归
     * 3. 当数组的大小为1时?，直接返回当前值
     * 4. 如果回溯后某区间的长度大于 1，我们必须将左右子区间的值合并
     * 5. 当count相等时，返回任意一个众数 否则取其中较大者
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
}
