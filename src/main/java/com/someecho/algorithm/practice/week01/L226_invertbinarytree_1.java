package com.someecho.algorithm.practice.week01;

import com.someecho.algorithm.practice.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 翻转一棵二叉树。
 * @date Date : 2021年01月07日 6:10 下午
 **/
public class L226_invertbinarytree_1 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        System.out.println();
        TreeNode root1 = new L226_invertbinarytree_1().invertTree1(root);
        PrintUtil.printTreeNode(root1);
    }
    
    
    /**
     * dfs
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
      //terminal
        if(root == null){
            return null;
        }
      //process:翻转当前节点的左右节点
        TreeNode  temp = root.left;
        root.left = root.right;
        root.right = temp;
      //drill down:
        invertTree(root.left);
        invertTree(root.right);
      //restore
        return root;
    }
    
    /**
     * bfs
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //swap
                TreeNode current = queue.poll();
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }
    
    
}
