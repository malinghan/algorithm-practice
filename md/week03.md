### 泛型递归、树的递归

- [X] [递归代码模板](https://shimo.im/docs/EICAr9lRPUIPHxsH/read)
- [X] [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
- [X] [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
- [X] [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/description/)
- [X] [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)
- [X] [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
- [X] [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
- [X] [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
- [X] [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [X] [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

#### 递归代码模板
```
 public void recr(level,param){
    //terminator 终止条件
    if(level > MAX_LEVEL){
      //process result
      return;
    }
    
    //process current logic 处理当前层的逻辑
    process(level,param);
    
    //drill down 往下递归
    recur(level:level+1,newParam);
    
    //恢复、清扫当前层的状态
    //restore current status
 }
```

#### 树的递归代码模板

- [树-递归模板思路总结](https://blog.csdn.net/qq_43539599/article/details/104531204)


#### 递归的3个思维要点
1. 不要人肉递归
2. 找到最近最简方法，将其拆解成可重复解决的问题(重复子问题)
3. 数学归纳法(放鞭炮)



### 分治、回溯
- [X] [分治代码模板](https://shimo.im/docs/zvlDqLLMFvcAF79A/read)
- [X] [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
- [ ] [回溯思想](https://www.geeksforgeeks.org/backtracking-introduction/)
- [ ] [回溯算法套路详解](https://zhuanlan.zhihu.com/p/93530380)  
- [X] [77. 组合](https://leetcode-cn.com/problems/combinations/)
- [X] [46. 全排列](https://leetcode-cn.com/problems/permutations/)
- [X] [47. 全排列II](https://leetcode-cn.com/problems/permutations-ii/)
- [X] [50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)
- [X] [78. 子集](https://leetcode-cn.com/problems/subsets/)
- [X] [169. 众数](https://leetcode-cn.com/problems/majority-element/description/)
- [X] [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) 
- [X] [51. N 皇后](https://leetcode-cn.com/problems/n-queens/)

#### 分治代码模板

```
private static int divide_conquer(Problem problem,param){
   if(problem == null){
      int res = process_last_result();
      return res;
   }
   
   subProblems = split_problem(problem);
   
   res0 = divide_conquer(subProblems[0]);
   res1 = divide_conquer(subProblems[1]);
   res2 = divide_conquer(subProblems[2]);
   ...
   
  result = process_result(res0,res1,res2,...);
  
  return result;
}
```

### 作业提交

```
中等：
- 二叉树的最近公共祖先（Facebook 在半年内面试常考）
- 从前序与中序遍历序列构造二叉树（字节跳动、亚马逊、微软在半年内面试中考过）
- 组合（微软、亚马逊、谷歌在半年内面试中考过）
- 全排列（字节跳动在半年内面试常考）
- 全排列 II （亚马逊、字节跳动、Facebook 在半年内面试中考过）
```
#### 代码
- [代码](/java/com/someecho/algorithm/practice/week01)

### 笔记
- [blog12-回溯法的解题模板](/md/blog12-回溯法的解题模板.md)
- [L50-快速幂算法](/md/L50-快速幂算法.md)