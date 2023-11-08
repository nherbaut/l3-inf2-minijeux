package fr.pantheonsorbonne.cri.player.sum;

import fr.pantheonsorbonne.cri.grid.sum.SumGrid;

public class Smart10SumPlayer extends SmartSumPlayer {
    public Smart10SumPlayer(String name) {
        super(name);
    }

    @Override
    protected boolean playOpening(SumGrid sumGrid) {
        if (sumGrid.isEmpty()) {
            sumGrid.set(1, 1, 4);
            return true;
        }
        return false;
    }

    @Override
    protected int getTargetSum() {
        return 10;
    }
}
