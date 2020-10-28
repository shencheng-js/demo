package liKou.digui;

import liKou.treeQuestion.ListNode;

public class _234 {
    ListNode fre = new ListNode();

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     *
     *
     * public boolean isPalindrome(ListNode head) {
     fre = head;
     return weather(head);
     }
     * private boolean weather(ListNode head) {
     *         if (head!=null){
     *             if (!weather(head.next)){//判断之前情况，刚从结尾进来就是true，自然不会false
     *                 return false;//如果前面的有false，后续一直向前
     *             }
     *             if (fre.val!=head.val){//后面的都相等，判断当前
     *                 return false;//
     *             }
     *             fre = fre.next;//前面判断结束，下一个
     *         }
     *         return true;//当到达最后一层时，return
     *     }
     * @param head
     * @return
     */

}
