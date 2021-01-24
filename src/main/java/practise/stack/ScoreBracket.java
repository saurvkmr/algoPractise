package practise.stack;

import java.util.Stack;

public class ScoreBracket {
    final static String opening = "(";
    final static String closing = ")";
    public static void main(String[] args) {
        String[] brackets = {"(", "(", ")", "(", "(", ")", ")", ")"};
    }
    static int findScore(String[] brackets) {
        Stack<String> parent = new Stack();
        Stack ops = new Stack();
        Stack<Integer> output = new Stack<>();
        String temp = "";
        for (String s : brackets) {
            if (opening.equals(s)) {
                parent.push(s);
            }
        }

        return 0;
    }
}
