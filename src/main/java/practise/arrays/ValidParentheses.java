package practise.arrays;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{}()[]"));
        System.out.println(isValid("{}()[]"));
        System.out.println(isValid("{([])}"));
        System.out.println(isValid("{{{{}}}}"));
        System.out.println(isValid("{}()[)"));
        System.out.println(isValid("]"));
    }

    private static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                brackets.push(c);
            else {
                switch(c) {
                    case ')': {
                        if (checkIfPresent(brackets, '(')) break;
                        return false;
                    }
                    case '}': {
                        if (checkIfPresent(brackets, '{')) break;
                        return false;
                    }
                    case ']': {
                        if (checkIfPresent(brackets, '[')) break;
                        return false;
                    }
                }
            }
        }
        return (brackets.isEmpty()) ? true : false;
    }

    private static boolean checkIfPresent(Stack<Character> brackets, char c2) {
        if (!brackets.isEmpty() && brackets.peek() == c2) {
            brackets.pop();
            return true;
        }
        return false;
    }
}
