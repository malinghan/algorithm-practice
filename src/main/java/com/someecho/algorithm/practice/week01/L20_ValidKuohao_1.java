package com.someecho.algorithm.practice.week01;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 20. 有效的括号
 * @date Date : 2020年12月20日 3:12 PM
 * @link https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 **/
public class L20_ValidKuohao_1 {
    
    public static void main(String[] args) {
        String s = "()";
        System.out.println(new L20_ValidKuohao_1().isValid(s));
    }
    
    /**
     * 方法1: 栈
     *
     * for循环字符数组，然后压栈，如果出现配对的则弹栈
     * 定义一个hashMap，用于快速检索配对关系
     * 最后看栈是否为空
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        if(s == null){
            return true;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty()){
                 if(s.charAt(i) == map.getOrDefault(stack.peek(),'0')){
                     stack.pop();
                 }else {
                     stack.push(s.charAt(i));
                 }
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
