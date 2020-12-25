package com.someecho.algorithm.practice.sort;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.sort
 * @Description:
 * @date Date : 2020年12月22日 3:23 PM
 **/
public class QuickSort_1 {
    
    public static void main(String[] args) {
        int[] arr = {4,6,5,2,3,7,2,1};
        new QuickSort_1().quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public void  quickSort(int[] arr){
        quickSelect(arr,0,arr.length-1);
    }
    
    
    private void quickSelect(int[] arr,int l,int r){
        if(l < r) {
            int j = partition(arr, l, r);
            quickSelect(arr, l, j - 1);
            quickSelect(arr, j + 1, r);
        }
    }
    
    public int partition(int[] arr,int l ,int r){
        int privot = arr[r];
        int i = l - 1;
        for (int j = l; j <= r-1; j++) {
            if(arr[j] < privot){
                i++;
                swap(arr,j,i);
            }
        }
        swap(arr,i+1,r);
        return i+1;
    }
    
    private void swap(int[] arr,int l ,int r){
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }
}
