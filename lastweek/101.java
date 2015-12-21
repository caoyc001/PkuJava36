public class Solution {
public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		TreeNode[] nodelist = new TreeNode[] { root.left, root.right };
		return isSymmetricNodeList(nodelist);       
    }

public boolean isSymmetricNodeList(TreeNode[] nodelist) {
		int newlen = nodelist.length * 2;
		TreeNode[] newnodelist = new TreeNode[newlen];
		boolean flag=false;
		int lastindex=nodelist.length-1;
		for (int i = 0; i < nodelist.length / 2; i++) {
			
			if(nodelist[i]==null && nodelist[lastindex-i]==null)
				continue;
			if(nodelist[i]==null && nodelist[lastindex-i]!=null)
				return false;
			if(nodelist[i]!=null && nodelist[lastindex-i]==null)
				return false;
			flag=true;
			if(nodelist[i].val==nodelist[lastindex-i].val)
			{
				newnodelist[2*i]=nodelist[i].left;
				newnodelist[2*i+1]=nodelist[i].right;
				int j=lastindex-i;
				newnodelist[2*j]=nodelist[j].left;
				newnodelist[2*j+1]=nodelist[j].right;
				
			}
			else {
				return false;
			}
		}
		if (flag) {
			return isSymmetricNodeList(newnodelist);
		}

		return true;
}
}