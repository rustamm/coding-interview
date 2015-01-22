package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rustam Miftakhutdinov on 07.01.15.
 */
public class PatternMatcherTest {
    @Test
    public void testIsMatchSuccess() throws Exception {
        Assert.assertTrue(PatternMatcher.isMatch("abc", "abc"));
        Assert.assertTrue(PatternMatcher.isMatch("abc", "ab*"));
        Assert.assertTrue(PatternMatcher.isMatch("abcabc", "ab*"));
        Assert.assertTrue(PatternMatcher.isMatch("dbca", "*ca"));
        Assert.assertTrue(PatternMatcher.isMatch("duck", "d??k"));
        Assert.assertTrue(PatternMatcher.isMatch("", "***"));
        Assert.assertTrue(PatternMatcher.isMatch("a", "**?*"));
        Assert.assertTrue(PatternMatcher.isMatch("aabananaabananaaaaaa", "*b?na*na***"));
    }

    @Test
    public void testIsMatchFailure() throws Exception {
        Assert.assertFalse(PatternMatcher.isMatch("abc", "abd"));
        Assert.assertFalse(PatternMatcher.isMatch("testtesttest", "*tesp*"));
        Assert.assertFalse(PatternMatcher.isMatch("", "*tesp*"));
    }
}