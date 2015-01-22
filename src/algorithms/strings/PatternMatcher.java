package algorithms.strings;

/**
 * Created by Rustam Miftakhutdinov on 07.01.15.
 */
public class PatternMatcher {
    public static boolean isMatch(String input, String pattern) {
        boolean[][] results = new boolean[input.length() + 1][pattern.length() + 1];

        for (int j = pattern.length(); j >= 0; j--) {
            for (int i = input.length(); i >= 0; i--) {
                if (i == input.length() && j == pattern.length()) {
                    results[i][j] = true;
                } else if (i == input.length()) {
                    results[i][j] = pattern.charAt(j) == '*' && results[i][j + 1];
                } else if (j == pattern.length()) {
                    results[i][j] = false;
                } else {
                    char inputChar = input.charAt(i);
                    char patternChar = pattern.charAt(j);

                    if (patternChar == '?' || (patternChar == inputChar && patternChar != '*')) {
                        results[i][j] = results[i + 1][j + 1];
                    } else if (patternChar == '*') {
                        results[i][j] = results[i + 1][j] || results[i][j + 1];
                    } else {
                        results[i][j] = false;
                    }
                }
            }
        }

        return results[0][0];
    }
}
