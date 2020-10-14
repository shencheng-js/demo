package liKou.treeQuestion;

/**
 * @author sc
 * @date 2020/9/26
 **/
public class ListNode {
    public ListNode next;
    int val;
//    ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}