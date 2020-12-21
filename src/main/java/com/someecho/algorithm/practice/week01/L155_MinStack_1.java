package com.someecho.algorithm.practice.week01;

import java.util.LinkedList;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2020年12月20日 3:35 PM
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 使用两个stack
 * 1个栈存原始数据`
 * 1个栈存最小元素信息
 **/
public class L155_MinStack_1 {
    
    private LinkedList<Integer> dataStack;
    private LinkedList<Integer> minStack;
    
    /** initialize your data structure here. */
    public L155_MinStack_1() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int x) {
        dataStack.push(x);
        if(minStack.peek() == null || minStack.peek() > x){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
       return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
