public class Solution {
//它是一棵空树或它的左右两个子树的高度差的绝对值不超过1,
//并且左右两个子树都是一棵平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftheight=getheight(root.left);
        int rightheight=getheight(root.right);
        if (Math.abs(leftheight-rightheight)>1)
        {
            return false;
        }
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    public int getheight(TreeNode node)
    {
        if(node == null)  
        {  
            return 0;  
        }  

        if(node.left == null)  
        {  
            return getheight(node.right) + 1;  
        }  
        if(node.right == null)  
        {  
            return getheight(node.left) + 1;  
        }  

        int left = getheight(node.left);  
        int right = getheight(node.right);  
        return left<right?(right+1):(left+1);  
    }
}