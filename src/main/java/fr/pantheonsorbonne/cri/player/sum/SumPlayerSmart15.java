package fr.pantheonsorbonne.cri.player.sum;

import fr.pantheonsorbonne.cri.grid.sum.GridSum;

public class SumPlayerSmart15 extends SumPlayerSmart {
    public SumPlayerSmart15(String name) {
        super(name);
    }

    @Override
    protected boolean playOpening(GridSum grid) {
        if (grid.isEmpty()) {
            grid.set(1, 1, 9);
            return true;
        }
        return false;
    }

    @Override
    protected int getTargetSum() {
        return 15;
    }
}
