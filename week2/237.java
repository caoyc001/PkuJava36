/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode a,b;
        a=node.next;
       node.val=a.val;
       node.next=a.next;
      
      
        
        
    }
}