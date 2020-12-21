## 题目
https://leetcode-cn.com/problems/3sum/submissions/
## 方法1

双层循环+hashMap

## 方法2
排序+双指针遍历 

## 思路
```java
 /**
     * sort
     * for i
     * l= i+1 ,r = len -1;
     * sum = num[l] + num[r]+num[i];
     * if(i >0  && num[i] == num[i-1]) continue;
     * if(sum == 0)
     *    if: l<r && nums[L] = nums[L+1] L++;
     *    if: l<r && nums[R] = nums[R-1] R--;
     *  L++;R--;   
     * if(sum <0)
     *    L++;
     * is(sum >0)
     *    R--;
     * @param nums
     * @return
     */
 ```
 
 ## 注意
 - 循环时别忘了边界判断: l < r
 - sum相等时，别忘了: L++; R--;
 - 必须先排序，才能用双端指针遍历
