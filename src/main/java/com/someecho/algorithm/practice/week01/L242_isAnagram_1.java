package com.someecho.algorithm.practice.week01;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 242. 有效的字母异位词
 * @date Date : 2020年12月26日 1:18 AM
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 **/
public class L242_isAnagram_1 {
    
    //方法一：排序
    //时间复杂度：O(nlogn)
    //空间复杂度：O(logn)
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    
    //方法二：哈希表, 使用int[26]作为字典hash
    //1. 遍历s的字符数组,然后把字符填充到int[26],arr的值是出现的次数
    //2. 遍历int[26]，看看是否都有
    public boolean isAnagram13(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int[] table = new int[26];
        
        for (int i = 0; i < str1.length; i++) {
            table[str1[i] - 'a']++;
        }
    
        for (int i = 0; i < str2.length; i++) {
            table[str2[i] - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if(table[i] != 0){
                return false;
            }
        }
        return true;
    }
    
    //方法二：哈希表, 使用hashmap
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character,Integer> table = new HashMap<>();
    
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
 
}
