/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	
 
    public boolean isPalindrome(ListNode head) {
  
    	ListNode slow=head;
    	ListNode fast=head;
    	ListNode mid;
    	if(head==null || head.next==null){
    		return true;
    	}
    	while(fast!=null && fast.next!=null){//����ָ�������λ������ָ��Ϊ��ָ���2��������ָ���ߵ��������ս��ʱ����ָ�����н����
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	if(fast!=null){
    	    slow=slow.next;
    	} 
    	ListNode prev=slow;
    	ListNode rear=prev.next;
    	prev.next=null;//�ضϷ�ת����β������Ȼ���γɻ�ָ�룬��������бȽ�ֵʱ����ѭ��
    	while(rear!=null){
    		ListNode temp=rear.next;
    		rear.next=prev;
    		prev=rear;
    		rear=temp;
    	}
    	
    	ListNode p=head;
    	while(prev!=null){
    		if(p.val!=prev.val){
    			return false;
    		}
    		p=p.next;
    		prev=prev.next;
    	}
		return true;
    }
    
}

//��ʱ~~~~
    /*	int length=0;
    	ListNode prev=head;
    	ListNode rear=head;
    	ListNode mid=head; 
    	if(head==null || head.next==null){
    		return true;
    	}
    	for(ListNode ptr = head;ptr!=null;ptr=ptr.next){ 
    		length++;
    	}
    	for(int i=0;i<length/2;i++){
    		mid=mid.next;
    	}
    	if(length%2!=0){
    		mid=mid.next;
    	}
    	rear=mid; 
  
    	for(int i=length/2;i>0;i--){//����������ʱ�临�Ӷ�n^2/2
    		for(int j=0;j<i-1;j++){
    			int temp=rear.next.val;
    			rear.next.val=rear.val;
    			rear.val=temp;
    		}
    	}
    	rear=mid; 
    	
    	for(int i=0;i<length/2;i++){
    		if(prev.val!=rear.val){
    			return false;
    		}
    		prev=prev.next;
    		rear=rear.next;
    	}
    	
    	return true;
		 
    }
}*/