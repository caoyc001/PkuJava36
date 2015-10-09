//先遍历一边找到中位数
//把前半部分翻转
//接着遍历后半部分，与翻转后的前半部分比较
//时间复杂度O(N)
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
	            return true;
	        if(head.next==null)
	            return true;
	        int len=1;
	        ListNode node=head;
	        while(node.next!=null)
	        {
	            len++;
	            node=node.next;
	        }
		//奇数则以MID为中位数，比较MID-1和MID+1，偶数则比较MID和MID+1
		//因此这里需要翻转的也只是前半个，跟奇偶性无关
	        int mid=len/2;
	        ListNode tmp;
	        ListNode preListNode=null;
	        ListNode curListNode=head;
	       for(int i=0;i<mid;i++)
	       {
	           //tmp=curListNode.next.next;
	    	   tmp=curListNode.next;
	    	   curListNode.next=preListNode;
	    	   preListNode=curListNode;
	    	   curListNode=tmp;    	   
	       }
	       ListNode first=preListNode;
	       ListNode second;
	       if(1==(len&1))
	       {
	    	   second=curListNode.next;
	       }
	       else {
			second=curListNode;
	       }
	       for(int i=0;i<mid;i++)
	       {
	    	   if(second.val!=first.val)
	    		   return false;
	    	   second=second.next;
	    	   first=first.next;
	       }        	
	        return true;
        
    }
}