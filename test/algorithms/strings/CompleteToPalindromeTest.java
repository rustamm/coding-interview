package algorithms.strings;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Rustam Miftakhutdinov on 02.12.14.
 */
public class CompleteToPalindromeTest {

    @Test
    public void testGetCharactersToPalindrome() throws Exception {
        Assert.assertEquals(0, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome(""));
        Assert.assertEquals(0, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome("a"));
        Assert.assertEquals(1, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome("ab"));
        Assert.assertEquals(0, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome("bab"));
        Assert.assertEquals(1, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome("ababac"));
        Assert.assertEquals(3, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome("ababrc"));
        Assert.assertEquals(2, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome("barrabas"));
        Assert.assertEquals(1, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome("barraba"));
    }

    @Test
    public void testGetCharactersToPalindrome2() throws Exception {
        Assert.assertEquals(5, CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome("aaahzaaa"));
    }

    @Test
    public void testThereIsNothingToAddToPalindrome() throws Exception {
        Random rand = new Random(5);

        for(int length = 0; length < 100; length++) {
            String palindrome = generatePalindrome(rand, length);
            int charactersToPalindrome = CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome(palindrome);

            Assert.assertEquals(0, charactersToPalindrome);
        }
    }

    @Test
    public void testRandomStringCompletedToPalindromeIsPalindromeIndeed() throws Exception {
        Random rand = new Random(5);

        for(int testCase = 0; testCase < 1000; testCase++) {
            int length = rand.nextInt(100);

            String incomplete = generateRandomString(rand, length);
            int charactersToPalindrome = CompleteToPalindrome.getNumberOfCharsToAppendToMakePalindrome(incomplete);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charactersToPalindrome; i++) {
                sb.append(incomplete.charAt(incomplete.length() - i - 1));
            }

            sb.append(incomplete);
            String newPalindrome = sb.toString();

            for (int i = 0; i < newPalindrome.length(); i++) {
                Assert.assertEquals(newPalindrome.charAt(i), newPalindrome.charAt(newPalindrome.length() - i - 1));
            }
        }
    }

    private String generateRandomString(Random rand, int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            char c = (char) ((int)'a' + rand.nextInt(26));
            chars[i] = c;
        }

        return new String(chars);
    }

    private String generatePalindrome(Random rand, int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length / 2; i++) {
            char c = (char) ((int)'a' + rand.nextInt(26));
            chars[i] = c;
            chars[chars.length - i - 1] = c;
        }

        return new String(chars);
    }
}
