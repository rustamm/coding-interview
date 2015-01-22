package algorithms.strings;

/**
 * Created by Rustam Miftakhutdinov on 24.11.14.
 */
public class NaiveStringMatcher implements StringMatcher {
    @Override
    public int Find(String needle, String haystack) {
        int m = needle.length();
        int n = haystack.length();

        if (n < m)
            return -1;

        for(int startPos = 0; startPos <= n - m; startPos++) {
            boolean hadMismatch = false;
            for (int i = 0; i < m; i++) {
                if (needle.charAt(i) != haystack.charAt(startPos + i)) {
                    hadMismatch = true;
                    break;
                }
            }

            if (!hadMismatch) {
                return startPos;
            }
        }

        return -1;
    }
}
