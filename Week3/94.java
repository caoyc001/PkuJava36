//使用栈，时间复杂度O(n)，空间复杂度O(n)

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty())
		{
			while(stack.peek()!=null)
			{
				stack.push(stack.peek().left);
				
			}
			TreeNode pNode=stack.pop();
			if(!stack.empty())
			{
				pNode=stack.pop();
				result.add(pNode.val);
				stack.push(pNode.right);
			}
		}
		return result;
    }
}
