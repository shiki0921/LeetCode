package com.shiki.dataStructure;

/**
 * 串的模式匹配算法--BF法（暴力法）
 * @author shiki
 * @date 2019/12/10 - 21:13
 */
public class Index_BF {

    public static void main(String[] args) {
        char[] charsS = {'a'};
    }

    /**
     *
     * @param pos 第pos个字符
     * @param S 主串
     * @param T 模式串
     * @return
     */
    public static int index_BF(int pos,String S,String T){
        char[] charS = S.toCharArray();
        char[] charT = T.toCharArray();
        int i = pos;
        int j = 0;
        while(i <= charS.length && j <= charT.length){
            if (charS[i] == charT[j]){
                ++i;
                ++j;
            }else{
                i = i - j + 2;
                j = 1;
            }

        }
        if (j > charT.length){
            return i - charT.length;
        }else {
            return 0;
        }
    }
}
