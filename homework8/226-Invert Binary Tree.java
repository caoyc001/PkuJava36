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
    public TreeNode invertTree(TreeNode root) {
        //直接交换左右儿子吧，为空的情况下要怎样做
        if(root ==null){
            return null;
        }
        /*TreeNode left=root.left;
        TreeNode right=root.right;*/
        if(root.left==null && root.right==null){
            return root;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        /*left=right;
        right=temp;*///没有交换二叉树的结构
        invertTree(root.left);
        invertTree(root.right);
        return root;
         
    }
    
    // public TreeNode invertTree(TreeNode root) {
    //     //直接交换左右儿子吧，为空的情况下要怎样做
    //     if(root ==null){
    //         return null;
    //     }
    //     TreeNode left=root.left;
    //     TreeNode right=root.right;
    //     if(left==null && right==null){
    //         return root;
    //     }
    //     //通过交换值来实现，但是会出现节点空的情况,,，麻烦，不写啦
        
    //     int temp=left.val;
    //     left.val=right.val;
    //     right.val=temp;
    //     /*left=right;
    //     right=temp;*///没有交换二叉树的结构
    //     invertTree(root.left);
    //     invertTree(root.right);
    //     return root;
         
    // }
    
}