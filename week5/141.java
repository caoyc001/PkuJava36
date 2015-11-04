/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode Node1=head;
        ListNode Node2=head;
        while(Node1!=null&&Node2!=null)
        {
            Node1=Node1.next;
            if(Node2.next!=null)
           { Node2=Node2.next.next;
            if(Node1==Node2)
            return true;}
            else break;
        }
        return false;
    }
}