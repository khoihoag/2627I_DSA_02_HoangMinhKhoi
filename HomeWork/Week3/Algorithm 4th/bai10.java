import java.util.Scanner;
import java.util.Stack;

public class bai10 {

    private static int Uutien(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    public static String Postfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (c == ' ')
                continue;
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && Uutien(c) <= Uutien(stack.peek())) {

                    postfix.append(stack.pop());
                }

                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap bieu thuc trung to: ");
        String sb = sc.nextLine();

        System.out.println("Bieu thuc hau to: " + Postfix(sb));

        sc.close();
    }
}