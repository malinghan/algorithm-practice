package com.someecho.algorithm.practice.week01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2021年01月07日 8:33 下午
 **/
public class L104_maxDepth_1 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(9);
        System.out.println();
        int res  = new L104_maxDepth_1().maxDepth1(root);
        System.out.println(res);
    }
    
    /**
     * 方法1:递归，使用level
     * dfs
     * @param root
     * @return
     */
    public int  maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
    
    /**
     * 方法2: bfs
     *
     * @param root
     * @return
     */
    public int  maxDepth1(TreeNode root){
        if(root == null){
            return  0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size --;
            }
            count++;
        }
        return count;
    }
    
    
}
