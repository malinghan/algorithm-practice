package com.someecho.algorithm.practice.week01;

import java.util.HashMap;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2021年01月08日 1:23 上午
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意: 你可以假设树中没有重复的元素
 *
 * 例如:
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 **/
public class L105_buildTree_1 {
    
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder,
                              int[] inorder) {
        //把中序遍历转换成hashMap,key是value,value是中序遍历的下标
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        int n = preorder.length;
        return _buildTree(preorder,inorder,0,n-1,0,n-1);
    }
    
    //如何递归:不停的寻找root
    public TreeNode _buildTree(int[] preorder, int[] inorder,
                               int preorder_left,
                               int preorder_right,
                               int inorder_left,
                               int inorder_right){
        if(preorder_left > preorder_right){
            return null;
        }
        //根节点
        int value = preorder[preorder_left];
        //inorder
        int inorder_index = map.get(value);
        TreeNode root = new TreeNode(value);
        //左子树的长度
        int left_size = inorder_index - inorder_left;
        //左节点
        root.left = _buildTree(preorder,
                             inorder,
                preorder_left+1,
                preorder_left+left_size,
                        inorder_left,
                    inorder_index-1);
        //右节点
        root.right = _buildTree(
                preorder,
                inorder,
                preorder_left+left_size+1,
                preorder_right,
                inorder_index+1,
                inorder_right);
        return root;
    }
}
