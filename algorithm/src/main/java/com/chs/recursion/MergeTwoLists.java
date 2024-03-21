package com.chs.recursion;

/**
 * #21.合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-03-15 16:56
 **/
public class MergeTwoLists {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    /**
     * 终止条件: l1 || l2 ==null
     * 公式: 每次拿出来一个node比较,剩下的又变成了两个有序列表的合并
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 如果不用递归 就迭代
     */
    public static Node mergeTwoLists1(Node l1, Node l2) {
        Node preHead = new Node(-1);
        Node prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;


        Node node4 = new Node(2);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        node4.next = node5;
        node5.next = node6;

        Node node = mergeTwoLists1(node1, node4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
