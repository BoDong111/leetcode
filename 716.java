class MaxStack {

    /** initialize your data structure here. */
    Deque<Integer> stack;
    Deque<Integer> maxstack;
    public MaxStack() {
        stack=new ArrayDeque<>();
        maxstack=new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(maxstack.isEmpty()){
            maxstack.push(x);
        }
        else{
            Integer tmp=maxstack.peek();
            if(tmp<x){
                maxstack.push(x);
            }
            else{
                maxstack.push(tmp);
            }
        }
    }
    
    public int pop() {
        maxstack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxstack.peek();
    }
    
    public int popMax() {
        int max=maxstack.peek();
        Deque<Integer> tmp=new ArrayDeque<>();
        while(stack.peek()!=max){
            tmp.push(stack.pop());
            maxstack.pop();
        }
        maxstack.pop();
        stack.pop();
        while(!tmp.isEmpty()){
            int tmpval=tmp.pop();
            push(tmpval);
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */