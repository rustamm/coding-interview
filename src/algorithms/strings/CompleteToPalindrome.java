package algorithms.strings;

/**
 * Created by Rustam Miftakhutdinov on 02.12.14.
 */
public class CompleteToPalindrome {

    /**
     * Returns the minimum number of characters that need to be appended to str from the left
     * to make a palindrome.
     */
    public static int getNumberOfCharsToAppendToMakePalindrome(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int[] pie = calculatePrefixFunction(str);
        int k = -1;
        pie[0] = -1;

        for (int i = 0; i < str.length(); i++) {
            while (k > -1 && str.charAt(k + 1) != str.charAt(str.length() - i - 1)) {
                k = pie[k];
            }

            if (str.charAt(k + 1) == str.charAt(str.length() - i - 1)) {
                k++;
            }

            if (str.length() - i - 1 - k <= 2) {
                return i - k;
            }
        }

        return str.length();
    }

    private static int[] calculatePrefixFunction(String str) {
        int[] pie = new int[str.length()];
        int k = -1;
        pie[0] = -1;

        for (int i = 1; i < str.length(); i++) {
            while (k > -1 && str.charAt(k + 1) != str.charAt(i)) {
                k = pie[k];
            }

            if (str.charAt(k + 1) == str.charAt(i)) {
                k++;
            }

            pie[i] = k;
        }

        return pie;
    }
}
