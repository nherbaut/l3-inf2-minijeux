package fr.pantheonsorbonne.cri.player.sum;

import fr.pantheonsorbonne.cri.grid.sum.SumGrid;

public class Smart15SumPlayer extends SmartSumPlayer {
    public Smart15SumPlayer(String name) {
        super(name);
    }

    @Override
    protected boolean playOpening(SumGrid grid) {
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
