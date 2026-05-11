import java.util.ArrayDeque;
import java.util.Queue;

class QueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("peek front: " + queue.peek()); // 10

        while (!queue.isEmpty()) {
            System.out.println("poll: " + queue.poll());
        }
        // 10, 20, 30 — FIFO order
    }
}
