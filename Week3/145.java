//后序遍历
//
//需要对右子树的根进行跟踪
//这里叶子节点没有flag，可以用hash缓存
//不写了
//
//直接反后序做了

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>() ;
	    while(root!=null || !stack.empty())
	    {
    	    while(root!=null)
    	    {
        	    result.add(root.val);
        	    if(root.left!=null)
        	        stack.push(root.left);
        	    root=root.right;
    	    }
    	    if(!stack.empty())
    	    	root=stack.pop();
    	    
	    }
	    Collections.reverse(result);
	    return result;
    }