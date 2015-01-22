package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rustam Miftakhutdinov on 03.12.14.
 */
public class ReverseAllWordsTest {
    @Test
    public void testReverseAllWords() throws Exception {
        Assert.assertEquals("", ReverseAllWords.reverseAllWords(""));
        Assert.assertEquals("moor", ReverseAllWords.reverseAllWords("room"));
        Assert.assertEquals("nur yob nur", ReverseAllWords.reverseAllWords("run boy run"));
        Assert.assertEquals("kcuf eht metsys", ReverseAllWords.reverseAllWords("fuck the system"));
    }
}
