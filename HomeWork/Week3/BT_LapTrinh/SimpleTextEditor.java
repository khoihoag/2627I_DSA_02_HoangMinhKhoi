import java.io.*;
import java.util.*;
public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        StringBuilder text = new StringBuilder();

        Stack<String> stack = new Stack<>();
        stack.push("");

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                String s = sc.next();

                stack.push(text.toString());
                text.append(s);

            } else if (type == 2) {
                int k = sc.nextInt();

                stack.push(text.toString());
                text.delete(text.length() - k, text.length());

            } else if (type == 3) {
                int k = sc.nextInt();

                System.out.println(text.charAt(k - 1));

            } else if (type == 4) {
                text = new StringBuilder(stack.pop());
            }
        }

        sc.close();
    }

}
