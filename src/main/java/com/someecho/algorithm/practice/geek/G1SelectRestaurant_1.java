package com.someecho.algorithm.practice.geek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.geek
 * @Description:
 * @date Date : 2020年12月19日 5:53 PM
 **/
public class G1SelectRestaurant_1 {
    
    public static void main(String[] args) {
//        int[][] restaurants = {
//                {1, 4, 1, 40, 10},
//                {2, 8, 0, 50, 5},
//                {3, 8, 1, 30, 4},
//                {4, 10, 0, 10, 3},
//                {5, 1, 1, 15, 1}}
//                ;
//        int[] filter = {1, 40, 10};
    
        int[][] restaurants = {{0,4,1,40,10},{1,8,0,50,5},{2,8,1,30,4},{3,10,0,10,3},{4,1,1,15,1}};
        int[] filter =  {0, 40, 10};
        printList(new G1SelectRestaurant_1().filterRestaurants(restaurants,filter));
    }
    
    public static void printList(int[] list){
        System.out.print("[");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+",");
        }
        System.out.print("]");
    }
    
    //这里主要考的是插入排序算法，而且是多字段排序
    public int[] filterRestaurants1(int[][] restaurants, int[] filters) {
        int[] res = new int[restaurants.length];
         int m = 0;
         for(int i = 0 ; i < restaurants.length; i++){
             if(filters[0] == 0 ||  (filters[0] == 1 && restaurants[i][2] == 1)) {
                 if (restaurants[i][3] <= filters[1] && restaurants[i][4] <= filters[2]) {
                     //sort
                     res[m] = i;
                     //插入排序
                     int j = m;
                     //sort by id
                     while(j > 0 && restaurants[res[j]][1] >= restaurants[res[j-1]][1]){
                             //swap
                             if(restaurants[res[j]][1] == restaurants[res[j-1]][1] ) {
                                 if(restaurants[res[j]][0] > restaurants[res[j-1]][0]){
                                     swap(res,j,j-1);
                                 }
                             }else {
                                 swap(res,j,j-1);
                             }
                             j--;
                     }
                     m++;
                     }
                 }
         }
         return  Arrays.copyOf(res,m);
    }
    
    /**
     * 使用java8的stream
     * @param restaurants
     * @param filters
     * @return
     */
    public int[] filterRestaurants(int[][] restaurants, int[] filters) {
        List<Integer> result = new ArrayList<>();
        Arrays.stream(restaurants)
                .filter(restaurant ->
                        ((filters[0] == 1 && restaurant[2] == 1) || filters[0] == 0)
                                && restaurant[3] <= filters[1]
                                && restaurant[4] <= filters[2])
                .sorted((r1, r2) -> r1[1]==r2[1]? -r1[0]+r2[0] : -r1[1]+r2[1])
                .forEach(restaurant-> result.add(restaurant[0]));
        
        int length = result.size();
        int[] finalResult = new int[length];
        for(int idx = 0; idx < length; idx++) {
            finalResult[idx] = result.get(idx);
        }
        return finalResult;
    }
    
    
    
    private static void swap(int[] res,int  j,int k){
        int temp = res[j];
        res[j] = res[k];
        res[k] = temp;
    }
}
