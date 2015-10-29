/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    	LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
    	List<Integer> list=new ArrayList<Integer>();
    	if(root==null){
    	    return list;
    	}
 		TreeNode node=root;
 		while(stack.size()!=0 || node!=null){
 			 /*if(node!=null){
 				 stack.push(node);
 			 }else if(node.right!=null){
 				 list.add(stack.peek().val);
 				 node=stack.pop().right;
 				 stack.push(node);
 			 }else{
 				 list.add(stack.pop().val);
 				 list.add(stack.peek().val);
 				 node=stack.pop().right;
 				 stack.push(node);
 			 }
 			 node=node.left;*/
			 if(node!=null){
				 stack.push(node);
				 node=node.left;
			 }else{
				 node=stack.pop();
				 list.add(node.val);
				 node=node.right;
				 //判断子问题出错
				/* while(node.right==null){
					 node=stack.pop();
					 list.add(node.val);
				 }
				 if(node.right!=null){
					 node=node.right;
				 }
				 */
				 
			 }
			 
 			 
 		} 
 		return list;
    }
}