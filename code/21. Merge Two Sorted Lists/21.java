/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode newList = new ListNode(-1);
        ListNode location = newList;
        
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                newList.next = l2;
                l2 = l2.next;
            }
            else{
                newList.next = l1;
                l1 = l1.next;
            }
            newList = newList.next;
        }
        
        newList.next = l1 == null ? l2:l1; 
        return location.next;
        
    }
}