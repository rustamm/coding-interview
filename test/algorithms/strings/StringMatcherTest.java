package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Rustam Miftakhutdinov on 24.11.14.
 */
@RunWith(Parameterized.class)
public abstract class StringMatcherTest {

    private String needle;

    private String haystack;

    private int expectedIndex;

    public StringMatcherTest(String needle, String haystack, int expectedIndex) {
        this.needle = needle;
        this.haystack = haystack;
        this.expectedIndex = expectedIndex;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> testCases = new ArrayList<>();
        testCases.add(new Object[] { "word", "word", 0 });
        testCases.add(new Object[] { "rword", "otherword", 4 });
        testCases.add(new Object[] { "hippopotamus", "hippie_hippopotamus", 7 });
        testCases.add(new Object[] { "word", "some kind of word word word", 13 });
        testCases.add(new Object[] { "", "abcdedf", 0 });
        testCases.add(new Object[] { "", "", 0 });
        testCases.add(new Object[] { "word", "wor", -1 });
        testCases.add(new Object[] { "word", "abcdedf", -1 });
        testCases.add(new Object[] { "wordwork", "wordwordwork", 4 });
        return testCases;
    }

    @Test
    public void testFind() throws Exception {
        StringMatcher algorithm = this.getInstance();
        Assert.assertEquals(this.expectedIndex, algorithm.Find(this.needle, this.haystack));
    }

    protected abstract StringMatcher getInstance();
}
