package algorithms.strings;

/**
 * Created by Rustam Miftakhutdinov on 03.12.14.
 */
public class SumBinaryStrings {
    public static String sumBinaryStrings(String left, String right) {
        StringBuilder sb = new StringBuilder();

        int maxLength = Math.max(left.length(), right.length());

        boolean overflow = false;

        for (int pos = 0; pos < maxLength; pos++) {
            int val = 0;
            if (pos < left.length() && left.charAt(left.length() - pos - 1) == '1') {
                val++;
            }

            if (pos < right.length() && right.charAt(right.length() - pos - 1) == '1') {
                val++;
            }

            if (overflow) {
                val++;
            }

            sb.append(val % 2 == 0 ? '0' : '1');
            overflow = val > 1;
        }

        if (overflow) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

}
