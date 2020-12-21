package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice
 * @Description:
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @date Date : 2020年12月14日 3:49 AM
 **/
public class L283MoveZero_1 {
    
    public static void main(String[] args) {
        int[] nums =  {0,1,0,3,12};
        new L283MoveZero_1().moveZeroes(nums);
        for (final int num : nums) {
            System.out.println(num);
        }
    }
    
    //方法1:指针记录法
    //index记录插入点
    //如果遇到非零节点就插入，然后index
    public void moveZeroes(int[] nums) {
      //零点
      int j = 0;
      for(int num: nums){
          if(num != 0){
              nums[j] = num;
              j++;
          }
      }
      //将
      while(j < nums.length){
          nums[j] = 0;
          j++;
      }
    }
    
    //方法2:滚雪球交换法
    //把所有非0都交换到前面去
    public void moveZeroes1(int[] nums) {
        //零点
        int j = 0;
        for(int i = 0;i < nums.length ; i++){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
    
    
}
