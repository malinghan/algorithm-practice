package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 236. 二叉树的最近公共祖先
 * @date Date : 2021年01月07日 9:56 下午
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 
 **/
public class L236_lowestCommonAncestor_1 {
    
    /**
     * 思路: dfs+后续遍历
     * 1.构造一个函数findPorQ()
     * 2.如果找到了p或q，分类讨论
     *    2.1 如果root == q or root == q ==> return root;
     *    2.2 如果root == null ==> return null;
     *    2.3 p、q位于root的一侧
     *    2.4 p、q位于root的两侧
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftRes = lowestCommonAncestor(root.left,p,q);
        TreeNode rightRes = lowestCommonAncestor(root.right,p,q);
        //如果left和right的结果都不为空,则向上传递root
        if(leftRes != null && rightRes != null){
            return root;
        }
        return leftRes != null?leftRes:rightRes;
    }
}


