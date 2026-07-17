import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        // Rotate the queue to make the newly added element the front element
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }
    
    // Removes the element on top of the stack and returns that element.
    public int pop() {
        return queue.remove();
    }
    
    // Get the top element.
    public int top() {
        return queue.peek();
    }
    
    // Returns whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
