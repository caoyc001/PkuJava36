class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	Queue<Integer> nextqueue= new LinkedList<Integer>();
    	while(queue.size()>1)
    	{
    		nextqueue.offer(queue.poll());
    	}
    	queue=nextqueue;
    }

    // Get the top element.
    public int top() {
    	Queue<Integer> nextqueue= new LinkedList<Integer>();
    	while(queue.size()>1)
    	{
    		nextqueue.offer(queue.poll());
    	}
    	Queue<Integer> popqueue=queue;
    	queue=nextqueue;
    	queue.offer(popqueue.peek());
    	return popqueue.poll();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size()==0?true:false;
    }
}