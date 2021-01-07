package com.someecho.algorithm.practice.week01;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @date Date : 2021年01月07日 5:08 下午
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 **/

public class L22_generateParenthesis_1 {
    
    public static void main(String[] args) {
        System.out.println(new L22_generateParenthesis_1().generateParenthesis1(3));
    }
    
    /**
     * 方法1:递归法: 程序一定是一颗递归树
     * level:
     * max:
     * current string:
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        return _generateParenthesis1(0,0,n,"",new ArrayList<>());
    }
    
    public List<String> _generateParenthesis1(int left,int right,int n,String s,List<String> res){
//        if(left >= n && right >= n){
//            res.add(s);
//        }
        if(s.length() == 2 * n){
            res.add(s);
        }
        //terminal: 左括号和右括号都用完,先不管是不是符合预期，全排列就行了
    
        //process:
        //filter: 左括号随时都可以加上去，
        // 右括号在加之前，右括号必须小于左括号
        //drill down:
        if(left < n) {
            _generateParenthesis1(left + 1, right, n, s + "(",res);
        }
        if( left > right ) {
            _generateParenthesis1(left, right + 1, n, s + ")",res);
        }
//        _generateParenthesis1(left+1,right+1,n,s + "]");
//        _generateParenthesis1(left+1,right+1,n,s + "[");
        return res;
    }
}
