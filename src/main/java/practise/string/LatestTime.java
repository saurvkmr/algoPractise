package practise.string;

// https://leetcode.com/contest/weekly-contest-225/problems/latest-time-by-replacing-hidden-digits/
public class LatestTime {
    public static void main(String[] args) {
        System.out.println(maxTime("2?:?0"));
        System.out.println(maxTime("0?:3?"));
        System.out.println(maxTime("1?:22"));
        System.out.println(maxTime("?0:22"));
        System.out.println(maxTime("??:??"));
    }

    private static String maxTime(String time) {
        char[] c = time.toCharArray();
        if (c[0] == '?') {
            c[0] = c[1] < '4' || c[1] == '?' ? '2' : '1';
        }

        if (c[1] == '?') {
            c[1] = c[0] == '2' ? '3' : '9';
        }

        if (c[3] == '?') {
            c[3] = '5';
        }

        if (c[4] == '?') {
            c[4] = '9';
        }

        return new String(c);


    }

    private static String latestTime(String time) {
        StringBuilder sb = new StringBuilder();
        if (time.charAt(0) == '?') {
            char c = time.charAt(1);
            if (Character.isDigit(c)) {
                if (Integer.valueOf(c) <= 51)
                    sb.append("2");
                else
                    sb.append("1");
            } else
                sb.append("2");
        } else {
            sb.append(time.charAt(0));
        }

        if (time.charAt(1) == '?') {
            char c = time.charAt(0);
            if (Character.isDigit(c) && Integer.valueOf(c) <= 49)
                sb.append("9");
            else
                sb.append("3");
        } else {
            sb.append(time.charAt(1));
        }
        sb.append(":");
        if (time.charAt(3) == '?') {
            sb.append("5");
        } else {
            sb.append(time.charAt(3));
        }
        if (time.charAt(4) == '?') {
            sb.append("9");
        } else {
            sb.append(time.charAt(4));
        }
        return sb.toString();
    }
}
