package com.someecho.algorithm.practice.sort;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.sort
 * @Description: https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/
 * @date Date : 2020年12月22日 3:48 PM
 **/
public class ThreeWay_QuickSort_1 {
    
    public static void main(String[] args) {
        int[] arr = {4,6,5,2,3,7,2,1};
        new ThreeWay_QuickSort_1().quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public void  quickSort(int[] arr){
         quickSelect(arr,0,arr.length-1);
    }
    
    private void quickSelect(int[] arr,int l ,int r){
        if(l < r){
            int[] res = partition(arr,l,r);
            quickSelect(arr,l,res[0]);
            quickSelect(arr,res[1]+1,r);
        }
    }
    
    private int[] partition(int[] arr,int l ,int r){
        int privot = arr[r];
        int i = l-1;
        int m = i;
        for (int j = l; j < r; j++) {
            if(arr[j] < privot) {
                i++;
                m++;
                swap(arr,m,j);
            }else if(arr[j] == privot){
                m++;
            }
        }
        swap(arr,m+1,r);
        int[] res = new int[2];
        res[0] = i;
        res[1] = m+1;
        return res;
    }
    
    private void swap(int[] arr,int l ,int r){
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }
    
}
