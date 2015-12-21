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
    public boolean isBalanced(TreeNode root) {
        
        //recursion is so difficult,待续~~~~~~
        if(root==null){
            return true;
        }
        
        if(root.left==null && root.right==null){
            return true;
        }
        
        if(Math.abs(depth(root.left)-depth(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(depth(node.left),depth(node.right));//每递归一次，高度升1
    }
}
    
    
   /* public boolean depthSearch(TreeNode root, int[] a){
        root.val=1;
        //a[0]为深度最大值，a[1]深度最小值
        if(a[0]-a[1]>1){
            return false;
        }
        if(root.left!=null){
            root.left.val=root.val+1;
            depthSearch(root.left,a);
        }
        if(root.right!=null){
            root.right.val=root.val+1;
            depthSearch(root.right,a);
        }
        if(a[0]==0 && a[1]==0){
            a[0]=root.val;
            a[1]=root.val;
        }else{
            if(root.val>a[0]){
                a[0]=root.val;
            }
            if(root.val<a[1]){
                a[1]=root.val;
            }
        }
        return true;
    }
}
*/
        
        ///只能判断单一左右子树，没办法判断整体
        
        /*if((root.left!=null) && (root.right!=null)){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        if(root.left==null && root.right==null){
            return true;
        }
        if(root.left!=null && root.right==null){
            TreeNode node=root.left;
            if(node.left!=null || node.right!=null){
                return false;
            }
            return true;
        }
        
        if(root.left==null && root.right!=null){
            TreeNode node=root.right;
            if(node.left!=null || node.right!=null){
                return false;
            }
            return true;
        }
        return false;
    }
}*/