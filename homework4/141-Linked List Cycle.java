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
        ListNode slow=head;
        ListNode fast=head;
      /*  if(head.next==null || head==null){
            return false;
        }*/
        if(head==null || head.next==null){//注意判断顺序
            return false;
        }
        while(fast!=null && fast.next!=null){//注意空指针异常，在这种情况下，应该判断fast.next
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}