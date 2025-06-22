package Google.LastThreeMonth;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

//Example 1:
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]

//Example 3:
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;

        while (l1 != null && l2 != null) {
            if (l1.val + l2.val + carry < 10) {
                int sum = l1.val + l2.val + carry;
                cur.next = new ListNode(sum);
                carry = 0;
            } else {
                int sum = l1.val + l2.val + carry;
                cur.next = new ListNode(sum % 10);
                carry = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum < 10) {
                cur.next = new ListNode(sum);
                carry = 0;
            } else {
                cur.next = new ListNode(sum % 10);
                carry = 1;
            }
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum < 10) {
                cur.next = new ListNode(sum);
                carry = 0;
            } else {
                cur.next = new ListNode(sum % 10);
                carry = 1;
            }
            l2 = l2.next;
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

