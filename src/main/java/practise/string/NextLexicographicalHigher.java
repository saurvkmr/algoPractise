package practise.string;

public class NextLexicographicalHigher {
    public static void main(String[] args) {
        NextLexicographicalHigher lexicographicalHigher = new NextLexicographicalHigher();
        System.out.println(lexicographicalHigher.getNextLexicographicalHigherWord("abdc"));
    }

    public String getNextLexicographicalHigherWord(String word) {
        char[] charArr = word.toCharArray();
        int len = charArr.length;
        int i = len - 1;
        while (i > 0 && (charArr[i] <= charArr[i - 1]))
            i--;

        if (i <= 0)
            return word;

        int j = len - 1;
        while (j > 0 && (charArr[i - 1] >= charArr[j]))
            j--;

        char temp = charArr[j];
        charArr[j] = charArr[i - 1];
        charArr[i - 1] = temp;


        j = charArr.length - 1;
        while (i < j) {
            temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : charArr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
