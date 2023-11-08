package fr.pantheonsorbonne.cri.player.parity;

import fr.pantheonsorbonne.cri.player.DumbPlayer;

public class ParityDumbPlayer extends DumbPlayer {
    private boolean haveOdds;

    public ParityDumbPlayer(String name, boolean haveOdds) {
        super(name);
        this.haveOdds = haveOdds;
    }

    @Override
    protected Integer[] getPlayables() {
        if (haveOdds) {
            return new Integer[]{2, 4, 6, 8};
        } else {
            return new Integer[]{1, 3, 5, 7, 9};
        }
    }
}
