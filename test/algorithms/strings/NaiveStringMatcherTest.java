package algorithms.strings;

/**
 * Created by Rustam Miftakhutdinov on 24.11.14.
 */
public class NaiveStringMatcherTest extends StringMatcherTest {

    public NaiveStringMatcherTest(String needle, String haystack, int expectedIndex) {
        super(needle, haystack, expectedIndex);
    }

    @Override
    protected StringMatcher getInstance() {
        return new NaiveStringMatcher();
    }
}
