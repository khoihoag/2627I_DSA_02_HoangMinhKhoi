import java.util.Stack;
import java.util.Scanner;

public class QueueUsingTwoStacks {
    public static class Queue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public Queue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void enqueue(int x) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }

            stack1.push(x);
        }

        public void dequeue() {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }

            if (!stack2.empty()) {
                stack2.pop();
            }
        }

        public int print() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.peek();
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue queue = new Queue();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                queue.enqueue(x);
            }
            else if (type == 2) {
                queue.dequeue();
            }
            else if (type == 3) {
                System.out.println(queue.print());
            }
        }

        sc.close();
    }
}
