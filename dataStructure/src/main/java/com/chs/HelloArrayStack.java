package com.chs;

import java.util.Arrays;

/**
 * 用数组实现一个栈 先进后出
 * https://www.hello-algo.com/chapter_stack_and_queue/stack/
 *
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-01-30 18:46
 **/
public class HelloArrayStack {
    public HelloArrayStack() {
        elementData = new Object[10];
        capacity = 0;
    }

    protected Object[] elementData;

    protected int capacity;


    public void push(Object object) {
        capacity++;
        if (capacity - elementData.length < 0) {
            //没有超过容量上限,添加元素
            System.out.println("没有超过容量上限,添加元素");
        } else {
            //超过容量上限,扩容一倍
            System.out.println("容量超过上限,扩大一倍");
            int newCapacity = capacity << 1;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[capacity] = object;
    }

    /**
     * 访问栈顶元素
     */
    public Object peek() {
        return elementData[capacity];
    }


    /**
     * 出栈
     */
    public Object pop() {
        if (capacity == 0) {
            return null;
        }
        Object peek = this.peek();
        elementData[capacity] = null;
        capacity--;
        return peek;
    }

    public static void main(String[] args) {
        HelloArrayStack helloArrayStack = new HelloArrayStack();
        helloArrayStack.push("123");
        helloArrayStack.push("456");
        System.out.println(helloArrayStack.peek());
        System.out.println(helloArrayStack.pop());
        System.out.println(helloArrayStack.peek());
    }

}
