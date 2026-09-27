import java.util.Stack;

public class w3_tailop_25020227 {

    public static String evaluatePostfix(String s) {
        Stack<String> stack = new Stack<>();
        String ans = "";

        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                String digit = "";

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    digit += s.charAt(i);
                    i++;
                }

                ans += digit + " ";
            }
            else {
                char op = s.charAt(i);
                while (!stack.isEmpty()
                        && priority(stack.peek().charAt(0)) >= priority(op)) {

                    ans += stack.pop() + " ";
                }

                stack.push(String.valueOf(op));
                i++;
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop() + " ";
        }

        return ans;
    }

    static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }

        if (op == '*' || op == '/') {
            return 2;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("20 + 10 * 5 - 3"));
    }
}