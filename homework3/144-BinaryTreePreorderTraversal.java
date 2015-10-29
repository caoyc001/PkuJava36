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
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode node=root;
        List<Integer> list=new ArrayList<Integer>();
       // Queue<TreeNode> queue=new BlockingQueue<TreeNode>();
        //Queue<TreeNode> queue=new LinkedBlockingQueue<TreeNode>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        if(root==null){
            return list;
        }
        while(queue.size()!=0 || node!=null){
            if(node!=null){
                queue.offer(node);
                if(node.right!=null){
                    stack.push(node.right);
                }
                node=node.left;
            }else{
                // node=queue.poll();
                // list.add(node.val);
                list.add(queue.poll().val);
                if(stack.size()!=0){
                    node=stack.pop();
                }
                
            }
        }
        return list;
    }
}