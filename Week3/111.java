//仿上周 104 Maximum Depth of Binary Tree
//用栈存中间层
//满二叉树最长，时间复杂度O(logn)
public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        int high=0;
        List<TreeNode> onelevel=new ArrayList<TreeNode>();
        onelevel.add(root);
        while(onelevel.size()!=0)
        {
            high++;
            List<TreeNode> nextlevel=new ArrayList<TreeNode>();
            for(int i=0;i<onelevel.size();i++)
            {
                TreeNode current=onelevel.get(i);
                if(current.left==null && current.right==null) {
                	return high;
				}
                if(current.left!=null)
                {
                    nextlevel.add(current.left);
                }
                if(current.right!=null)
                {
                    nextlevel.add(current.right);
                }

            }
            onelevel=nextlevel;
        }
        return high;
    }
}