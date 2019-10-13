package com.shiki.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiki
 * @date 2019/10/13 - 21:49
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        //String s = "pwwkew";
        //String s = "bbbbb";
        //String s = "abcabcbb";
        //String s = "bbtablud";
        String s = "bbtabl";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int maxLength = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < chars.length;i++) {

            if (map.containsKey(chars[i])){
                maxLength = Math.max(count,maxLength);
                count = i-map.get(chars[i]);
                int index = map.get(chars[i]);
                map.clear();
                for(int j = index+1;j <= i;j++){
                    map.put(chars[j],j);
                }
            }else{
                count++;
                map.put(chars[i],i);
            }
            if (i == chars.length-1){
                maxLength = Math.max(count,maxLength);
            }

        }
        return maxLength;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
