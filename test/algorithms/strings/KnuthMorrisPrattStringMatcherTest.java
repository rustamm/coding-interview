package algorithms.strings;

/**
 * Created by Rustam Miftakhutdinov on 24.11.14.
 */
public class KnuthMorrisPrattStringMatcherTest extends StringMatcherTest {
    public KnuthMorrisPrattStringMatcherTest(String needle, String haystack, int expectedIndex) {
        super(needle, haystack, expectedIndex);
    }

    @Override
    protected StringMatcher getInstance() {
        return new KnuthMorrisPrattStringMatcher();
    }
}
