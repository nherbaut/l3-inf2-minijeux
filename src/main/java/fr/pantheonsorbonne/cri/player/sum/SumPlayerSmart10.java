package fr.pantheonsorbonne.cri.player.sum;

import fr.pantheonsorbonne.cri.grid.sum.GridSum;

public class SumPlayerSmart10 extends SumPlayerSmart {
    public SumPlayerSmart10(String name) {
        super(name);
    }

    @Override
    protected boolean playOpening(GridSum gridSum) {
        if (gridSum.isEmpty()) {
            gridSum.set(1, 1, 4);
            return true;
        }
        return false;
    }

    @Override
    protected int getTargetSum() {
        return 10;
    }
}
