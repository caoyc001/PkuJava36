/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //LinkedList在实现栈和队列时用到的方法不同
 
public class Solution {
    public int minDepth(TreeNode root) {
       // LinkedList ls=new LinkedList();
       if(root==null){
           return 0;
       }
       //直接用队列实现   error: cannot find symbol: class LinkedBlockingQueue
      /* LinkedBlockingQueue<TreeNode> ls=new LinkedBlockingQueue<TreeNode>();
		root.val=1;
	//	ls.push(root);
	    ls.offer(root);
		TreeNode node=null;
	//	int k=2;
		while(!ls.isEmpty()){
			node=ls.peek();
		//	ls.pop();
		    ls.poll();
			if(node.left!=null){
				//node.left.val=k;
				node.left.val=1+node.val;
			//	ls.push(node.left);
				ls.offer(node.left);
			} 
			if(node.right!=null){
			//	node.right.val=k;
			    node.right.val=1+node.val;
				//ls.push(node.right);
				ls.offer(node.right);
			}
			if(node.left==null && node.right==null){
				return node.val;
			}
		//	k++;
		}
		*/
		//使用链表实现
        LinkedList<TreeNode> ls=new LinkedList<TreeNode>();
		root.val=1;
	//	ls.push(root);
	    ls.offer(root);
		TreeNode node=null;
	//	int k=2;
		while(!ls.isEmpty()){
			node=ls.peekFirst();
		//	ls.pop();
		    ls.poll();
			if(node.left!=null){
				//node.left.val=k;
				node.left.val=1+node.val;
			//	ls.push(node.left);
				ls.offer(node.left);
			} 
			if(node.right!=null){
			//	node.right.val=k;
			    node.right.val=1+node.val;
				//ls.push(node.right);
				ls.offer(node.right);
			}
			if(node.left==null && node.right==null){
				return node.val;
			}
		//	k++;
		}
		return 0;
    }
}