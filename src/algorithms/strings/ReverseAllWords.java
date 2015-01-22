package algorithms.strings;

/**
 * Created by Rustam Miftakhutdinov on 03.12.14.
 */
public class ReverseAllWords {
    public static String reverseAllWords(String input) {
        char[] result = new char[input.length()];

        int lastSpacePos = -1;
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                // copy the revesed word
                for (int j = 0; j < i - lastSpacePos - 1; j++) {
                    result[lastSpacePos + 1 + j] = input.charAt(i - 1 - j);
                }

                lastSpacePos = i;

                if (i < input.length()) {
                    result[i] = ' ';
                }
            }
        }

        return new String(result);
    }
}
