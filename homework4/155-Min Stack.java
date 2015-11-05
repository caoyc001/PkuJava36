class MinStack {
    private Stack<Integer> stack=new  Stack<Integer>();
    private Stack<Integer> minStack=new Stack<Integer>();
    public void push(int x) {
        if(minStack.empty() || minStack.peek()>=x){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(!stack.empty()){
           // if(stack.peek()==minStack.peek()){//等号比较地址！！！
           if(stack.peek().equals(minStack.peek())){
                minStack.pop();
            }
            stack.pop();
        }
        
    }

    public int top() {
         
            return stack.peek();
        
        
    }

    public int getMin() { 
            return minStack.peek();
        
        
        //clone了对象的地址，同样会改变stack的内容
       // Stack<Integer> stack2=stack;
       /*Stack<Integer> stack2=new  Stack<Integer>();
       stack2= (Stack<Integer>)stack.clone();
        int temp=stack2.pop();
      //  while(stack!=null){
       while(!stack2.empty()){
            if(stack2.peek()<temp){
                temp=stack2.pop();
            }
        }
        return temp;*/ 
       
    }
}
