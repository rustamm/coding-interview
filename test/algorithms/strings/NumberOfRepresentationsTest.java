package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rustam Miftakhutdinov on 03.12.14.
 */
public class NumberOfRepresentationsTest {
    @Test
    public void testGetNumberOfValidSlices() throws Exception {
        Assert.assertEquals(3, NumberOfRepresentations.getNumberOfValidSlices("111"));
        Assert.assertEquals(5, NumberOfRepresentations.getNumberOfValidSlices("1111"));
        Assert.assertEquals(2, NumberOfRepresentations.getNumberOfValidSlices("11"));
        Assert.assertEquals(3, NumberOfRepresentations.getNumberOfValidSlices("123"));
        Assert.assertEquals(2, NumberOfRepresentations.getNumberOfValidSlices("127"));
    }

    @Test
    public void test_ShouldNotBeSlicesWithNumbersGreaterThan26() throws Exception {
        Assert.assertEquals(2, NumberOfRepresentations.getNumberOfValidSlices("127"));
    }

    @Test
    public void test_ShouldNotBeSlicesWithSingleZero() throws Exception {
        Assert.assertEquals(1, NumberOfRepresentations.getNumberOfValidSlices("120"));
    }
}

