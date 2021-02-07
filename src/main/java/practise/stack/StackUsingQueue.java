package practise.stack;

public class StackUsingQueue {

    int[] q;
    int top;

    /**
     * Initialize your data structure here.
     */
    public StackUsingQueue() {
        this.q = new int[100];
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q[top++] = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q[--top];
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q[top-1];
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return top == 0;
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.top());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
