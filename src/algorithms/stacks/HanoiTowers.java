package algorithms.stacks;

import java.util.*;

/**
 * Created by Rustam Miftakhutdinov on 18.01.15.
 */
public class HanoiTowers {

    private final ArrayList<Stack> sticks;

    private final int disksCount;

    public HanoiTowers(int numDisks) {
        this.sticks = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            this.sticks.add(new Stack());
        }

        for (int i = numDisks - 1; i >= 0; i--) {
            java.util.Stack<Integer> s = new java.util.Stack<>();
            this.sticks.get(0).push(i);
        }

        this.disksCount = numDisks;
    }

    public void solve() {
        this.moveTower(this.disksCount, 0, 2);
    }

    private void moveTower(int disksToMove, int from, int to) {
        if (disksToMove == 1) {
            this.moveTopDisk(from, to);
            return;
        }

        this.moveTower(disksToMove - 1, from, 3 - from - to);

        this.moveTopDisk(from, to);

        this.moveTower(disksToMove - 1, 3 - from - to, to);
    }

    private void moveTopDisk(int from, int to) {
        int disk = this.sticks.get(from).pop();
        assert this.sticks.get(to).getSize() == 0 || disk < this.sticks.get(to).peek();
        this.sticks.get(to).push(disk);
    }

    public List<Integer> getStickElements(int i) {
        return sticks.get(i).getAllElements();
    }
}
