### 参考
- [回溯算法的套路](https://zhuanlan.zhihu.com/p/93530380)
#### 回溯法框架
```
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```

其核心就是 for 循环里面的递归，在递归调用之前「做选择」，在递归调用之后「撤销选择」，特别简单。

什么叫做选择和撤销选择呢，这个框架的底层原理是什么呢？

#### 一、全排列问题

我们在高中的时候就做过排列组合的数学题，我们也知道 n 个不重复的数，全排列共有 n! 个。

PS：为了简单清晰起见，我们这次讨论的全排列问题不包含重复的数字。

![sss](/Users/malinghan/IdeaProjects/hmily/algorithm-practice/image/20210108121409.jpg)

只要从根遍历这棵树，记录路径上的数字，其实就是所有的全排列。我们不妨把这棵树称为回溯算法的「决策树」

你现在就在做决策，可以选择 1 那条树枝，也可以选择 3 那条树枝。为啥只能在 1 和 3 之中选择呢？因为 2 这个树枝在你身后，这个选择你之前做过了，而全排列是不允许重复使用数字的。

现在可以解答开头的几个名词：
- [2] 就是「路径」，记录你已经做过的选择；
- [1,3] 就是「选择列表」，表示你当前可以做出的选择；
- 「结束条件」就是遍历到树的底层，在这里就是选择列表为空的时候。

如果明白了这几个名词，可以把「路径」和「选择」列表作为决策树上每个节点的属性，比如下图列出了几个节点的属性：

![aaa](/Users/malinghan/IdeaProjects/hmily/algorithm-practice/image/img.png)

我们定义的 backtrack 函数其实就像一个指针，
在这棵树上游走，同时要正确维护每个节点的属性，
每当走到树的底层，其「路径」就是一个全排列。

##### 多叉树的遍历
```
void traverse(TreeNode root) {
    for (TreeNode child : root.childern)
        // 前序遍历需要的操作
        traverse(child);
        // 后序遍历需要的操作
}
```
前序遍历的代码在进入某一个节点之前的那个时间点执行，
后序遍历代码在离开某个节点之后的那个时间点执行。

回想我们刚才说的，「路径」和「选择」是每个节点的属性，函数在树上游走要正确维护节点的属性，那么就要在这两个特殊时间点搞点动作：

![aaa](/Users/malinghan/IdeaProjects/hmily/algorithm-practice/image/img_1.png)

我们只要在递归之前做出选择，在递归之后撤销刚才的选择，就能正确得到每个节点的`选择列表`和`路径`。


但是必须说明的是，不管怎么优化，都符合回溯框架，
而且时间复杂度都不可能低于 O(N!)，因为穷举整棵决策树是无法避免的。
这也是回溯算法的一个特点，不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。


##### 全排列代码

```
List<List<Integer>> res = new LinkedList<>();

/* 主函数，输入一组不重复的数字，返回它们的全排列 */
List<List<Integer>> permute(int[] nums) {
    // 记录「路径」
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return res;
}

// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
void backtrack(int[] nums, LinkedList<Integer> track) {
    // 触发结束条件
    if (track.size() == nums.length) {
        res.add(new LinkedList(track));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        // 排除不合法的选择
        if (track.contains(nums[i]))
            continue;
        // 做选择
        track.add(nums[i]);
        // 进入下一层决策树
        backtrack(nums, track);
        // 取消选择
        track.removeLast();
    }
}
```
### 不可重复穷举回溯


```
  public void backtrack(int[] nums, int index, Stack<Integer> temp){
       if(temp.size() == 4){
           System.out.println(temp);
       }
       for (int i = index; i < nums.length; i++) {
           System.out.println(temp);
           temp.push(nums[i]);
           backtrack(nums,i+1,temp);
           temp.pop();
       }
   }

```
### 可重复穷举回溯

```

```