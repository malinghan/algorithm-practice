https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/


### 代码模板

```
 Stack<Integer> stack = new Stack<>();
 
 while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
    int m = stack.poll();
    //do-something
 }
 stack.push(i);
```

### 类似的题目

- [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)
- [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/) 
- [739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)
- [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)