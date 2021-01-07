package com.someecho.algorithm.practice;

import com.someecho.algorithm.practice.week01.TreeNode;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice
 * @Description:
 * @date Date : 2020年12月20日 2:35 AM
 **/
public class PrintUtil {
    
    public static void printArray(int[] arrary){
        for (final int i : arrary) {
            System.out.print(i+",");
        }
    }
    
    public static void printTreeNode(TreeNode root) {
        //terminal
        if(root == null){
            return;
        }
        System.out.println(root.val);
        if(root.left != null) {
            printTreeNode(root.left);
        }
        if(root.right != null) {
            printTreeNode(root.right);
        }
    }
}
