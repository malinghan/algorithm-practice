### 前4小结
- [递归代码模板](https://shimo.im/docs/EICAr9lRPUIPHxsH/read)
- [分治代码模板](https://shimo.im/docs/zvlDqLLMFvcAF79A/read)

> 1. 五毒神掌
> 2. 脑图+笔记总结
> 3. 失败只有一种，那就是半途而废
> 4. 比别人多一点执着，你就会创造奇迹

### 动态规划(一)
- [ ] [动态规划定义](https://www.geeksforgeeks.org/dynamic-programming/)
- [ ] [斐波那契数列](https://leetcode-cn.com/problems/fibonacci-number/)
- [ ] [count the paths]()
- [ ] [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)
- [ ] [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)
- [ ] [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
- [ ] [【MIT课程】动态规划 I - 最短路径算法](https://www.bilibili.com/video/av53233912)

#### 什么是动态规划？
- 分治+最优子问题

动态和递归或分治的关系
- 共性: 找到重复子问题
- 差异性：存在最优子结构、中途可以淘汰次优解

#### 动态规划的关键点
1. 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
2. 存储中间状态 opt[i]
3. 递推公式(状态转移方程、或者DP方程)


