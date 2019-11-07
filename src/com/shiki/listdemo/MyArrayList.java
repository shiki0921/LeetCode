package com.shiki.listdemo;

import java.util.Arrays;

/**
 * 实现List
 * 分别用双链表，单链表，数组实现
 * @author shiki
 * @date 2019/11/6 - 21:08
 */
public class MyArrayList<E> implements IList<E> {

    private int size;

    private static Object[] ELEMENT_DATA;

    private static Object[] EMPTY_ELEMENT_DATA = {};

    private final static int DEFAULT_SIZE = 10;

    public MyArrayList(){
        ELEMENT_DATA = EMPTY_ELEMENT_DATA;
    }

    @Override
    public void add(E e) {
        checkCapacity(size+1);
        ELEMENT_DATA[size++] = e;
    }

    @Override
    public E remove(E e) {
        if (size == 0){
            return null;
        }
        if (e != null){
            // 遍历数组
            for (int i = 0; i < this.size; i++) {
                if (e.equals(ELEMENT_DATA[i])){
                    // 如果删除的不是最后一位
                    ELEMENT_DATA[i] = null;
                    // 删除相匹配的第一个元素
                    if (i != this.size-1){
                        // 索引i之后的所有元素左移一位
                        for (int j = i; j < this.size; j++) {
                            ELEMENT_DATA[j] = ELEMENT_DATA[j+1];
                        }
                    }
                    break;

                }
            }
            this.size--;
            // 返回删除元素
            return e;
        }

        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        if (index >= this.size){
            return null;
        }


        return (E)ELEMENT_DATA[index];
    }

    public static void checkCapacity(int minCapacity){
        // 取当前元素个数和默认长度的最大值
        minCapacity = Math.max(minCapacity,DEFAULT_SIZE);
        // 数组扩容
        expansionCapacity(minCapacity);
    }

    public static void expansionCapacity(int minCapacity){
        // 如果当前数组为空
        if (ELEMENT_DATA.length == 0) {
            ELEMENT_DATA = new Object[DEFAULT_SIZE];
        }
        // 如果当前数组长度大于等于默认长度
        if (minCapacity >= ELEMENT_DATA.length){
            // 默认扩容一倍
            ELEMENT_DATA = Arrays.copyOf(ELEMENT_DATA,ELEMENT_DATA.length*2);
        }
    }
}

