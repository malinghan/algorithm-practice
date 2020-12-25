package com.someecho.algorithm.practice.sort;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.sort
 * @Description:
 * @date Date : 2020年12月25日 2:12 PM
 **/
public class QuickSort_2 {
    
    //void quickSort(arr)
    //void quickSelect(arr,0,n)
    //void partition(arr,l,r)
    
    public static void main(String[] args) {
        int[] arr = {4,6,5,2,3,7,2,1};
        new QuickSort_2().quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public void quickSort(int[] arr){
         quickSelect(arr,0,arr.length-1);
    }
    
    public void  quickSelect(int[] arr,int l,int r){
        if( l < r){
            int j =  partition(arr,l,r);
            quickSelect(arr,0,j-1);
            quickSelect(arr,j+1,r);
        }
    }
    
    private  int partition(int[] arr,int l,int r){
        int privot = arr[r];
        int i = l-1;
        for (int j = l; j < r; j++) {
            if(arr[j] <= privot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r);
        return i+1;
    }
    
    private  void swap(int[] arr,int l,int r){
          int temp = arr[r];
          arr[r] = arr[l];
          arr[l] = temp;
    }
}
