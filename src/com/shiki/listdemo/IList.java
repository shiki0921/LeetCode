package com.shiki.listdemo;

/**
 * @author shiki
 * @date 2019/11/6 - 21:07
 */
public interface IList<E> {

    public void add(E... e);

    public E remove(E e);

    public int size();

    public E get(int index);
}
