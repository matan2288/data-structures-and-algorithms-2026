import java.util.Stack;

public class Main {

    // Q8: Complete the method to evaluate a string representing an arithmetic
    // expression in reverse Polish (postfix) notation.
    // The string contains digits '0'-'9' and operators '+', '-', '*', '/'.
    //
    // Examples:
    // "12+" → 3
    // "43*" → 12
    // "123+*" → 5
    // "123*+" → 7
    // "12+3*" → 9
    //
    // Use Stack<Integer>:
    // Stack<Integer> stk = new Stack<>();
    // stk.push(5); // push onto top
    // int n = stk.pop(); // pop from top
    // stk.empty() // check if empty
    public static int evaluate(String postfixExpr) {

        char[] stack = new char[postfixExpr.length()];

        for (int i = 0; i < postfixExpr.length(); i++) {

            if (postfixExpr.charAt(i) == "+") {

                for (int j = postfixExpr.length() - 1; j != 0; j--) {

                }
            } else {
                stack[i] = postfixExpr.charAt(i);
            }
        }

        return 5;

    }

    public static void main(String[] args) {
        String tst = "12+";
        evaluate(tst);
    }
}
