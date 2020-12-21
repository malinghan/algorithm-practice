### 问题

https://leetcode.com/problems/design-circular-deque/


### 答案

https://leetcode.com/problems/design-circular-deque/discuss/149371/Java-doubly-LinkedList-solution-very-straightforward

### 答案二

https://leetcode-cn.com/problems/design-circular-deque/solution/641-she-ji-xun-huan-shuang-duan-dui-lie-by-alexer-/

### 补充知识
- (>>>) 运算符 意为 无符号右移
    - 右移n位 => 抛弃后面n位向右移动n位，其余位补0
    - 变量 temp 的值为 -14 （即二进制的 11111111 11111111 11111111 11110010），
    - 向右移两位后等于 1073741820 （即二进制的 00111111 11111111 11111111 11111100）。
-（&）按位与运算符
    - 只有两个数的二进制同时为1时，结果才为1，否则为0
    - 例：3 &5 即 00000011 & 00000101 = 00000001 ，所以 3 & 5的值为1。
- (|) 按位或运算符
    - 只要两个数的二进制一位为1，结果就为1，否则为0
    - 2 | 4 即 00000010 | 00000100 = 00000110 ，所以2 | 4的值为 6
- (^) 异或运算符
    - 只有两个数的相应二进制位为"异"时，结果为1，否则为0
    - 2 ^ 4 即 00000010 ^ 00000100 =00000110 ，所以 2 ^ 4 的值为6
