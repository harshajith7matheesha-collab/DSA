
import java.util.Stack;

public class StackQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int value) {
        s1.push(value);
        System.out.println(value + " enqueued");
    }

    public int dequeue() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int removed = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return removed;
    }

    public int peek() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int front = s2.peek();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return front;
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
    }
}
