package com.shiki.listdemo;

/**
 * 单链表实现list
 * @author shiki
 * @date 2019/11/10 - 19:57
 */
public class MySingleList<E> implements IList<E> {

    private int size = 0;

    private Node<E> first;

    private Node<E> last;

    public MySingleList(){}

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e,null);
        //首次插入
        if (last == null){
            first = newNode;
            last = first;
        }else{
            //否则尾指针指向新插入的元素
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public E remove(E e) {
        //定义一个临时节点用于存储被删除节点的前趋节点
        Node<E> temp,target = null;
        //首先遍历链表找到需要删除的元素
        if (e == null){
            for(Node<E> x = first;x != null;x = x.next){
                //找到需要删除的元素的前趋节点
                if (x.e == null){
                    temp = x;
                    target = x.next;
                    //将前趋节点的下一节点指向被删除节点的下一节点
                    temp.next = target.next;
                    size--;
                    //删除成功
                    return null;
                }
            }
        }
        else{
            for(Node<E> x = first;x != null;x = x.next){
                //找到需要删除的元素的前趋节点
                if (x.next != null&&e.equals(x.next.e)){
                    temp = x;
                    target = x.next;
                    //将前趋节点的下一节点指向被删除节点的下一节点
                    temp.next = target.next;
                    size--;
                    //删除成功
                    return (E)target.e;
                }
            }
        }

        //删除失败返回null
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) throws Exception{
        checkSize(index);
        int i = 1;
        Node<E> x = first;
        while (i < index){
            x = x.next;
            i++;
        }
        return x == null ? null : (E)x.e;
    }

    private void checkSize(int i) throws Exception{
        if (i > this.size || i <= 0){
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 单链表
     * @param <E>
     */
    class Node<E>{
        E e;
        Node<E> next;

        public Node(E e,Node<E> next){
            this.e = e;
            this.next = next;
        }
    }
}
