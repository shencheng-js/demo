package liKou.Linkedlist;


import liKou.treeQuestion.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 * <p>
 * <p>
 * 没有用头节点，所以说数据结构的头节点很重要
 */
public class _24 {
    public ListNode swapPairs(ListNode head) {

        ListNode emptyHead = new ListNode();
        emptyHead.next = head;
        ListNode pre = emptyHead;
        if (head == null) {
            return null;
        }

        while (pre.next != null && pre.next.next != null) {
            ListNode one = pre.next;
            ListNode two = pre.next.next;

            pre.next = two;
            one.next = two.next;
            two.next = one;

            pre = one;
        }

        return emptyHead.next;
    }
}
