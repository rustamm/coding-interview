package algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rustam Miftakhutdinov on 24.11.14.
 */
public class KnuthMorrisPrattStringMatcher implements StringMatcher {

    public int Find(String needle, String hayStack) {
        return KMP_algo(needle, hayStack);
    }

    private int KMP_algo(String needle, String haystack) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        List<Integer> results = new ArrayList<>();
        int[] pie = computePrefixFunction(needle);
        int q = -1;
        for(int i = 0; i < haystack.length(); i++) {
            while(q > -1 && needle.charAt(q + 1) != haystack.charAt(i)) {
                q = pie[q];
            }

            if (needle.charAt(q + 1) == haystack.charAt(i)) {
                q++;
            }

            if (q == needle.length() - 1) {
                results.add(i - q);
                q = pie[q];
            }
        }

        return results.size() > 0 ? results.get(0) : -1;
    }

    private int[] computePrefixFunction(String needle) {
        int[] pie = new int[needle.length()];
        int k = -1;
        pie[0] = -1;
        for (int q = 1; q < needle.length(); q++) {
            while (k > -1 && needle.charAt(k + 1) != needle.charAt(q)) {
                k = pie[k];
            }

            if (needle.charAt(k + 1) == needle.charAt(q)) {
                k++;
            }

            pie[q] = k;
        }

        return pie;
    }

}
