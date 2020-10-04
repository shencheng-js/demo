package liKou.simple;

/**
 * @author sc
 * @date 2020/10/4
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }

    public static ListNode concert(int[] temp) {//构筑一个listnode，从头返回
        int len = temp.length;
        ListNode head = new ListNode(temp[0]);
        ListNode tail = head;
        for (int i = 1; i < len; i++) {
            tail.next = new ListNode(temp[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void show(ListNode temp) {//展示
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
