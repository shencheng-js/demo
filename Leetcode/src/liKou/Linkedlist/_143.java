package liKou.Linkedlist;

import liKou.treeQuestion.ListNode;

import java.util.Stack;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * 用栈存储，但其实不好，如果数据量大就不好了
 * <p>
 * 可以用双指针找到中间节点后，对后面的进行逆序即可
 */
public class _143 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
//        new _143().reorderList(one);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int len = stack.size() / 2;
        ListNode a;
        ListNode pop;
        temp = head;
        for (int i = 0; i < len; i++) {
            a = temp.next;
            pop = stack.pop();
//            System.out.println("将"+temp.val+" 接入"+pop.val);
            temp.next = pop;
            pop.next = a;
            temp = a;
//            System.out.println(temp.val);
        }
        temp.next = null;
        return;
    }

    public void reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
    }
}
