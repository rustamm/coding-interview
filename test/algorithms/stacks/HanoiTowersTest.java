package algorithms.stacks;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Rustam Miftakhutdinov on 18.01.15.
 */
public class HanoiTowersTest {
    @Test
    public void testSolve() throws Exception {
        HanoiTowers towers = new HanoiTowers(5);

        Assert.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4}, towers.getStickElements(0).toArray());
        Assert.assertArrayEquals(new Integer[] { }, towers.getStickElements(1).toArray());
        Assert.assertArrayEquals(new Integer[] { }, towers.getStickElements(2).toArray());

        towers.solve();

        Assert.assertArrayEquals(new Integer[] { }, towers.getStickElements(0).toArray());
        Assert.assertArrayEquals(new Integer[] { }, towers.getStickElements(1).toArray());
        Assert.assertArrayEquals(new Integer[] {0, 1, 2, 3, 4}, towers.getStickElements(2).toArray());
    }
}
