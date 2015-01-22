package algorithms.lists;

import org.junit.Assert;
import org.junit.Test;

public class GetKthToLastElementTest {
    @Test
    public void testFindKthToLastElement() throws Exception {
        Node head = Node.create(1, 2, 3, 4, 5);
        Assert.assertEquals(3, GetKthToLastElement.findKthToLastElement(head, 3).getData());
        Assert.assertEquals(5, GetKthToLastElement.findKthToLastElement(head, 1).getData());
        Assert.assertEquals(5, GetKthToLastElement.findKthToLastElement(head, 1).getData());
    }
}
