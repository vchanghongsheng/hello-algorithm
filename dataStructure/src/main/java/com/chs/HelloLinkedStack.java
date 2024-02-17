package com.chs;

/**
 * 基于链表实现一个栈
 *
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-01-30 19:29
 **/
public class HelloLinkedStack {

    protected int capacity;

    /**
     * 节点头作为栈顶 每来一个新的都是头,取也取头
     */
    protected Node stackPeek;


    static class Node {
        public Node next;
        public Object value;

        public Node(Object value) {
            this.value = value;
        }
    }


    public void push(Object object) {
        Node node = new Node(object);
        capacity++;
        //当前节点指向上一个头
        node.next = stackPeek;
        //stackPeek继续当头结点
        stackPeek = node;
    }

    public Object peek() {
        return stackPeek.value;
    }

    public Object pop() {
        if (capacity == 0) {
            return null;
        }
        capacity--;
        Object value = peek();
        //移除头
        stackPeek = stackPeek.next;
        return value;
    }

    public static void main(String[] args) {
        HelloLinkedStack helloLinkedStack = new HelloLinkedStack();
        helloLinkedStack.push("123");
        System.out.println(helloLinkedStack.peek());
        helloLinkedStack.push("456");
        System.out.println(helloLinkedStack.peek());
        System.out.println(helloLinkedStack.pop());
        System.out.println(helloLinkedStack.peek());

    }

}
