package com.someecho.algorithm.practice.week01;

import com.someecho.algorithm.practice.PrintUtil;

import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 98. 验证二叉搜索树
 * @date Date : 2021年01月07日 6:58 下午
 *
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 答案: https://leetcode-cn.com/problems/validate-binary-search-tree/solution/bao-zhun-sheng-guo-guan-fang-ti-jie-by-novice2mast/
 **/
public class L98_isValidBST_1 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        System.out.println();
        boolean root1 = new L98_isValidBST_1().isValidBST2(root);
        System.out.println(root1);
    }
    
    /**
     * 方法1: 递归
     * 往左递归时，比较左子树和当前节点的大小；
     * 往右递归时，比较右子树和当前节点的大小；
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root,null,null);
    }
    
    private boolean _isValidBST(TreeNode root,Integer min,Integer max) {
        //terminal
        if(root == null){
          return true;
        }
        if(min != null && root.val <= min){
             return false;
        }
        if(max != null && root.val >= max){
            return false;
        }
        //
        return _isValidBST(root.left, min, root.val) && _isValidBST(root.right, root.val, max);
    }
    
    
    /**
     * 方法2: 非递归中序遍历
     * 一颗二叉搜索树的中序遍历是有序的
     *
     * 1. 循环整个stack(这个stack是用于深度遍历的临时存储)
     * 2.   while: 如果root不为空，stack.push,root = root.left()  ==> 一直往左添加元素到栈中,指定左为空。
     * 3. root = stack.pop(); 如果pre不为空且root的值小于pre的值 return false； ==> 依次判断stack中的root和上一个的关系
     * 4. pre = root
     * 5. root = root.right  ==> 这样可以将整个元素按照左中右的方式遍历
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
    
    
    /**
     * 是否是有效的bst树
     * 方法3: 和方法1类似，另一种写法
     * 对于每一个结点，检查结点左子树中值最大的结点的值是否小于结点，右子树中值最小的结点是否大于结点。
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return _isValidBST2(root,null,null);
    }
    
    /**
     * 对于每一个结点，检查结点左子树中值最大的结点的值是否小于结点，右子树中值最小的结点是否大于结点。
     * @param node
     * @param lower 下界
     * @param upper 上界
     * @return
     */
    public boolean _isValidBST2(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        
        if (lower != null && node.val <= lower) {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        }
        
        if (!_isValidBST2(node.right, node.val, upper)) {
            return false;
        }
        
        if (!_isValidBST2(node.left, lower, node.val)) {
            return false;
        }
        return true;
    }
    
    /**
     * 这个比较难理解，思路就是中序遍历
     * 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST，继续遍历；否则直接返回 false。
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST3(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        if (!isValidBST3(root.right)) {
            return false;
        }
        return true;
    }
    
    
    
}
