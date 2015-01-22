package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rustam Miftakhutdinov on 03.12.14.
 */
public class SumBinaryStringsTest {
    @Test
    public void testSumBinaryStrings() throws Exception {
        Assert.assertEquals("10", SumBinaryStrings.sumBinaryStrings("1", "1"));
        Assert.assertEquals("100", SumBinaryStrings.sumBinaryStrings("1", "11"));
        Assert.assertEquals("11", SumBinaryStrings.sumBinaryStrings("1", "10"));
    }
}
