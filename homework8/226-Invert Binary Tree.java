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
        //ֱ�ӽ������Ҷ��Ӱɣ�Ϊ�յ������Ҫ������
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
        right=temp;*///û�н����������Ľṹ
        invertTree(root.left);
        invertTree(root.right);
        return root;
         
    }
    
    // public TreeNode invertTree(TreeNode root) {
    //     //ֱ�ӽ������Ҷ��Ӱɣ�Ϊ�յ������Ҫ������
    //     if(root ==null){
    //         return null;
    //     }
    //     TreeNode left=root.left;
    //     TreeNode right=root.right;
    //     if(left==null && right==null){
    //         return root;
    //     }
    //     //ͨ������ֵ��ʵ�֣����ǻ���ֽڵ�յ����,,���鷳����д��
        
    //     int temp=left.val;
    //     left.val=right.val;
    //     right.val=temp;
    //     /*left=right;
    //     right=temp;*///û�н����������Ľṹ
    //     invertTree(root.left);
    //     invertTree(root.right);
    //     return root;
         
    // }
    
}