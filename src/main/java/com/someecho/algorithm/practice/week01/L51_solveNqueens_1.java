package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2021年01月13日 11:59 下午
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 思路:
 * 1. 使用3个HashSet校验-直线、斜线的元素
 * 2. 使用1个stack用于回溯
 */
public class L51_solveNqueens_1 {
    
    public static void main(String[] args) {
        System.out.println(new L51_solveNqueens_1().solveNQueens(4));
    }
    
    public static Set<Integer> columns = new HashSet<Integer>();
    public static Set<Integer> diagonals1 = new HashSet<Integer>();
    public static Set<Integer> diagonals2 = new HashSet<Integer>();
    public static List<List<String>> solutions = new ArrayList<List<String>>();
    
    public List<List<String>> solveNQueens(int n) {
        backtrack(new LinkedList<>(), n, 0);
        return solutions;
    }
    
    //1. 右斜线: 使用行下标与列下标之差即可明确表示每一条方向一的斜线
    //2. 左斜线: 使用行下标与列下标之和即可明确表示每一条方向二的斜线
    //3. 直线: 使用列标记重复
    private void backtrack(LinkedList<Integer> temp,int n,int level){
        //1. terminal
        if(level == n){
            solutions.add(new ArrayList<>(generateBoard(temp,n)));
            return;
        }
        //process current level
        //for drill down
        for (int i = 0; i < n; i++) {
            if(columns.contains(i)){
                continue;
            }
            //行 - 列
            int diagonals11 = level-i;
            if(diagonals1.contains(diagonals11)){
                continue;
            }
            //行+列
            int diagonals22 = level+i;
            if(diagonals2.contains(diagonals22)){
                continue;
            }
            temp.addLast(i);
            columns.add(i);
            diagonals1.add(diagonals11);
            diagonals2.add(diagonals22);
            backtrack(temp,n,level+1);
            temp.removeLast();
            columns.remove(i);
            diagonals1.remove(diagonals11);
            diagonals2.remove(diagonals22);
        }
    }
    
    public List<String> generateBoard(LinkedList<Integer> temp, int n){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[temp.get(i)] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
    
    
}
