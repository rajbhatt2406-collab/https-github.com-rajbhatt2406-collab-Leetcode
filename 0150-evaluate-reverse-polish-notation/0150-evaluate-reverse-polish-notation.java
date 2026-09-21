class Solution {
    public int evalRPN(String[] tokens) {

    Stack<Integer> stack = new Stack<>();
    int ans = 0;

    for (int i = 0; i < tokens.length; i++) {

        if (tokens[i].equals("+")) {
            ans = stack.pop() + stack.pop();
            stack.push(ans);
        }

        else if (tokens[i].equals("-")) {
             int a =  stack.pop(); 
            int b = stack.pop();
            ans = b-a;
            stack.push(ans);
        }

        else if (tokens[i].equals("*")) {
            ans = stack.pop() * stack.pop();
            stack.push(ans);
        }

        else if (tokens[i].equals("/")) {
            int a =  stack.pop(); 
            int b = stack.pop();
            ans = b/a;

           
            stack.push(ans);
        }

        else {
            stack.push(Integer.parseInt(tokens[i]));
        }
    }

    return stack.pop();
}
}