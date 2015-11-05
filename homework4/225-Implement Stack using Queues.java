class MyStack {
    
    LinkedList<Integer> queue=new LinkedList<Integer>();
    LinkedList<Integer> squeue=new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(queue.size()!=1){
            squeue.offer(queue.poll());
        }
        queue=squeue;
        squeue=new LinkedList<Integer>();
    }

    // Get the top element.
    public int top() {
        while(queue.size()!=1){
            squeue.offer(queue.poll());
        }
        int x=queue.poll();
        squeue.offer(x);
        queue=squeue;
        squeue=new LinkedList<Integer>();
        return x;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue.size()==0){
            return true;
        }
        return false;
    }
}