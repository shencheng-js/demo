package liKou.simple;

/**
 * @author sc
 * @date 2020/10/4
 **/


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 理论上非常简单，从尾到头，只要考虑进位，利用符号位进位
 */
public class _2 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 8, 7, 4};

        ListNode l1 = ListNode.concert(nums1);
        ListNode l2 = ListNode.concert(nums2);

        ListNode l3 = new _2().addTwoNumbers(l1, l2);

        ListNode.show(l3);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode ret = new ListNode((l1.val + l2.val) % 10);
        ListNode temp = ret;
        boolean flag = (l1.val + l2.val) / 10 == 1 ? true : false;  //进位信号
        l1 = l1.next;
        l2 = l2.next;


        while (l1 != null && l2 != null) {
            int num;
            int tempint;
            if (flag) {
                tempint = 1;
            } else {
                tempint = 0;
            }
//            System.out.println(flag);
            num = (l1.val + l2.val + tempint) % 10;
            flag = (l1.val + l2.val + tempint) / 10 == 1 ? true : false;

            temp.next = new ListNode(num);

            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int num;
            int tempint;
            if (flag) {
                tempint = 1;
            } else {
                tempint = 0;
            }
            num = (l1.val + tempint) % 10;
            flag = (l1.val + tempint) / 10 == 1 ? true : false;
            temp.next = new ListNode(num);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int num;
            int tempint;
            if (flag) {
                tempint = 1;
            } else {
                tempint = 0;
            }
            num = (l2.val + tempint) % 10;
            flag = (l2.val + tempint) / 10 == 1 ? true : false;
            temp.next = new ListNode(num);
            temp = temp.next;
            l2 = l2.next;
        }
        if (flag) {
            temp.next = new ListNode(1);
        }
        return ret;
    }
}
