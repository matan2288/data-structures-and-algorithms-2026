import java.util.ArrayDeque;
import java.util.Deque;

class StackExample {

    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        stack.push("first");
        stack.push("second");
        stack.push("third");

        System.out.println("peek (top): " + stack.peek()); // third

        System.out.println("pop: " + stack.pop()); // third
        System.out.println("pop: " + stack.pop()); // second
        System.out.println("pop: " + stack.pop()); // first

        System.out.println("isEmpty: " + stack.isEmpty());
    }
}
