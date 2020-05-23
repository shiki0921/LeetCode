package com.shiki.huawei;

import java.util.Scanner;

/**
 * @author shiki
 * @title:
 * @projectName LeetCode
 * @description: TODO
 * @date 2020/5/23 21:36
 */
public class Test {

    public static void main(String[] args) {
    }

    /**
     * 计算字符的个数
     */
    private static void lengthOfChar() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        Character c = sc.nextLine().toLowerCase().charAt(0);
        String[] split = str.split(c.toString());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
        }
        String str2 = sb.toString();
        System.out.println(str.length()-str2.length());
    }

    /**
     * 最后一个单词的长度
     */
    private static void lengthOfLastWord() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        String last = split[split.length - 1];
        System.out.println(last.length());
    }

}
