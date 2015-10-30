class MyQueue {
    private Stack<Integer> stack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	Stack<Integer> left= new Stack<Integer>();
    	while (stack.size()>1){
    		left.push(stack.pop());
		}
    // 	stack=left;
        stack=new Stack<Integer>();
    	while (left.size()>0)
    	{
    		stack.push(left.pop());
    	}
    }

    // Get the front element.
    public int peek() {
    	Stack<Integer> left= new Stack<Integer>();
    	while (stack.size()>1){
    		left.push(stack.pop());
		}
    	int result=stack.pop();
    // 	stack=left;
    	stack.push(result);
    	while (left.size()>0)
    	{
    		stack.push(left.pop());
		}
    	return result;
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.size()==0?true:false;
    }
}