### 深度优先搜索&广度优先搜索
- [ ] [DFS 代码模板](https://shimo.im/docs/UdY2UUKtliYXmk8t/read) `背诵并默写`
- [ ] [BFS 代码模板](https://shimo.im/docs/ZBghMEZWix0Lc2jQ/read) `背诵并默写`
- [ ] [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)
- [ ] [433. 最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation)
- [ ] [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/#/description)
   - 拓展: 使用广度优先搜索实现
- [ ] [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row)
- [ ] [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/description/)
- [ ] [126. 单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/description/)
- [ ] [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
- [ ] [529. 扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/)


### 贪心算法
- [ ] [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)
- [X] [动态规划wiki](https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92)
- [ ] [860. 柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/) 
- [ ] [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)
- [ ] [455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/)
- [ ] [874. 模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/)
- [ ] [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)
- [ ] [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

#### 贪心算法和动态规划的区别
 - 贪心算法对每个子问题都做出选择,不能回退
 - 动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能
#### 使用贪心算法的条件
- 能证明每一步的贪心之后，最终的结果是正确的

### 二分查找
- [ ] [二分查找代码模板](https://shimo.im/docs/xvIIfeEzWYEUdBPD/read)
- [ ] [Fast InvSqrt() 扩展阅读--牛顿迭代法](https://www.beyond3d.com/content/articles/8/) 
- [ ] [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)
- [ ] [367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)
- [ ] [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
- [ ] [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)
- [ ] [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)
- 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

#### 二分查找的前提条件
1. 目标函数单调性
2. 存在上下界(bounded)
3. 能够通过索引访问(index accessible)
