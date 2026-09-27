import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class BalancedBrackets {
    public static boolean check(String s) {
        Map<Character, Character> map = new HashMap<>(Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        ));
        Stack<Character> stack = new Stack<>();

        for (int i=0; i< s.length(); i++){
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }

                stack.pop();
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        System.out.println(check("(){[](())"));
    }


}
