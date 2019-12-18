package com.shiki.listdemo;

/**
 * 双端队列实现List
 * @param <E>
 */
public class MyDequeList<E> implements IList<E> {

    private int size;

    private Node<E> head,tail;

    public MyDequeList(){super();};

    @Override
    public void add(E e) {
        Node<E> node = new Node<E>(e);

        if (this.head == null){
            this.head = node;
            this.tail = this.head;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        size++;
    }

    @Override
    public E remove(E e) {
        //空队列
        if (this.head == null){
            return null;
        }

        //从头结点开始遍历
        for(Node<E> current = this.head;current != null;current = current.next){
            if (checkVal(e,current.val)){
                //如果是头结点
                if (current.prev == null){
                    this.head = current.next;
                }else{
                    current.prev.next = current.next;
                }

                if (current.next != null){
                    current.next.prev = current.prev;
                }else{
                    this.tail = current.prev;
                }

                this.size--;
                return e;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) throws Exception {
        if (index > this.size){
            throw new IndexOutOfBoundsException();
        }

        //从头结点开始遍历
        Node<E> current = this.head;
        int i = 0;
        while(i < index){
            current = current.next;
            i++;
        }

        return current.val;
    }

    private boolean checkVal(E target,E val){
        return target == null ? false : target.equals(val);
    }

    class Node<E>{
        E val;
        Node<E> prev,next;

        public Node(E val){
            this.val = val;
        }
    }
}
