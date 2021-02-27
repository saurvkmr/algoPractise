package practise.arrays;

import java.util.Stack;

public class PractiseMakePerfect {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', ' ', 'c', 'd', ' ', 'e', 'f'};
        System.out.println(combineChars(chars));
    }

    private static String combineChars(char[] chars) {
        Stack<String> sentence = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != ' ')
                sb.append(c);
            else {
                sentence.push(sb.toString());
                sb = new StringBuilder();
            }
        }
        sentence.push(sb.toString());
        sb = new StringBuilder();
        while (!sentence.isEmpty()) {
            sb.append(sentence.pop()).append(" ");
        }
        return sb.toString().trim();
    }
}
