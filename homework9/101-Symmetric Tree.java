
  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null  (root.left==null && root.right==null)){
            return true;
        }
        return isSymmetricNode(root.left,root.right);
    }
    
    public boolean isSymmetricNode(TreeNode left,TreeNode right){
        if((left==null && right!=null)  (left!=null && right==null)){
            return false;
        }
        if(left==null && right==null){
             return true;
        }
        if(left.val!=right.val){
            return false;
        }
         if((left.left.val!=right.right.val)  (left.right.val!=right.left.val)){
             return false;
         }
        乱写的，竟然对了？！！！对递归返回还是不够熟练
        return isSymmetricNode(left.left,right.right) && isSymmetricNode(left.right,right.left);  
    }
}