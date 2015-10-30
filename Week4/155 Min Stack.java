class MinStack {
    private Node current;
    private Node lastMin;
    private int min=Integer.MAX_VALUE;
    public void push(int x) {
        Node n=new Node(x);
        n.pre=current;
        if(current!=null)
            current.next=n;
        current=n;
        if(x<=min)
        {
            //这里做标记记录上一个比自己小的min
            current.lastMin=lastMin;
            lastMin=current;
            min=x;
        }
    }

    public void pop() {
	//取出的如果是min，要修改当前的min
        if(current!=null)
        {
            if(current.val==min)
            {
                lastMin=current.lastMin;
                if(lastMin!=null)
                {
                	min=lastMin.val;
                }
                else
                	min=Integer.MAX_VALUE;
            }
            current=current.pre;
        }
    }

    public int top() {
        if(current!=null)
        {
            return current.val;
        }
        return 0;
    }

    public int getMin() {
        return min;
    }
}

class Node
{
    public int val;
    public Node next;
    public Node pre;
    public Node lastMin;
    
    public Node(int i){ val=i;}
}