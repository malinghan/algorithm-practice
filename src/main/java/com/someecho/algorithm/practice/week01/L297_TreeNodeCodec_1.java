package com.someecho.algorithm.practice.week01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 297. 二叉树的序列化与反序列化
 * @date Date : 2021年01月07日 9:47 下午
 * @link https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 **/
public class L297_TreeNodeCodec_1 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //把树转化为字符串（使用BFS遍历）
            //边界判断，如果为空就返回一个字符串"#"
            if (root == null) {
                return "#";
            }
            //创建一个队列
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder res = new StringBuilder();
            //把根节点加入到队列中
            queue.add(root);
            while (!queue.isEmpty()) {
                //节点出队
                TreeNode node = queue.poll();
                //如果节点为空，添加一个字符"#"作为空的节点
                if (node == null) {
                    res.append("#,");
                    continue;
                }
                //如果节点不为空，把当前节点的值加入到字符串中，
                //注意节点之间都是以逗号","分隔的，在下面把字符
                //串还原二叉树的时候也是以逗号","把字符串进行拆分
                res.append(node.val + ",");
                //左子节点加入到队列中（左子节点有可能为空）
                queue.add(node.left);
                //右子节点加入到队列中（右子节点有可能为空）
                queue.add(node.right);
            }
            return res.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //如果是"#"，就表示一个空的节点
        if (data == "#") {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //因为上面每个节点之间是以逗号","分隔的，所以这里
        //也要以逗号","来进行拆分
        String[] values = data.split(",");
        //上面使用的是BFS，所以第一个值就是根节点的值，这里创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            //队列中节点出栈
            TreeNode parent = queue.poll();
            //因为在BFS中左右子节点是成对出现的，所以这里挨着的两个值一个是
            //左子节点的值一个是右子节点的值，当前值如果是"#"就表示这个子节点
            //是空的，如果不是"#"就表示不是空的
            if (!"#".equals(values[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            //上面如果不为空就是左子节点的值，这里是右子节点的值，注意这里有个i++，
            if (!"#".equals(values[++i])) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
       return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));