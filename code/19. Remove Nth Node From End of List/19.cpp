// 19. Remove Nth Node From End of List

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* cursor = new ListNode(0);
        cursor -> next = head;
        ListNode* fast = cursor;
        ListNode* slow = cursor;
        
        for(int i = 0; i <= n; i++)
        {
            fast = fast -> next;
        }
        while( fast != NULL)
        {
            fast = fast -> next;
            slow = slow -> next;
        }
        ListNode* delete_node = slow -> next;
        slow -> next = slow -> next -> next;
        delete delete_node;
        
        return cursor -> next;
    }
};