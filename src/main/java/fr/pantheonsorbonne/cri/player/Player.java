package fr.pantheonsorbonne.cri.player;

import fr.pantheonsorbonne.cri.grid.Grid;

public abstract class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void play(Grid grid);

    public String getName() {
        return this.name;
    }
}
