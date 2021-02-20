package practise.misc;

public class FizzBuzz {

    public static void main(String[] args) {
        fizzBuzz();
    }

    private static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            String output = "";
            if (i % 3 == 0) output = "fizz";
            if (i % 5 == 0) output += "buzz";
            if (output.equals("")) output = String.valueOf(i);
            System.out.println(output);
        }
    }
}
