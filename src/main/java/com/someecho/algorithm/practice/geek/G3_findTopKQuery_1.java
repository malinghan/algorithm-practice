package com.someecho.algorithm.practice.geek;

import com.someecho.algorithm.practice.PrintUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.geek
 * @Description: 3. 数据流查询
 * @date Date : 2020年12月20日 2:14 AM
 *
 * 某 X 公司开发设计了一个名为 X 的数据流管理系统，用以处理对数据流的查询。用户可以在 X 中进行注册查询，X 将保持查询在不断变化的数据上执行，并且按照用户所需要的频率返回结果。
 *
 * 具体的指令包括：[queryId, begintime, period]
 * queryId 是用户的注册的 query 的 id（0<id<=3000), begintime 表示该查询开始执行的时间，period(0<period<=3000 秒) 是两次连续执行查询的间隔。
 * 系统中存在多个 query, 可以保证每个 query 都有对应的唯一的 queryId, 你的任务就是告诉前 K 个查询返回结果。
 * 如果两个或多个 query 查询同时返回结果，他们将按照 queryId 的升序逐个返回结果。
 *
 * 示例
 *
 * 输入：
 * [[2004, 200, 200],
 * [2005, 300, 300]]
 * 5
 * 是一组指令,[2004, 200] 表示 queryID 是 2004，第一次运行是 200s 时候，且每隔 200s 运行一次
 *
 * 输出：
 * [2004, 2005, 2004, 2004, 2005]
 *
 * 解释：
 * t = 200 时，执行 2004
 * t = 300 时，执行 2005
 * t = 400 时，执行 2004
 * t = 600 时候，执行 2004, 2005(2004 的 id 小于 2005）
 **/
public class G3_findTopKQuery_1 {
    
    /**
     * 定义1个优先级队列
     *
     * 1. 将 id,time,period 定义为对象
     * 2. 重写其优先级排序关系
     * 3. 入队
     * 4. 取出top k
     */

    public static void main(String[] args) {
        
        int[][] orders = {{2004, 200, 200},{2005, 300, 300}};
        int k =5 ;
        int[] res = new G3_findTopKQuery_1().findTopKQuery(orders,k);
        PrintUtil.printArray(res);
    }
    
    class Query{
        int id;
        int time;
        int period;
        
        Query(int id,
                     int time,
                     int period){
            this.id = id;
            this.time = time;
            this.period = period;
        }
    }

    //2个都执行k次，然后去并集
        public int[] findTopKQuery(int[][] orders, int k) {
            PriorityQueue<Query> queue = new PriorityQueue<>(k,
                    (o1,o2) -> {
                    if(o1.time == o2.time){
                        return o1.id - o2.id;
                    }
                    return o1.time - o2.time;
                }
            );
            for (int i = 0; i < orders.length; i++) {
                queue.offer(new Query(orders[i][0],orders[i][1],orders[i][2]));
            }
        
            int[] t_list = new int[k];
            int m = 0;
            for (int i = 0; i < k; i++) {
                Query query = queue.poll();
                t_list[m] = query.id;
                query.time = query.time + query.period;
                queue.offer(query);
                m++;
            }
            return t_list;
        }
}
