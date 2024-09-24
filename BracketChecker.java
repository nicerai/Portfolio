package Lab1;
import java.util.Scanner;
import java.util.Stack;

public class BracketChecker {

    public static String checkBrackets(String inputString) {
        Stack<Character> stack = new Stack<>();

        for (char ch : inputString.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return "Unbalanced brackets: extra closing bracket found";
                }
                char popped = stack.pop();
                if (!isMatchingPair(popped, ch)) {
                    return "Unbalanced brackets: mismatched opening and closing brackets";
                }
            } else if (!isValidCharacter(ch)) {
                return "Invalid character found: " + ch;
            }
        }

        if (!stack.isEmpty()) {
            return "Unbalanced brackets: extra opening bracket found";
        } else {
            return "Brackets are balanced";
        }
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '[' && closing == ']') ||
               (opening == '{' && closing == '}');
    }

    private static boolean isValidCharacter(char ch) {
        // Valid characters: {, }, [, ], (, ), 0-9, +, -, *, /
        return (ch >= '0' && ch <= '9') || "+-*/(){}[]".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an arithmetic expression: ");
        String inputExpression = scanner.nextLine();

        String result = checkBrackets(inputExpression);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
