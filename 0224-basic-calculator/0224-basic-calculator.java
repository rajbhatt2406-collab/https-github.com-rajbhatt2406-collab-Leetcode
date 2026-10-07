import java.util.*;

class Solution {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Number
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            // Addition
            else if (c == '+') {
                result = result + sign * number;
                number = 0;
                sign = 1;
            }

            // Subtraction
            else if (c == '-') {
                result = result + sign * number;
                number = 0;
                sign = -1;
            }

            // Opening bracket
            else if (c == '(') {

                // Save current result
                stack.push(result);

                // Save current sign
                stack.push(sign);

                result = 0;
                sign = 1;
            }

            // Closing bracket
            else if (c == ')') {

                // Complete expression inside brackets
                result = result + sign * number;
                number = 0;

                // Get sign before '('
                int previousSign = stack.pop();

                // Get result before '('
                int previousResult = stack.pop();

                // Combine
                result = previousResult + previousSign * result;
            }
        }

        // Add last number
        result = result + sign * number;

        return result;
    }
}