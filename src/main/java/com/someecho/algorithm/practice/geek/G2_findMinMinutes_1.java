package com.someecho.algorithm.practice.geek;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.geek
 * @Description: 2. 追赶朋友
 * @date Date : 2020年12月19日 7:01 PM
 * 小张和骑友小王在路上上不小心走散，小张通过定位仪找到小王的位置并且希望能快速找到小王。
 * 小张最开始在 N 点位置 (0 ≤ N ≤ 100,000)，小王显示在 K 点位置 (0 ≤ K ≤ 100,000)，
 * 小张有两种移动方式：
 * 方式一：在任意点 X，向前走一步 X + 1 或向后走一步 X - 1 需要花费一分钟
 * 方式二：在任意点 X，向前移动到 2 * X 位置需要花费一分钟
 *
 * 假设小王就在原地等待不发生移动，那么小张找到小王最少需要多少分钟？
 **/
public class G2_findMinMinutes_1 {
    
    /**
     * 起点n，终点k，当前位置a，下一位置b，辅助容器记录step[]记录到达位置最少步数
     * 1. 若 b 超出不合理范围[0,2k]，返回
     * 2. 若 b 曾经走过，step[b] > 0 && step[b] < step[a] + 1, 当前路线不比历史路线更优，返回
     * 3. 记录 step[b]  = step[a] + 1
     * 4. 若b == k，即找到隔壁小王，返回
     * 5. 寻找下一步
     * find b -> b+1
     * find b -> b-1
     * find b-> b<<1
     *
     * 递归结束后，到达k的最少步数即为step[k]
     *
     * 如果超时，请思考：每个点最多会被访问多少次？这么做比正常的BFS差在哪里？为什么会差？
     *
     * 你对于BFS的理解还不太深刻，
     * 事实上BFS最关键的一点是由于搜索的顺序而保证了单调性，每个点第一次被搜索到一定是距离最短的走法，
     * 而不是因为有visited而避免重走（你这种做法也可以开个visited啊，但是关键是你不能保证第一次遇到就一定是最短距离）
     *
     * 再好好思考一下空间复杂度？BFS只需要记录走的位置，那么数组最坏情况下开多大？
     * 和数据规模有什么定量关系？
     * 你的这种做法数组要开多大？
     * 大概的函数栈有多深？
     * 和数据规模有什么关系？
     *
     * 以点16为例，点15,17,8的更新都有可能带来点16答案的更新，但是你能保证15,17,8这三个点只被更新一次么？
     *
     * BFS一层层往外扩散的确可以保证首次到达的步数最少，相比这种做法无法保证这一点
     *
     * 完全没有严谨的分析，用人话都没法说明白想怎么做，甚至搞不清楚复杂度的概念
     *
     * 这道题，求最短距离，考察的就是BFS的单调性这一特性，你的这种做法，破坏了单调性，直接把O(N)的做法变成了有剪枝的枚举
     * @param n
     * @param k
     * @return
     */
    public int findMinMinutes1(int n, int k) {
        // X -> X+1 X-1
        // X -> 2X
        return 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new G2_findMinMinutes_1().findMinMinutes(5,17));
        System.out.println(new G2_findMinMinutes_1().findMinMinutes(10,10));
        System.out.println(new G2_findMinMinutes_1().findMinMinutes(10,5));
        System.out.println(new G2_findMinMinutes_1().findMinMinutes(4,7));
    }
    
    
    
    public int findMinMinutes(int n, int k) {
        int MAX = 200000;
        int[] min  = new int[MAX];
        boolean[] visited = new boolean[MAX];
        Queue<Integer> queue = new LinkedList<>();
        min[n] = 0;
        visited[n] = true;
        queue.offer(n);
        
        while(!queue.isEmpty()){
            int next = queue.poll();
            for (int i = 0; i < 3; i++) {
                int temp = next;
                if(i == 0){
                    temp = temp +1;
                }else if(i == 1){
                    temp = temp -1;
                }else {
                    temp = 2 * temp;
                }
                
                if(!visited[temp]){
                    queue.offer(temp);
                    visited[temp] = true;
                    min[temp] = min[next] +1;
                }
                
                if(temp == k){
                    return min[temp];
                }
            }
        }
        return -1;
    }
    
}
