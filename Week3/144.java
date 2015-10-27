//先序遍历
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode;
		stack.push(root);
		while (!stack.empty())
		{
			while(stack.peek()!=null)
			{
				pNode=stack.pop();
				result.add(pNode.val);
				stack.push(pNode.right);
				stack.push(pNode.left);
				
				
			}
			if(!stack.empty())
			{
				stack.pop();
			}
		}
			
		return result;
    }
}