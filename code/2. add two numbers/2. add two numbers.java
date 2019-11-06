/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode m = l1, n = l2, curr = dummyhead;
        int carry = 0;
        
        while(m != null || n != null){
            int x = (m !=null) ? m.val:0;
            int y = (n !=null) ? n.val:0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (m != null) m = m.next;
            if (n != null) n = n.next;
        }
        
        if (carry >0) curr.next = new ListNode(carry);
        return dummyhead.next;
    }
}