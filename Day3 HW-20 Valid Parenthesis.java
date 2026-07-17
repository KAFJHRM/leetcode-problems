import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If it's a closing bracket, it must match the top of the stack
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}
