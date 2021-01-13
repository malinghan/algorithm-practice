package com.someecho.algorithm.practice.week01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 电话号码的组合
 * @date Date : 2021年01月13日 11:39 下午
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 **/
public class L17_letterCombinations_1 {
    
    public static void main(String[] args) {
        List<String> res = new L17_letterCombinations_1().letterCombinations("23");
        System.out.println(res);
    }
    
    //1. 先定义一个 num -> List<String> 的字符映射
    //2. 每次分支挑选
    public List<String> letterCombinations(String digits) {
        backtrack(digits,0,new StringBuffer());
        return res;
    }
    
    public static Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    
    public static List<String> res = new ArrayList<>();
    
    private  void backtrack(String digits,int level,StringBuffer stringBuffer) {
            if(level == digits.length()){
                res.add(stringBuffer.toString());
                return;
            }
            String res = phoneMap.get(digits.charAt(level));
            int len = res.length();
            for (int j = 0; j < len; j++) {
                stringBuffer.append(res.charAt(j));
                backtrack(digits,level+1,stringBuffer);
                stringBuffer.deleteCharAt(level);
            }
    }
}
