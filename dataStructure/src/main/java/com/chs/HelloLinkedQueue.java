package com.chs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;

/**
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-02-29 08:21
 **/
public class HelloLinkedQueue implements Queue {

    class Node {
        public Node next;
        public Object value;

        public Node(Object value) {
            this.value = value;
        }
    }

    /**
     * 节点头作为队列头 每来一个新的都是头,取也取头
     */
    private Node head;


    private int count;


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
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        Node node = new Node(o);
        if (head == null) {
            head = node;
            count++;
            return true;
        }
        node.next = head;
        head = node;
        count++;
        return true;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        Object value = head.value;
        Node next = head.next;
        head = next;
        return value;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return head.value;
    }

//    public static void main(String[] args) {
//        HelloLinkedQueue helloLinkedQueue = new HelloLinkedQueue();
//        helloLinkedQueue.offer("123");
//        System.out.println(helloLinkedQueue.peek());
//        helloLinkedQueue.offer("456");
//        System.out.println(helloLinkedQueue.peek());
//        System.out.println(helloLinkedQueue.poll());
//        System.out.println(helloLinkedQueue.peek());
//    }

    public static void main(String[] args) {
        String text = "Hello, world!123的点点滴滴的点点滴滴23的说法阿帆111wdsasdfsdfasfadsfafasfasfasfaf";
        try {
            // 创建一个MessageDigest实例，初始化为SHA-256算法
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 对输入文本进行哈希计算
            byte[] hashBytes = digest.digest(text.getBytes());

            // 将哈希值转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // 输出哈希值
            System.out.println("SHA-256 Hash: " + hexString.toString());
            //97017f859c4b35aafb7c8d710d013e6a
            //f0d7227e9106ec77861b8b5b11289c043e63db84b413aeecfc861be33876023f
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 algorithm not found");
        }
    }
}
