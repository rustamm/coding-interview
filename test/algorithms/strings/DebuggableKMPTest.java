package algorithms.strings;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Rustam Miftakhutdinov on 26.11.14.
 */
public class DebuggableKMPTest {
    @Test
    public void testFind() {
        Assert.assertEquals(4, new KnuthMorrisPrattStringMatcher().Find("rword", "otherword"));
    }
}
