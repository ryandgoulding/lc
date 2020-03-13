package impl;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // null check
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // global head (return value), current node
        ListNode head = null;
        ListNode cur = null;

        // process nodes using pointer to head of list as long as both lists aren't empty
        while (l1 != null && l2 != null) {
            int l1Value = l1.val;
            int l2Value = l2.val;

            if (l1Value < l2Value) {
                if (head == null) {
                    head = l1;
                    cur = head;
                } else {
                    cur.next = l1;
                    cur = l1;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    cur = head;
                } else {
                    cur.next = l2;
                    cur = l2;
                }
                l2 = l2.next;
            }
        }

        // append the tail of the list if needed
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return head;
    }
}