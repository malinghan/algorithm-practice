package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 树的递归模板
 * @date Date : 2021年01月07日 8:56 下午
 **/
public class L111_minDepth_1 {
    
    /**
     * 方法1: dfs
     * //终止条件
     *  遇到叶子节点，return 1
     *  遇到空节点 return 0
     * //drill down:左子树、右子树挨个遍历
     * //处理返回结果
     * 如果left为空，返回right+1
     * 如果right为空,返回left+1
     * 如果都不为空，返回Math.min()+1
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
       if(root == null){
           return 0;
       }
       //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
       if(root.left == null && root.right  == null){
           return 1;
       }
       //如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
       int left = minDepth(root.left);
       int rigth = minDepth(root.right);
       //其中一个节点为空，说明left和right有一个必然为0，所以可以返回left+right + 1;
       if(root.left == null || root.right == null){
           return left+rigth+1;
       }
       //左右孩子都不为空，返回最小深度+1即可
       return Math.min(left,rigth)+1;
    }
    
    /**
     * 方法2: dfs+剪枝
     *
     * 如果left不为空，才遍历left
     * 如果left不为空，才遍历right
     *
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right  == null){
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        //如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        if(root.left != null) {
            ans = Math.min(minDepth1(root.left),ans);
        }
        if(root.right != null) {
            ans = Math.min(minDepth1(root.right),ans);
        }
        return ans+1;
    }
    
    
}
