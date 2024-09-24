package Lab1;
import java.util.Stack;

public class RecognizeLanguage {

    public static String recognizeLanguage(String inputString) {
        Stack<Character> stack = new Stack<>();

        for (char ch : inputString.toCharArray()) {
            if (ch == '0') {
                stack.push('0');
            } else if (ch == '1') {
                if (!stack.isEmpty() && stack.peek() == '0') {
                    stack.pop();
                } else {
                    return "No";
                }
            } else {
                // Invalid character in the input
                return "No";
            }
        }

        if (stack.isEmpty()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String inputString = "001100";
        String result = recognizeLanguage(inputString);
        System.out.println("Result: " + result);
    }
}
