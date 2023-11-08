package fr.pantheonsorbonne.cri.player.sum;

import fr.pantheonsorbonne.cri.player.DumbPlayer;

public class SumPlayerDumb extends DumbPlayer {


    public SumPlayerDumb(String name) {
        super(name);
    }

    @Override
    protected Integer[] getPlayables() {
        return new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }


}
