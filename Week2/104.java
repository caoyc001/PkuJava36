//这里题目要求用DFS，可以用BFS，空间换时间
//时间复杂度为二叉树深度，最坏为O(N)

//DFS
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right?left+1:right+1;
    }
}


//BFS
public class Solution {
    public int maxDepth(TreeNode root) {
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
                if(current.left!=null)
                {
                    nextlevel.add(current.left);
                }
                if(current.right!=null)
                {
                    nextlevel.add(current.right);
                }
            }
            if(nextlevel.size()==0)
            {
                break;
            }
            else
            {
                onelevel=nextlevel;
            }
        }
        return high;
    }
}
