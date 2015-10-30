public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        if(head.next==null)
            return false;
        ListNode onestep=head.next;
        ListNode twostep=head.next.next;
        while(twostep!=null && twostep.next!=null)
        {
            if(onestep==twostep)
                return true;
            onestep=onestep.next;
            twostep=twostep.next.next;
        }
        return false;
    }
}