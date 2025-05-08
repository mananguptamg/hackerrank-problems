import java.util.Scanner;
import java.util.Stack;

public class Problem3 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public Problem3() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        stack1.push(value);
    }

    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public void dequeue() {
        shiftStacks();
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    public int peek() {
        shiftStacks();
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Problem3 queue = new Problem3();

        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int value = sc.nextInt();
                queue.enqueue(value);
            } else if (queryType == 2) {
                queue.dequeue();
            } else if (queryType == 3) {
                System.out.println(queue.peek());
            }
        }
    }
}
