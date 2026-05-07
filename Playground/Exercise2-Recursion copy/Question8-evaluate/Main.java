import java.util.Stack;

public class Main {

    // Q8: Complete the method to evaluate a string representing an arithmetic
    // expression in reverse Polish (postfix) notation.
    // The string contains digits '0'-'9' and operators '+', '-', '*', '/'.
    //
    // Examples:
    //   "12+"   → 3
    //   "43*"   → 12
    //   "123+*" → 5
    //   "123*+" → 7
    //   "12+3*" → 9
    //
    // Use Stack<Integer>:
    //   Stack<Integer> stk = new Stack<>();
    //   stk.push(5);       // push onto top
    //   int n = stk.pop(); // pop from top
    //   stk.empty()        // check if empty
    public static int evaluate(String postfixExpr) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < postfixExpr.length(); i++) {
            char c = postfixExpr.charAt(i);
            if (Character.isDigit(c)) {
                stk.push(c - '0');
            } else {
                int b = stk.pop();
                int a = stk.pop();
                if (c == '+') stk.push(a + b);
                else if (c == '-') stk.push(a - b);
                else if (c == '*') stk.push(a * b);
                else stk.push(a / b);
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("12+3*"));
    }
}
