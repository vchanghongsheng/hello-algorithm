package com.chs.recursion;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-03-15 16:56
 **/
public class MergeTwoLists {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    /**
     * 终止条件: l1或者l2为空
     * 公式: l1.val < l2.val ? l1.next = mergeTwoLists(l1.next, l2) : l2.next = mergeTwoLists(l1, l2.next)
     *
     * b==0 结束
     * f(n) = a+ f(n-1)
     */
    public Node mergeTwoLists(Node l1, Node l2) {


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

}
