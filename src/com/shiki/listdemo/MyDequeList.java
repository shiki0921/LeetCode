package com.shiki.listdemo;

public class MyDequeList<E> implements IList<E> {
    @Override
    public void add(Object o) {

    }

    @Override
    public Object remove(Object o) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(int index) throws Exception {
        return null;
    }

    class Node<E>{
        E val;
        Node<E> prev;
        Node<E> next;

        public Node(E val,Node<E> prev,Node<E> next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
