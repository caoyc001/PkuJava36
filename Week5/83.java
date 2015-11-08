/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        ListNode first=head;
        ListNode pre=head;
        head=head.next;
        while(head!=null)
        {
            // if(pre==null)
            // {
            //     pre=head;
            //     head=head.next;
            // }
            if(head.val==pre.val)
            {    
                pre.next=head.next;
                
            }
            else
            {
                pre=head;
            }
            head=head.next;
            
        }
        return first;
    }
}