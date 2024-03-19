package com.chs;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @program: hello-algorithm
 * @description: 先进先出队列, 基于数组实现
 * @author: hons.chang
 * @since: 2024-02-21 18:15
 **/
public class HelloArrayQueue<E> implements Queue<E> {


    private final Object[] element;

    private int count;

    public HelloArrayQueue(int capacity) {
        element = new Object[capacity];
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * 添加元素,如果队列已满,抛出异常
     */
    public boolean add(E x) {
        if (count == element.length) {
            throw new IllegalStateException("Queue full");
        }
        element[count++] = x;
        return true;
    }

    /**
     * 添加元素,如果队列已满,返回false
     */
    public boolean offer(E x) {
        if (count == element.length) {
            return false;
        }
        element[count++] = x;
        return true;
    }

    @Override
    public E remove() {
        return null;
    }

    /**
     * 移除队列头元素
     */
    public E poll() {
        //队列为空
        if (count == 0) {
            return null;
        }
        //获取队列头元素
        E x = (E) element[0];
        //移动元素
        for (int i = 0; i < count; i++) {
            element[i] = element[i + 1];
        }
        return x;
    }

    @Override
    public E element() {
        return null;
    }

    /**
     * 获取队列头元素
     */
    public E peek() {
        if (count == 0) {
            return null;
        }
        return (E) element[0];
    }

    public static void main(String[] args) {
        HelloArrayQueue helloArrayQueue = new HelloArrayQueue<String>(10);
        helloArrayQueue.add("abc");
        helloArrayQueue.offer("def");
        System.out.println(helloArrayQueue.peek());
        System.out.println(helloArrayQueue.poll());
        System.out.println(helloArrayQueue.peek());


    }


}
