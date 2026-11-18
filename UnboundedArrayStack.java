
public class UnboundedArrayStack {
    private int[] arr;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            resize(capacity * 2);
        }

        arr[++top] = value;
        System.out.println(value + " pushed");
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int value = arr[top--];

        if (capacity > 2 && top + 1 <= capacity / 4) {
            resize(Math.max(2, capacity / 2));
        }

        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return arr[top];
    }

    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        capacity = newCapacity;

        System.out.println("Array resized to: " + capacity);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top: " + stack.peek());

        System.out.println("Size: " + stack.size());
    }
}
