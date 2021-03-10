package practise.string;

public class GnomeSeq {

    public static void main(String[] args) {
        String[] gnome = {"ACCGA", "CCGAA", "CGAAG", "GAAGC", "AAGCT"};
        System.out.println(getGnomeSeq(gnome));
    }

    private static String getGnomeSeq(String[] seq) {
        String prevSeq = seq[0];
        StringBuilder sb = new StringBuilder(prevSeq);
        for (String currSeq : seq) {
            sb.append(partOfSeqNotPresent(prevSeq, currSeq));
            prevSeq = currSeq;
        }
        return sb.toString();
    }

    private static String partOfSeqNotPresent(String prevSeq, String curSeq) {
        int left = 0, right = curSeq.length();
        while (left != right) {
            if (!prevSeq.contains(curSeq.substring(left, right)))
                right--;
            break;
        }
        return curSeq.substring(right);
    }
}
